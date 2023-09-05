package org.laplacita.pages.home;

import org.laplacita.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage extends Page {

    public FooterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@formcontrolname='emailSubscription']")
    private WebElement emailSubscriptionInput;
    @FindBy(xpath = "//button[text() = 'Suscribirme']")
    private WebElement subscriptionButton;
    @FindBy(xpath = "//a[text() = 'Términos y condiciones']")
    private WebElement terminosCondiciones;
    @FindBy(xpath = "//a[text() = 'Soporte']")
    private WebElement soporte;
    @FindBy(xpath = "//button[text() = ' Afíliate ']")
    private WebElement afiliateButton;

    public WebElement emailSubscription(){
        return this.fluentWaitWebElement(emailSubscriptionInput);
    }

    public void subscriptionButtonClick(){
        this.fluentWaitWebElement(subscriptionButton).click();
    }

    public void terminosCondicionesClick(){
        this.fluentWaitWebElement(terminosCondiciones).click();
    }
}
