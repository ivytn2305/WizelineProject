package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Objects;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, CommonConstants.TIMEOUT_20S);
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForPageLoad() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) Objects.requireNonNull(driver)).executeScript("return document.readyState").toString().equalsIgnoreCase("complete");
        System.out.println(expectation);
        try {
            Thread.sleep(CommonConstants.TIMEOUT_3S);
            wait.until(expectation);
        } catch (InterruptedException e) {
            Assert.assertFalse(false);
        }
    }


}
