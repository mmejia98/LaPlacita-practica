package org.laplacita.pages.home;

import org.laplacita.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends Page {
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//input[@type='search' and @placeholder='Buscar'])[1]")
    public WebElement searchBarInput;

    @FindBy(xpath = "//img[@alt='Site-Logo-Header']")
    public WebElement logoHeader;



}
