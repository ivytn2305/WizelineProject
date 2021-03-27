package com.wizeline.ui.tests;

import common.BaseTest;
import common.WebDriverFactory;
import org.testng.annotations.Test;
import pageonjects.Step1Page;

public class SubmitStep1Form extends BaseTest {
    @Test
    public void TC01_SubmitStep1FormSuccessfully(){
        Step1Page step1Page = new Step1Page(driver);

        //1. Navigate to Step 1 Page
        WebDriverFactory.getDriver().get("https://www.utest.com/signup/personal");

        //2. Fill Step 1 form
        step1Page.fillInStep1Form();

    }

    @Test
    public void TC02_SubmitStep1FormWithInvalidEmail(){
        Step1Page step1Page = new Step1Page(driver);

        //1. Navigate to Step 1 Page
        WebDriverFactory.getDriver().get("https://www.utest.com/signup/personal");

        //2. Fill Step 1 form
        step1Page.fillInStep1FormWithInvalidEmail();

    }
}
