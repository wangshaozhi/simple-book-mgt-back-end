package com.cqupt.bookserver.Bean;

import java.io.Serializable;

/**
 * @ClassName: Response
 * @Description: 返回前端接口响应类
 * @Author: wsz
 * @Date: 2020/3/27 14:53
 * @Version 1.0
 **/
public class Response<T> implements Serializable {

    private static final int CODE_SUCCESS = 200;//请求成功的响应码

    private static final int CODE_FAIL = 500;//请求失败的响应码

    private static final String MSG_SUCCESS = "success";//请求成功的消息

    private static final String MSG_FAIL = "error";//请求失败的消息


    private int code;//响应码

    private String msg;//返回的消息

    private T data;//返回的数据实体


    public Response() {

    }

    public Response(int code) {
        this.code = code;
    }


    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(int code, String msg, T entity) {
        this.code = code;
        this.msg = msg;
        this.data = entity;
    }

    /**
     * @Description 响应成功的静态方法
     * @Date 2020/3/6 10:12
     * @Param []
     * @Return com.cqupt.Util.RestResponseUtil 有响应码和响应消息
     **/
    public static Response success() {
        return new Response(CODE_SUCCESS, MSG_SUCCESS);
    }

    /**
     * @Description 响应成功的静态方法
     * @Date 2020/3/6 10:13
     * @Param [data] 响应的数据实体
     * @Return com.cqupt.Util.RestResponseUtil 返回的前端请求的响应实体类
     **/
    public static Response success(Object data) {
        return new Response(CODE_SUCCESS, MSG_SUCCESS, data);
    }

    /**
     * @Description 请求失败的响应方法
     * @Date 2020/3/6 10:14
     * @Param []
     * @Return com.cqupt.Util.RestResponseUtil 只有响应码和消息的静态方法
     **/
    public static Response fail() {
        return new Response(CODE_FAIL, MSG_FAIL);
    }

    /**
     * @Description 自定义请求错误返回的消息
     * @Date 2020/3/6 10:39
     * @Param [msg] 返回的错误消息
     * @Return com.cqupt.Util.RestResponseUtil
     **/
    public static Response fail(String msg) {
        return new Response(CODE_FAIL, msg);
    }

    /**
     * @Description 请求失败的响应方法
     * @Date 2020/3/6 10:15
     * @Param [data] 响应的数据实体
     * @Return com.cqupt.Util.RestResponseUtil 返回请求失败的响应实体类
     **/
    public static Response fail(Object data) {
        return new Response(CODE_FAIL, MSG_FAIL, data);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
