package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
public class FindFlightPage {
    private final WebDriver driver;
    private WebDriverWait wait;
    @FindBy(name = "reserveFlights")
    private WebElement firstSubmitBtn;
    @FindBy(name = "buyFlights")
    private WebElement buyFlightsBtn;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void submitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(firstSubmitBtn));
        firstSubmitBtn.click();
    }

    public void buyBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(buyFlightsBtn));
        buyFlightsBtn.click();
    }
}
