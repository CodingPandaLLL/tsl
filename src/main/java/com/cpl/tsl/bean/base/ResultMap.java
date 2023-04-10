package com.cpl.tsl.bean.base;


import com.cpl.tsl.enums.HttpCodeEnum;

public class ResultMap<T> {

    String message;

    String status;

    private T data;

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值.
     */
    public ResultMap<T> success() {
        this.status = String.valueOf(HttpCodeEnum.SUCCESS.getCode());
        this.message = HttpCodeEnum.SUCCESS.getMsg();
        return this;
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值.
     */
    public ResultMap<T> success(T data) {
        this.data = data;
        return success();
    }

    public static <T> ResultMap<T> resultSuccess() {
        return new ResultMap<T>().success();
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值.
     */
    public static <T> ResultMap<T> resultSuccess(Object data) {
        return new ResultMap().success(data);
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值. eg: {@link ResultMap#(int)};
     */
    public ResultMap<T> error(String code) {
        return this.error(code, null, null);
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值. eg: {@link ResultMap#(int, String)};
     */
    public ResultMap<T> error(String code, String msg) {
        return this.error(code, msg, null);
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值. eg:
     * {@link ResultMap#(int, String, T)};
     */
    public ResultMap<T> error(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        return this;
    }

    /**
     * 可请使用静态构造对象再按需变更返回字段值. eg:
     * {@link ResultMap(int, String)};
     */
    public static <T> ResultMap<T> resultError(String code, String msg) {
        return new ResultMap<T>().error(code, msg);
    }

}
