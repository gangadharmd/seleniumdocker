package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
public class FlightConfirmationPage {
    private  WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//td[text()='Total Price']/following-sibling::td/font")
    private WebElement priceAmount;


    @FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
    private WebElement flightConfirmationText;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLInk;


    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public String goToFlightConfirmation(){
        wait.until(ExpectedConditions.visibilityOf(priceAmount));
        wait.until(ExpectedConditions.visibilityOf(flightConfirmationText));
        System.out.println(priceAmount.getText());
        String price = priceAmount.getText();
        System.out.println(flightConfirmationText.getText());
        signOffLInk.click();
        return price;
    }


}
