package pages;

import base.BaseTest;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected BaseTest baseTest;

    public AbstractPage(BaseTest baseTest){
        this.baseTest=baseTest;
        PageFactory.initElements(baseTest.getDriver(),this);
    }




}
