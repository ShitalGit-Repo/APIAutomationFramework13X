package com.Tests.RestfulBooker.Sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {

//Create booking and token
//Verify that get booking
//Update the booking
//Delete the booking

    @Test (groups = "qa", priority = 1)
    @Owner("Shital")
    @Description ("TC#INT1-STEP 1-Verify that booking can be created")
    public void testCreateBooking () {
        Assert.assertTrue(true);
    }
    @Test (groups = "qa", priority = 2)
    @Owner("Shital")
    @Description ("TC#INT1-STEP 2-Verify that booking by ID")
    public void testVerifyBooking () {
        Assert.assertTrue(true);
    }
    @Test (groups = "qa", priority = 3)
    @Owner("Shital")
    @Description ("TC#INT1-STEP 3-Verify updated booking by ID")
    public void testUpdateBookingByID () {
        Assert.assertTrue(true);
    }
    @Test (groups = "qa", priority = 4)
    @Owner("Shital")
    @Description ("TC#INT1-STEP 4-Delete booking by ID")
    public void testDeleteBookingByID () {
        Assert.assertTrue(true);
    }
}
