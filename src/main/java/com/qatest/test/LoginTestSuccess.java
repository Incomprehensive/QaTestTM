package com.qatest.test;

import com.qatest.base.BaseTest;
import com.qatest.pages.AuthPage;
import com.qatest.pages.HomePage;
import org.junit.Test;

public class LoginTestSuccess extends BaseTest {

    @Test
    public void testLoginTestSuccess() {

        // Open Site
        AuthPage authPage = openSite();

        // Enter the correct credentials
        HomePage homePage = authPage.loginToTheAccount(login, pass);

        // Verify the title of the page
        homePage.verifyTitle();

        //Verify the account name on the page
        homePage.verifyAccountName(login);

    }

}
