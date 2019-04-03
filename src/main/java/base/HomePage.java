package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class HomePage extends AbstractPage {


    @FindBy(xpath = "//a[.='Register as a tester']")
    private WebElement registerAsTestetButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signIn;

    @FindBy(xpath = "//div[@class='checkbox']//span[@class='c-indicator']")
    private WebElement checkbox;




    //Constructor
    public HomePage(BaseTest baseTest) {
        super(baseTest);
    }

}
