package org.laplacita.pages.home;

import org.laplacita.interfaces.IMenu;
import org.laplacita.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RightMenuPage extends Page {

    public RightMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='navbarNavDropdown']/div/ul[2]/li")
    private static List<WebElement> menuItems;

    public enum Menu implements IMenu{
        NUEVOS("NUEVOS"),
        DETACADOS("DESTACADOS\n(CURRENT)"),
        MENOS_DE_5("MENOS DE $5\n(CURRENT)"),
        MENOS_DE_10("MENOS DE $10\n(CURRENT)");

        private String name;

        Menu(String name){
            this.name = name;
        }

        @Override
        public void click() {
            for (WebElement item : menuItems){
                if(this.name.contains(item.getText())){
                    item.click();
                    break;
                }
            }
        }
    }

}
