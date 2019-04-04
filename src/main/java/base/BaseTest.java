package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utils.YamlParser;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public BaseTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage openSite(){
        driver.get(YamlParser.getYamlFile().getUrl());
        return new HomePage(this);
    }

    public void waitTillElementIsVisible(WebElement element){
        wait.until(visibilityOf(element));
    }
}
