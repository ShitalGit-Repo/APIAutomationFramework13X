package com.modules.RestfulBooker;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.pojos.requestpojos.RestfulBooker.Auth;
import com.pojos.requestpojos.RestfulBooker.Booking;
import com.pojos.requestpojos.RestfulBooker.BookingDates;
import com.pojos.responsepojos.RestfulBooker.Bookingresponse;
import com.pojos.responsepojos.RestfulBooker.InvalidTokenResponse;
import com.pojos.responsepojos.RestfulBooker.Tokenresponse;

public class PayloadManager {

//Responsibility of POJO is to serialization and deserialization
    Gson gson ;
    Faker faker ;
//Convert the java object into the json string to use as payload - Serialization

    public String createPayloadBookingAsString () {
        Booking booking = new Booking() ;
        booking.setFirstname("shital");
        booking.setLastname("awachar");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates() ;
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalNeeds("Breakfast");

        System.out.println(booking);
        gson = new Gson() ;
        return gson.toJson(booking);
    }
    public String createPayloadBookingAsStringWrongBody () {

        Booking booking = new Booking() ;
        booking.setFirstname("名");
        booking.setLastname("姓");
        booking.setTotalprice(112);
        booking.setDepositpaid(false);

        BookingDates bookingDates = new BookingDates() ;
        bookingDates.setCheckin("5024-02-01");
        bookingDates.setCheckout("5024-02-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalNeeds("Breakfast");

        System.out.println(booking);
//java object -> json
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking ;
    }
    public String createPayloadBookingFakerJS () {
//This option is to to generate name dynamically
        faker = new Faker();
        Booking booking = new Booking() ;
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1,1000));
        booking.setDepositpaid(faker.random().nextBoolean());

        BookingDates bookingDates = new BookingDates() ;
        bookingDates.setCheckin("5024-02-01");
        bookingDates.setCheckout("5024-02-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalNeeds("Breakfast");

        System.out.println(booking);
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking ;
    }

//Convert into the java object from json string - Deserialization
//Converting to java object to verify response body
    public Bookingresponse bookingResponseJava  (String responseString) {
        gson = new Gson();
        Bookingresponse bookingResponse = gson.fromJson(responseString, Bookingresponse.class);
        return bookingResponse ;
    }
    public Booking getResponseFromJSON(String responseString) {
        gson = new Gson();
        Booking bookingResponse = gson.fromJson(responseString, Booking.class);
        return bookingResponse;
    }
    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " + jsonPayloadString);
        return jsonPayloadString;
    }
    // DeSer ( JSON String -> Java Object
    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        Tokenresponse tokenResponse1 = gson.fromJson(tokenResponse, Tokenresponse.class);
        return tokenResponse1.get_token() ;
    }
    // DeSer ( JSON String -> Java Object
    public String getInvalidResponse(String invalidTokenResponse){
        gson = new Gson();
        InvalidTokenResponse tokenResponse1 = gson.fromJson(invalidTokenResponse, InvalidTokenResponse.class);
        return  tokenResponse1.getReason();
    }
}
