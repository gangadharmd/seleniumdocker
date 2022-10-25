package com.newtours.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;
public class FlightDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(name = "passCount")
    private WebElement passengers;
    @FindBy(name = "findFlights")
    private WebElement findFlightsBtn;

    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void selectPassengers(String noOfPassengers) throws InterruptedException {
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOf(passengers));
        Select select = new Select(passengers);
        select.selectByValue(noOfPassengers);
    }

    public void findFlightsPage() {
        findFlightsBtn.click();
    }
}
