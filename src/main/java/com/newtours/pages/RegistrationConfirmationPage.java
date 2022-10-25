package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
public class RegistrationConfirmationPage {
    private WebDriver driver;
    WebDriverWait wait;
    @FindBy(partialLinkText = "sign-in")
    private WebElement signinLInk;
    @FindBy(linkText = "Flights")
    private WebElement flightLink;

    public RegistrationConfirmationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goToFlightDetailsPage() {
        wait.until(ExpectedConditions.visibilityOf(signinLInk));
        flightLink.click();
    }
}
