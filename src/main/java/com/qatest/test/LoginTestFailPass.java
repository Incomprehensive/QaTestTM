package com.qatest.test;

import com.qatest.base.BaseTest;
import com.qatest.pages.AuthPage;
import com.qatest.pages.HomePage;
import org.junit.After;
import org.junit.Test;

public class LoginTestFailPass extends BaseTest{

    @Test
    public void testLoginTestFailPass() {

        // Open Site
        AuthPage authPage = openSite();

        // Enter the correct credentials
        authPage.loginToTheAccount(login, "123456");

        // Verify that an error message has appeared
        authPage.verifyErrorMessage();
    }
}
