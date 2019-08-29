package com.peppa.wick.api.exception;

/**
 * @author zhengguangchen
 */


public class WickException extends RuntimeException {
    private int code;
    private String message;




    public WickException(int errorCode, String message) {
        super(message);
        this.setCode(errorCode);
    }

    public WickException(WickException e) {
        super(e);
    }


    @Override
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
}
