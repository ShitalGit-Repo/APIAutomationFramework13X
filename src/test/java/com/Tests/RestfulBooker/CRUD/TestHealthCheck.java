package com.Tests.RestfulBooker.CRUD;

import com.Base.BaseTest;
import com.endpoints.APIConstants;
import com.pojos.responsepojos.RestfulBooker.Bookingresponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestHealthCheck extends BaseTest {
    @Test
    @Description("TC#3  - Verify Health")
    public void testGETHealthCheck() {
        requestSpecification.basePath(APIConstants.PING_URL);

        response = RestAssured.given(requestSpecification).when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
        assertActions.verifyTrue(response.asString().contains("Created"));
    }
}


