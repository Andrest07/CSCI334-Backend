package com.csci334.RCMS.exceptions;

public class CustomException extends RuntimeException{
    public CustomException(String name) {
        super("Warning, " + name);
    }
}