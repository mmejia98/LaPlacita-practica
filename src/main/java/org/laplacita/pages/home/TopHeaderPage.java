package org.laplacita.pages.home;

import org.laplacita.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopHeaderPage extends Page {

    public TopHeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(browser, this);
    }

    @FindBy(xpath = "//a[@routerlink='/signup']")
    private WebElement singUpLink;

    private By logOutLink = By.xpath("//a[text()='Cerrar sesión']");

    public void singUpClick(){
        scrollUp();
        if(elementExists(logOutLink)){
            fluentWaitWebElement(this.browser.findElement(logOutLink)).click();
        }
        this.findElementAndClick(singUpLink);
    }

}
