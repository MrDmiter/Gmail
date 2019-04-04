package tests;

import base.BaseTest;
import pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegistrationTest extends BaseTest {


    @Test
    public void testRegistrationTest(){
        HomePage homePage = openSite();
        homePage.registration();
        homePage.verifyRegistration();
    }
}
