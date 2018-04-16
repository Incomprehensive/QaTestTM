package com.qatest.test;

import com.qatest.base.BaseTest;
import com.qatest.pages.AuthPage;
import org.junit.Test;

public class LoginTestFailEmail extends BaseTest {

    @Test
    public void testLoginTestFailEmail() {

        // Open Site
        AuthPage authPage = openSite();

        // Enter the correct credentials
        authPage.loginToTheAccount(login + "1");

        // Verify that button changed to Create account
        authPage.verifyTextChangeOnTheButton();

    }

}
