package com.pojos.requestpojos.VWO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VWOLoginRequest {

    @Expose
    private String password ;
    @SerializedName("recaptcha_response_field")
    private String recaptchaResponseField ;
    @Expose
    private boolean remember ;
    @Expose
    private String username ;

    public String getPassword () {return password;}

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRecaptchaResponseField () {return recaptchaResponseField;}

    public void setRecaptchaResponseField (String recaptchaResponseField){
        this.recaptchaResponseField = recaptchaResponseField ;
    }
    public boolean getRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
