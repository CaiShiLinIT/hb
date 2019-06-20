package com.hb.aspect;

import com.hb.anno.Redis_Cache;
import com.hb.enu.Key_Type;
import com.hb.util.JSONUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCluster;

@Aspect
@Component
public class CacheAspect {

    @Autowired
    private JedisCluster jedisCluster;


    @Around("@annotation(redis_cache)")
    public Object around(ProceedingJoinPoint jp, Redis_Cache redis_cache){
        String key = getKey(jp, redis_cache);
        String result = jedisCluster.get(key);
        Object data = null;
        try {
            if(StringUtils.isEmpty(result)){
                data = jp.proceed();
                result = JSONUtil.toJson(data);
                if(redis_cache.seconds() == 0)
                    jedisCluster.set(key, result);
                else
                    jedisCluster.setex(key, redis_cache.seconds(), result);
                System.out.println("查询数据库");
            }else {
                data = JSONUtil.toJson(result, getReturnType(jp));
                System.out.println("查询缓存");
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return data;
    }

    private String getKey(ProceedingJoinPoint jp, Redis_Cache redis_cache) {
        String key = redis_cache.value();
        Key_Type keyType = redis_cache.keyType();
        if(keyType == Key_Type.AUTO){
            key += "_" + jp.getArgs()[0];
        }
        return key;
}

    /**
     * 根据切入点获取该方法上的参数值
     * @param jp
     * @return
     */
    private Class getReturnType(ProceedingJoinPoint jp) {

        MethodSignature signature = (MethodSignature) jp.getSignature();
        return signature.getReturnType();
    }


}
