package org.laplacita.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends ProductPage{
    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Agregar al carrito')]")
    private WebElement agregarAlCarrito;

    public void agregarAlCarritoClick(){
        this.scrollBy(0,500);
        this.fluentWaitWebElement(agregarAlCarrito).click();
    }


}
