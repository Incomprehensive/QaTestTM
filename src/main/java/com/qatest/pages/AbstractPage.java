package com.qatest.pages;

import com.qatest.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    // Object of WebDriver and WebDriverWait
    WebDriver driver;
    WebDriverWait wait;

    // Object of BaseTest
    protected BaseTest baseTest;

    // Elements
    @FindBy(xpath = "//body")
    protected WebElement content;
    /**
     * Constructor
     * @param baseTest
     */
    public AbstractPage(BaseTest baseTest) {
        this.baseTest = baseTest;
        this.driver = baseTest.getDriver();
        this.wait = baseTest.getWait();
        PageFactory.initElements(driver,this);
        waitUntilElementIsVisible(content);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
