package com.base.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
public class BaseTest {

    protected WebDriver driver;

    @BeforeTest

    public void setUpDriver() throws MalformedURLException {

        //BROWSER => chrome/firefox
        //HUB_HOST => localhost/ip/hostname

        String host = "localhost";
        MutableCapabilities dc;
        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }
        String completeUrl = "http://" + host + ":4444/wd/hub";

        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("chrome")) {
            dc = new ChromeOptions();

        } else if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = new FirefoxOptions();

        } else {
            dc = new ChromeOptions();

        }

        System.out.println(completeUrl);
        driver = new RemoteWebDriver(new URL(completeUrl), dc);

    }

    @AfterTest
    public void quitBrowser() {
        driver.quit();
    }
}
