package com.qatest.pages;

import com.qatest.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    String TITLE = "Downloads";

    @FindBy(xpath = "//span[@class='user-account-info__name t1']")
    protected WebElement accountName;

    /**
     * Constructor
     *
     * @param baseTest
     */
    public HomePage(BaseTest baseTest) {
        super(baseTest);
    }

    public void verifyTitle() {
        Assert.assertEquals("Titles do not match", TITLE, baseTest.getDriver().getTitle());
    }

    public void verifyAccountName(String name) {
        Assert.assertEquals("Account name does not match", name, accountName.getText());
    }
}
