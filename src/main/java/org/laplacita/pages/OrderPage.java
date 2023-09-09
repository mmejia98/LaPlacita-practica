package org.laplacita.pages;

import org.laplacita.interfaces.IMetodoPago;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends Page{
    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@for='gridRadios1']/input")
    private WebElement direccion;

    @FindBy(xpath = "//div[contains(@class,'card option')]")
    private List<WebElement> metodosPago;

    @FindBy(xpath = "//button[contains(text(),'Finalizar compra')]")
    private WebElement finalizarCompra;

    public void setDireccion(){
        this.waitElement();
        scrollWebElement(direccion);
        this.fluentWaitWebElement(direccion).click();
    }

    public enum MetodoPago implements IMetodoPago {
        TARJETA("Tarjeta"),
        CUOTAS("Cuotas"),
        EFECTIVO("Efectivo"),
        BITCOIN("Bitcoin"),
        ;

        private String name;
        MetodoPago(String name){
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

    }

    public void setMetodoPago(IMetodoPago metodo){
        this.waitElement();
        for (WebElement metodoPago : metodosPago){
            if(metodo.getName().contains(metodoPago.findElement(By.xpath("div/h4")).getText())){
                metodoPago.click();
                break;
            }
        }
    }

    public void finalizarCompraClick(){
        this.fluentWaitWebElement(finalizarCompra).click();
    }

}
