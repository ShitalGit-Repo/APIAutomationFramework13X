package com.Tests.RestfulBooker.CRUD;

import com.Base.BaseTest;
import com.endpoints.APIConstants;
import com.pojos.responsepojos.RestfulBooker.Bookingresponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Pramod Dutta")
    @Description("TC#1 - Verify that the Booking can be Created")

    public void test_CreateBookingPOST_Positive () {
//Part - 1 - Setup will first and making the request.
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL) ;
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .log().all().post();
//Part - 2 - Extraction
        Bookingresponse bookingresponse = payloadManager.bookingResponseJava(response.asString());
//Part - 3 - Validation and verification via the AssertJ, TestNG
        assertActions.verifyStatusCode(response, 200);
        assertActions.verifyStringKeyNotNull(bookingresponse.getBookingid());
        assertActions.verifyStringKey(bookingresponse.getBooking().getFirstname(), "Shital");
    }
    @Test(groups = "reg", priority = 1)
    @Owner("Pramod Dutta")
    @Description("TC#3 - Verify that the Booking can be Created, When Payload is CHINESE")
    public void testCreateBookingPOST_POSITIVE_CHINESE() {


        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().
                body(payloadManager.createPayloadBookingAsStringWrongBody()).log().all().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Extraction Part - 2
        Bookingresponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
    }

    @Test(groups = "reg", priority = 1)
    @Owner("Amit Sharma")
    @Description("TC#4 - Verify that the Booking can be Created, When Payload is RANDOM")
    public void testCreateBookingPOST_POSITIVE_FAKER_RANDOM_DATA() {
        // Setup and Making a Request.
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingFakerJS()).log().all().post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Bookingresponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBooking().getFirstname());
    }

    @Test(groups = "reg", priority = 1)
    @Owner("Amit Sharma")
    @Description("TC#5 - Verify that the Booking can be Created, When Payload is RANDOM")
    public void testCreateBookingPOST_NEGATIVE_WRONG() {
        // Setup and Making a Request.
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        requestSpecification.contentType(ContentType.HTML);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingFakerJS()).log().all().post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);

    }

    @Test(groups = "reg", priority = 1)
    @Owner("Amit Sharma")
    @Description("TC#6 - Verify that the Booking can be Created, URL is wrong")
    public void testCreateBookingPOST_NEGATIVE_BASE_URL() {
        // Setup and Making a Request.
        requestSpecification.baseUri(APIConstants.APP_VWO_URL);
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        requestSpecification.contentType(ContentType.HTML);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingFakerJS()).log().all().post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);

    }
}
