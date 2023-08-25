package org.laplacita.pages.home;

import org.laplacita.interfaces.IMenu;
import org.laplacita.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftMenuPage extends Page {

    public LeftMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='navbarNavDropdown']/div/ul[1]/li/a")
    private static List<WebElement> menuItems;

    public enum Menu implements IMenu {
        COMERCIOS("COMERCIOS"),
        CATEGORIAS("CATEGORÍAS"),
        CONTACTO("CONTACTO"),
        AFILIATE("AFÍLIATE");

        private String name;

        Menu(String name){
            this.name = name;
        }

        public void click() {
            for(WebElement item : menuItems){
                if(this.name.contains(item.getText())){
                    item.click();
                    break;
                }
            }
        }
    }

    private void getItemMenu(String txt){
        for(WebElement item : menuItems){
            if(txt.contains(item.getText())){
                item.click();
                break;
            }
        }
    }

}
