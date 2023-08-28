package org.laplacita.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends Page{
    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    private WebElement nameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "phone")
    private WebElement phoneInput;
    @FindBy(id = "subject")
    private WebElement subjectInput;
    @FindBy(id = "message")
    private WebElement messageInput;
    @FindBy(xpath = "//button[contains(text(), 'Enviar mensaje')]")
    private WebElement sendButton;

    public void nameInputSendText(String text){
        this.nameInput.sendKeys(text);
    }

    public void emailInputSendText(String text){
        this.emailInput.sendKeys(text);
    }

    public void phoneInputSendText(String text){
        this.phoneInput.sendKeys(text);
    }

    public void subjectInputSendText(String text){
        this.subjectInput.sendKeys(text);
    }

    public void messageInputSendText(String text){
        this.messageInput.sendKeys(text);
    }

    public void sendButtonClick(){
        this.scrollAndClickElement(this.sendButton);
    }
    public boolean isSuccess(){
        this.isTextPresent("Mensaje enviado, pronto te contactaremos");
        return  browser.getPageSource().contains("Mensaje enviado, pronto te contactaremos");
    }

}
