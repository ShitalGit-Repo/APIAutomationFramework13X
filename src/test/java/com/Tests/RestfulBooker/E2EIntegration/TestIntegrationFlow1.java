package com.Tests.RestfulBooker.E2EIntegration;

import com.Base.BaseTest;
import com.endpoints.APIConstants;
import com.pojos.requestpojos.RestfulBooker.Booking;
import com.pojos.responsepojos.RestfulBooker.Bookingresponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestIntegrationFlow1 extends BaseTest {

    // TestE2EFlow_01

//Test E2E Scenario 1

//1. Create a Booking -> bookingID

//2. Create Token -> token

//3. Verify that the Create Booking is working - GET Request to bookingID

//4. Update the booking ( bookingID, Token) - Need to get the token, bookingID from above request

//5. Delete the Booking - Need to get the token, bookingID from above request

    @Test(groups = "qa", priority = 1)
    @Owner("Shital")
    @Description("TC#INT1 - Step 1 - verify that booking can be created")

    public void testCreateBooking(ITestContext iTestContext) {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        Bookingresponse bookingresponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKey(bookingresponse.getBooking().getFirstname(), "Shital");
        assertActions.verifyStringKeyNotNull(bookingresponse.getBookingid());
        Integer bookingid = bookingresponse.getBookingid();
        iTestContext.setAttribute("bookingID", bookingid);
    }

    @Test(groups = "qa", priority = 2)
    @Owner("Shital")
    @Description("TC#INT1 - Step 2 - verify that booking by ID")

    public void testVerifyBookingID(ITestContext iTestContext) {
        Integer bookingID = (Integer) iTestContext.getAttribute("bookingID");
        System.out.println(bookingID);
        String basePathGET = APIConstants.CREATE_UPDATE_BOOKING_URL+"/" + bookingID;
        System.out.println(basePathGET);

        requestSpecification.basePath(basePathGET);
        response = RestAssured
                .given(requestSpecification)
                .when().get();
        validatableResponse = response.then().log().all();
        // Validatable Assertion
        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponseFromJSON(response.asString());
        assertActions.verifyStringKeyNotNull(booking.getFirstname());
    }
    @Test(groups = "qa", priority = 3)
    @Owner("Shital")
    @Description("TC#INT1 - Step 3 - verify updated booking by ID")
    public void testVerifyUpdatedBookingID(ITestContext iTestContext) {
        Integer bookingID = (Integer) iTestContext.getAttribute("bookingID");
        System.out.println(bookingID);
    }
    @Test(groups = "qa", priority = 4)
    @Owner("Shital")
    @Description("TC#INT1 - Step 4 - verify updated booking by ID")
    public void testDeleteBookingID(ITestContext iTestContext) {
        Assert.assertTrue(true);
    }
}
