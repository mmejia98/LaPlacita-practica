package org.laplacita.pages.home;

import org.laplacita.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopHeaderPage extends Page {

    public TopHeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(browser, this);
    }

    @FindBy(xpath = "//a[@routerlink='/signup']")
    public WebElement singUpLink;

    public void singUpClick(){
        this.findElementAndClick(singUpLink);
    }

}
