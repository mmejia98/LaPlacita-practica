package org.laplacita.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PolitiesOfPrivacyPage extends Page{
    public PolitiesOfPrivacyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCorrectUrlPolitiesOfPrivacy(){
        return this.equalsPathUrl("https://ezone-web.uat.creativaconsultores.com/legal/privacy");
    }
}
