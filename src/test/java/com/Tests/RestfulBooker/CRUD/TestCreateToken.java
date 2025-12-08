package com.Tests.RestfulBooker.CRUD;

import com.Base.BaseTest;
import com.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {

    @Link ("")
    @Owner("shital")
    @Description ("Verify that post req to create token")

    @Test (groups = "reg", priority = 1)
    public void test_verifyTokenPOST () {

//Automatically have the base URL and the header set
//This URL and header of application, json is automatically set when you start using extends from BaseTest.

        requestSpecification.basePath(APIConstants.AUTH_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.setAuthPayload()).post() ;
//Extraction (JSON string response to java object )
        String token = payloadManager.getTokenFromJSON(response.asString());
        System.out.println(token);
// Validation of the request.
        assertActions.verifyStringKeyNotNull(token);
    }

    @Test(groups = "reg", priority = 1)
    @Owner("Promode")
    @Description("TC#2  - Create Invalid Token and Verify")
    public void testTokenPOST_Negative() {

        requestSpecification.basePath(APIConstants.AUTH_URL);
        response = RestAssured.given(requestSpecification)
                .when()
                .body("{}").post();

//Extraction ( JSON String response to Java Object)
        String invalid_reason = payloadManager.getInvalidResponse(response.asString());
        System.out.println(invalid_reason);


//Validation of the request.
        assertActions.verifyStringKey(invalid_reason,"Bad credentials");
    }
}
