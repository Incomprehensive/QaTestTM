package com.qatest.base;

import com.qatest.pages.AuthPage;
import com.qatest.utils.TestRule;
import com.qatest.utils.YamlOprions;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    //Objects of WebDriver and WebDriverWait
    WebDriver driver;
    WebDriverWait wait;

    //Credentials
    protected String login = YamlOprions.read().getEmail();
    protected String pass = YamlOprions.read().getPass();

    @Rule
    public TestRule testRule = new TestRule(this);

    /**
     * Constructor
     */
    protected BaseTest() {
        try {
            WebDriver driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Driver getter
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public AuthPage openSite() {
        driver.get(YamlOprions.read().getUrl());
        return new AuthPage(this);
    }
}
