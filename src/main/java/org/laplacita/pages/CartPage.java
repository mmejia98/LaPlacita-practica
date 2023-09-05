package org.laplacita.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Page{
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Ordenar ahora']")
    private WebElement ordenarAhora;

    public void ordenarAhoraClick(){
        this.fluentWaitWebElement(ordenarAhora).click();
    }
}
