package pageonjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Step1Page extends BasePage {
    @FindBy(xpath = "//span[contains(text(),'Step 1:')]")
    WebElement step1Title;

    @FindBy(css = "#firstName")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameInput;

    @FindBy(css = "#email")
    WebElement emailInput;

    @FindBy(css = "#birthMonth")
    WebElement birthMonthDrp;

    @FindBy(css = "#birthDay")
    WebElement birthDayDrp;

    @FindBy(css = "#birthYear")
    WebElement birthYearDrp;

    @FindBy(xpath = "//span[contains(text(),'Next: Location')]")
    WebElement nextBtn;

    @FindBy(xpath = "//span[contains(text(),'Step 2:')]")
    WebElement step2Title;

    @FindBy(css = "#emailError")
    WebElement emailErrorText;


    String expectedStep1PageTitle = "uTest - User SignUp";
    String fName = "Trang";
    String lName = "Nguyen";
    String email = "trang@gmail.com";
    String invalidEmail = "@gmail.com";

    public Step1Page(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillInStep1Form(){
        //Wait for page load
        waitForPageLoad();

        //Verify Step 1 page title is correct
        Assert.assertEquals(step1Title.getText(), "Step 1:");

        waitForElementToBeClickable(firstNameInput);
        firstNameInput.sendKeys(fName);

        waitForElementToBeClickable(lastNameInput);
        lastNameInput.sendKeys(lName);

        waitForElementToBeClickable(emailInput);
        emailInput.sendKeys(email);

        waitForElementToBeClickable(birthDayDrp);
        firstNameInput.sendKeys(fName);

        Select birthMonth = new Select(birthMonthDrp);
        birthMonth.selectByVisibleText("September");

        Select birthDate = new Select(birthDayDrp);
        birthDate.selectByVisibleText("20");

        Select birthYear = new Select(birthYearDrp);
        birthYear.selectByVisibleText("1990");

        nextBtn.click();

        //Verify Step 2 page title is correct
        Assert.assertEquals(step2Title.getText(), "Step 2:");

    }

    public void fillInStep1FormWithInvalidEmail(){
        //Wait for page load
        waitForPageLoad();

        //Verify Step 1 page title is correct
        Assert.assertEquals(step1Title.getText(), "Step 1:");

        waitForElementToBeClickable(firstNameInput);
        firstNameInput.sendKeys(fName);

        waitForElementToBeClickable(lastNameInput);
        lastNameInput.sendKeys(lName);

        waitForElementToBeClickable(emailInput);
        emailInput.sendKeys(invalidEmail);

        waitForElementToBeClickable(birthDayDrp);
        firstNameInput.sendKeys(fName);

        Select birthMonth = new Select(birthMonthDrp);
        birthMonth.selectByVisibleText("September");

        Select birthDate = new Select(birthDayDrp);
        birthDate.selectByVisibleText("20");

        Select birthYear = new Select(birthYearDrp);
        birthYear.selectByVisibleText("1990");

        nextBtn.click();

        //Verify error message is retunred
        Assert.assertEquals(emailErrorText.getText(), "Enter valid email");

    }


}
