package com.qatest.pages;

import com.qatest.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends AbstractPage {

    // Variables
    String buttonTextWrongEmail = "Create account";
    String wrongPassErrorMessage = "Wrong password for the account, please try again or  ";

    // Elements

    @FindBy(xpath = "//input[@type='email']")
    protected WebElement authEmail;

    @FindBy(xpath = "//span[@id='id-index-continue-button']/button")
    protected WebElement submitButton;

    @FindBy(xpath = "//input[@type='password']")
    protected WebElement authPass;

    @FindBy(xpath = "//span[@class='display__inherit notification__text']")
    protected WebElement errorMessage;

    /**
     * Constructor
     * @param baseTest
     */
    public AuthPage(BaseTest baseTest) {
        super(baseTest);
    }

    public void loginToTheAccount(String email) {
        authEmail.sendKeys(email);
        clickOnElement(submitButton);
    }

    public HomePage loginToTheAccount(String email, String pass) {
        authEmail.sendKeys(email);
        clickOnElement(submitButton);
        waitUntilElementIsVisible(authPass);
        authPass.sendKeys(pass);
        clickOnElement(submitButton);
        return new HomePage(baseTest);
    }

    public void verifyTextChangeOnTheButton() {
        Assert.assertEquals("Text on the button is not valid", buttonTextWrongEmail, submitButton.getText());
    }

    public void verifyErrorMessage() {
        waitUntilElementIsVisible(errorMessage);
        Assert.assertEquals("Error message is incorrect", wrongPassErrorMessage, errorMessage.getText());
    }
}
