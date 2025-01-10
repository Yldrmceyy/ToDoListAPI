package com.ceylanyildirim.ToDoList.exception;

public class BaseException  extends RuntimeException{
    public BaseException(){

    }
    public BaseException(ErrorMessage errorMessage){
        super(errorMessage.prepareErrorMessage());
    }
}
