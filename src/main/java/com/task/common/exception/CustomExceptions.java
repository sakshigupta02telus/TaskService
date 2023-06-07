package com.task.common.exception;

public class CustomExceptions {
    public static class ResourceNotFound extends RuntimeException{
        public ResourceNotFound(String exception){
            super(exception);
        }
        public ResourceNotFound(){
            super("Resource not found");
        }
    }

    public static class BadRequest extends RuntimeException{
        public BadRequest(String exception) { super(exception); }
        public BadRequest() { super("This is default"); }
    }
}
