package com.controller.design.responseentity;


import java.io.Serializable;

public class Response<T>  implements Serializable {
    private String status;
    private T messageBody;

    public Response(){}

    public Response(String status, T messageBody){
        this.status=status;
        this.messageBody=messageBody;
    }

    public String getStatus() {
        return status;
    }

    public T getMessageBody() {
        return messageBody;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessageBody(T messageBody) {
        this.messageBody = messageBody;
    }
}
