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

/**
 * 切面编程
 */
@Aspect
@Component
public class CacheAspect {

    @Autowired
    private JedisCluster jedisCluster;

    @Around("@annotation(redis_cache)")
    public Object around(ProceedingJoinPoint jp, Redis_Cache redis_cache){
        //1.获取key
        String key = getKey(jp, redis_cache);
        String result = jedisCluster.get(key);
        Object data = null;
        try {
            //如果从数据库中取不到了数据 则执行目标方法 从数据库中查询
            if(StringUtils.isEmpty(result)){
                data = jp.proceed();
                result = JSONUtil.toJson(data);
                if(redis_cache.seconds() == 0)
                    jedisCluster.set(key, result);
                else
                    jedisCluster.setex(key, redis_cache.seconds(), result);
                System.out.println("查询数据库");
            }else {
                //取到了数据，用JSONUtil工具类把JSON串转换成对象
                data = JSONUtil.toJson(result, getReturnType(jp));
                System.out.println("查询缓存");
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return data;
    }

    /**
     * 传入jp 和 注解
     * @param jp
     * @param redis_cache
     * @return
     */
    private String getKey(ProceedingJoinPoint jp, Redis_Cache redis_cache) {
        //获取value
        String key = redis_cache.value();
        //判断是否为自动拼接
        Key_Type keyType = redis_cache.keyType();
        if(keyType == Key_Type.AUTO){
            key += "_" + jp.getArgs()[0];
        }
        return key;
}

    /**
     * 根据切入点获取该方法的返回值
     * @param jp
     * @return
     */
    private Class getReturnType(ProceedingJoinPoint jp) {

        MethodSignature signature = (MethodSignature) jp.getSignature();
        return signature.getReturnType();
    }


}
