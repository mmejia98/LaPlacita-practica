package org.laplacita.pages.home;

import org.laplacita.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductosDestacadosPage extends ProductPage {
    public ProductosDestacadosPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
