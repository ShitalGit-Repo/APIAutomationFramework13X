package com.modules.VWO;


import com.google.gson.Gson ;
import com.pojos.requestpojos.VWO.VWOLoginRequest ;
import com.pojos.responsepojos.VWO.InvalidLoginResponse ;
import com.pojos.responsepojos.VWO.LoginResponse ;

public class VWOPayloadManager {

    Gson gson;

    // Java Object -> JSON
    public String setLoginDataInvalid(){
        VWOLoginRequest loginRequest = new VWOLoginRequest();
        loginRequest.setUsername("contact+aug@thetestingacademy.com");
        loginRequest.setPassword("abc");
        loginRequest.setRemember(false);
        loginRequest.setRecaptchaResponseField("");


        gson = new Gson();
        String jsonPayloadString = gson.toJson(loginRequest);
        System.out.println("Payload Login to the -> " + jsonPayloadString);
        return jsonPayloadString;
    }

    public String setLoginDataValid(){
        VWOLoginRequest loginRequest = new VWOLoginRequest();
        loginRequest.setUsername("contact+aug@thetestingacademy.com");
        loginRequest.setPassword("TtxkgQ!s$rJBk85");
        loginRequest.setRemember(false);
        loginRequest.setRecaptchaResponseField("");


        gson = new Gson();
        String jsonPayloadString = gson.toJson(loginRequest);
        System.out.println("Payload Login to the -> " + jsonPayloadString);
        return jsonPayloadString;
    }

    // DeSer ( JSON String -> Java Object
    public String getLoginDataInvalid(String loginResponseEx){
        gson = new Gson();
        InvalidLoginResponse loginResponse = gson.fromJson(loginResponseEx, InvalidLoginResponse.class);
        return  loginResponse.getMessage();

    }

    // DeSer ( JSON String -> Java Object
    public LoginResponse getLoginDataValid(String loginResponseEx){
        gson = new Gson();
        LoginResponse loginResponse = gson.fromJson(loginResponseEx, LoginResponse.class);
        return  loginResponse;

    }
}
