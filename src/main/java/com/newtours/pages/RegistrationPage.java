package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstnameTxt;

    @FindBy(name = "lastName")
    private WebElement lastnameTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "email")
    private WebElement emailTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement registerBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOf(firstnameTxt));
    }

    public void enterUserDetails(String firstName, String lastName) {
        firstnameTxt.sendKeys(firstName);
        lastnameTxt.sendKeys(lastName);
    }

    public void enterUserCreds(String userName, String password) {
        emailTxt.sendKeys(userName);
        passwordTxt.sendKeys(password);
        confirmPasswordTxt.sendKeys(password);
    }

    public void clickRegister() {
        registerBtn.click();
    }

}
