package com.yuan.zhidao.exceptions;

public class UserException extends RuntimeException{
    public UserException(String msg){
        super(msg);
    }

    public UserException(String msg, Throwable t){
        super(msg,t);
    }
}
