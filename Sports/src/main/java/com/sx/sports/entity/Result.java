package com.sx.sports.entity;
public class Result {
    /**
     * 成功
     */
    public static final int CODE_OK = 200;
    /**
     * 注册错误
     */
    public static final int CODE_ERR_REGISTER = 501;
    /**
     * 用户未登录
     */
    public static final int CODE_ERR_UNLOGINED = 502;
    /**
     * 系统错误
     */
    public static final int CODE_ERR_SYS = 503;
    /**
     * 数据库错误
     */
    public static final int CODE_ERR_DATABASE = 504;
    private int code;
    private boolean success;
    private String message;
    private Object data;
    public Result(int code, boolean success, String message, Object data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public static Result ok(){
        return new Result(CODE_OK,true,null, null);
    }
    public static Result ok(String message){
        return new Result(CODE_OK,true,message, null);
    }
    public static Result ok(Object data){
        return new Result(CODE_OK,true,null, data);
    }
    public static Result ok(String message, Object data){
        return new Result(CODE_OK,true,message, data);
    }
    public static Result err(int errCode, String message){
        return new Result(errCode,false,message, null);
    }
    public static Result err(int errCode,String message,Object data){
        return new Result(errCode,false,message, data);
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}