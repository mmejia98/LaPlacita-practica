package org.laplacita.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TermsAndConditionsPage extends Page{
    public TermsAndConditionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCorrectUrlTermsAndCondition(){
        return this.equalsPathUrl("https://ezone-web.uat.creativaconsultores.com/legal/terms-of-service");
    }
}
