package com.searchduck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;
public class SearchPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchName;

    @FindBy(xpath = "//button[contains(@class,'searchbox_searchButton')]")
    private WebElement searchBtn;

    @FindBy(className = "search__button")
    private WebElement searchBtn1;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> listVideos;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://duckduckgo.com/");
        driver.manage().window().maximize();
    }

    public void doSearch(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(searchName));
        searchName.sendKeys(keyword);
        try {
            searchBtn.click();
        }
        catch (Exception e){
            searchBtn1.click();
        }

    }

    public void clickVideos() {
        wait.until(ExpectedConditions.visibilityOf(videosLink));
        videosLink.click();
    }

    public int countVideos(){
        By by = By.className("tile--vid");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println(listVideos.size());
        return listVideos.size();

    }
}
