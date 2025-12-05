package com.pojos.responsepojos.VWO;

import com.google.gson.annotations.SerializedName;

public class InvalidLoginResponse {
    @SerializedName("message")
    private String Message ;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
