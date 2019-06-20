package com.hb.vo;

import lombok.Data;

/**
 * 返回值对象
 */
@Data
public class SysResult {
    private String msg;     //描述短语
    private int status;     //200->成功 201->失败
    private Object data;    //封装数据

    private SysResult(){

    }
    private SysResult(String msg, int status, Object data) {
        this.msg = msg;
        this.status = status;
        this.data = data;
    }

    /**
     * 成功返回
     * @param msg
     * @param data
     * @return
     */
    public static SysResult ok(String msg, Object data){
        return new SysResult(msg, 200, data);
    }

    /**
     * 成功返回
     * @param data
     * @return
     */
    public static SysResult ok(Object data){
        return new SysResult(null, 200, data);
    }

    /**
     * 成功返回
     * @return
     */
    public static SysResult ok(){
        return new SysResult(null, 200, null);
    }

    /**
     * 失败返回
     * @return
     */
    public static SysResult fail(){
        return new SysResult(null, 201, null);
    }

    /**
     * 失败返回
     * @param msg 短语
     * @return
     */
    public static SysResult fail(String msg){
        return new SysResult(msg, 201, null);
    }

}
