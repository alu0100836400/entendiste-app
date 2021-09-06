package com.example.entendiste.io.response;

public class StandardResponse {
    private boolean error;
    private String msg_error;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMsg_error() {
        return msg_error;
    }

    public void setMsg_error(String msg_error) {
        this.msg_error = msg_error;
    }
}
