package org.laplacita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends Page{

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-product-item/div")
    public List<WebElement> products;

    public void getProductByName(String name){
        for (WebElement product : products){
            this.fluentWaitWebElement(product);
            if(product.findElement(By.xpath("div/div[2]/div[2]")).getText().trim().contains(name)){
                WebElement elem = this.scrollWebElement(product.findElement(By.xpath("div/div[2]/div[2]")));
                elem.click();
                break;
            }
        }
    }

}
