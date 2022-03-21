package com.cpl.tsl.bean;


import org.apache.poi.ss.formula.functions.T;

public class ResultMap<T> {

    String  message;

    String  status;

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
}
