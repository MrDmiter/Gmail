package pages;

import base.BaseTest;
import gmail.GetEmailsFromGmail;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.YamlParser;

import java.io.IOException;

public class HomePage extends AbstractPage {

    private final String CONFIRMATION_MESSAGE = "You need to sign in or sign up before continuing.";

    @FindBy(xpath = "//a[.='Register as a tester']")
    private WebElement registerAsTesterButton;

    @FindBy(xpath = "//input[@id='tester_full_name']")
    private WebElement name;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signIn;

    @FindBy(xpath = "//div[@class='checkbox']//span[@class='c-indicator']")
    private WebElement checkbox;

    @FindBy(xpath = "//div[@id='flashes']")
    private WebElement toasterMessage;


    //Constructor
    public HomePage(BaseTest baseTest) {
        super(baseTest);
    }

    public void registration(){
        baseTest.waitTillElementIsVisible(registerAsTesterButton);
        registerAsTesterButton.click();
        name.sendKeys(YamlParser.getYamlFile().getName());
        email.sendKeys(YamlParser.getYamlFile().getEmail());
        password.sendKeys(YamlParser.getYamlFile().getPassword());
        checkbox.click();
        signIn.click();
        try {
            baseTest.getDriver().get(getConfirmationUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getConfirmationUrl() throws IOException {
        return GetEmailsFromGmail.getInviteUrl();
    }
    public void verifyRegistration() {
        baseTest.waitTillElementIsVisible(toasterMessage);
        Assert.assertEquals("Message are not the same", CONFIRMATION_MESSAGE, toasterMessage.getText());
    }

}
