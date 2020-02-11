package com.itdr.common;

/**
 * @author zangye03@gmail.com
 * @date 2020/1/14 23:04
 */

public class ResponseCode<T> {
    private Integer status;
    private T data;
    private String msg;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //多个构造函数
    private ResponseCode(T data){
        this.status = 200;
        this.data = data;
    }

    /**
     *
     * @param status
     * @param msg
     */
    private ResponseCode(Integer status,String msg){
        this.status = 200;
        this.msg = msg;
    }

    private ResponseCode(T data, Integer status) {
        this.data = data;
        this.status = 200;
    }

    private ResponseCode(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    /*
     获取成功的数据以及成功的状态码以及成功的信息
     1获取成功的数据以及成功的状态码
     2获取成功的数据以及成功的信息
     3获取成功的数据
     */
    //成功获取数据的方法
    public static <T> ResponseCode toSuccess(T data){
        return new ResponseCode(data);
    }

    //成功的数据以及成功的状态码
    public static <T> ResponseCode toSuccess(T data,Integer status){
        return new ResponseCode(data,status);
    }

    //获取成功的数据以及成功的信息
    public static <T> ResponseCode toSuccess(T data,String msg){
        return new ResponseCode(data,msg);
    }

    /*
     失败
     1失败信息以及失败状态码
     2失败信息默认状态码
     */
    //失败返回信息的方法
    public static <T> ResponseCode toDefeated(Integer status,String msg){
        return new ResponseCode(status, msg);
    }

    public static <T> ResponseCode toDefeated(String msg){
        return new ResponseCode(100,msg);
    }

    @Override
    public String toString() {
        return "{" +
                "status:" + status +
                ", data:" + data +
                ", msg:'" + msg + '\'' +
                '}';
    }
}
