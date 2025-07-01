package com.employee.exception;

public class ErrorMessage {

    private String message;
    private int code;
    private String url;

    public ErrorMessage(String message, int code, String url) {
        this.message = message;
        this.code = code;
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
