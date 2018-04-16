package com.qatest.utils;

import com.qatest.base.BaseTest;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestRule extends TestWatcher {

    // Base Test object
    private BaseTest baseTest;

    /**
     * Constructor
     * @param baseTest
     */
    public TestRule(BaseTest baseTest){
        this.baseTest = baseTest;
    }

    /**
     * Quit driver on failed
     * @param e
     * @param description
     */
    @Override
    protected void failed(Throwable e, Description description) {
        baseTest.getDriver().quit();
    }

    /**
     * Quit driver on finished
     *
     * @param description
     */
    @Override
    protected void finished(Description description) {
        baseTest.getDriver().quit();
    }
}
