package com.checklist.TA.vo;

public class ReturnredValue {
    private String status;
    private Object payload;

    public ReturnredValue(String status, Object payload) {
        this.status = status;
        this.payload = payload;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public ReturnredValue() {
    }
}
