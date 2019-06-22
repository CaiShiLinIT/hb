package com.hb.anno;


import com.hb.enu.Key_Type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Redis_Cache {
    String value(); //指定缓存key
    Key_Type keyType() default Key_Type.AUTO; //默认为自动拼接
    int seconds() default 0; //0代表不限时 单位秒
}