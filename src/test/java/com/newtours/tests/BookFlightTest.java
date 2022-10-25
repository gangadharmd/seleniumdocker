package com.newtours.tests;

import com.base.driver.BaseTest;
import com.newtours.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setUpParameter(String noOfPassengers, String expectedPrice) {
        this.noOfPassengers=noOfPassengers;
        this.expectedPrice=expectedPrice;
    }

    @Test
    public void registrationPage() {
        RegistrationPage registerPage = new RegistrationPage(driver);
        registerPage.goTo();
        registerPage.enterUserDetails("ravi", "malawad");
        registerPage.enterUserCreds("abc@gmail.com", "pwd");
        registerPage.clickRegister();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage() {
        RegistrationConfirmationPage registerConfPage = new RegistrationConfirmationPage(driver);
        registerConfPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage() throws InterruptedException {
        FlightDetailsPage flightDtPage = new FlightDetailsPage(driver);
        flightDtPage.selectPassengers(noOfPassengers);
        flightDtPage.findFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage() {
        FindFlightPage findFlightPg = new FindFlightPage(driver);
        findFlightPg.submitBtn();
        findFlightPg.buyBtn();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfPage() {
        FlightConfirmationPage ftConfPg = new FlightConfirmationPage(driver);
        String actualPrice = ftConfPg.goToFlightConfirmation();
        Assert.assertEquals(expectedPrice,actualPrice);
    }


}
