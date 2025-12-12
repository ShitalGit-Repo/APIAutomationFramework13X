package com.pojos.responsepojos.RestfulBooker;

import com.google.gson.annotations.Expose;

public class Tokenresponse {

    @Expose
    private String token ;
    public String get_token () {return token ;}
    public void setToken (String token) {this.token = token ;}
}
