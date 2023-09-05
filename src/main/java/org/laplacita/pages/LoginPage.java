package org.laplacita.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page{

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//button[text() = 'Iniciar sesión']")
    private WebElement iniciarSesion;

    public void setLogin(String email, String pass){
        this.fluentWaitWebElement(this.email).sendKeys(email);
        this.fluentWaitWebElement(this.password).sendKeys(pass);
        this.scrollWebElement(iniciarSesion).click();
        this.isTextPresent("Productos destacados");
    }

}
