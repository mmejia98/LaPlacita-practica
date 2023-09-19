package org.laplacita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SignupPage extends Page{

    public SignupPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By phone = By.id("phone");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By acceptTerms = By.id("acceptTerms");
    private By singUpButton = By.xpath("//button[text() = 'Regístrate']");
    private By termsAndConditions = By.xpath("//label[@for='acceptTerms']/a[@routerlink='/legal/terms-of-service']");
    private By politiesOfPrivacy = By.xpath("//label[@for='acceptTerms']/a[@routerlink='/legal/privacy']");
    private By alertModal = By.id("swal2-title");

    public WebElement firstNameInput(){
        return this.findElement(firstName);
    }

    public WebElement lastNameInput(){
        return this.findElement(lastName);
    }

    public WebElement phoneInput(){
        return this.findElement(phone);
    }

    public WebElement emailInput(){
        return this.findElement(email);
    }

    public WebElement passwordInput(){
        return this.findElement(password);
    }

    public WebElement confirmPasswordInput(){
        return this.findElement(confirmPassword);
    }
    public WebElement acceptTerms(){
        return this.findElement(acceptTerms);
    }
    public void termsAndConditionsClick(){
        scrollWebElement(this.findElement(termsAndConditions));
        fluentWaitWebElement(this.findElement(termsAndConditions)).click();
    }
    public void politiesOfPrivacyClick(){
        scrollWebElement(this.findElement(politiesOfPrivacy));
        fluentWaitWebElement(this.findElement(politiesOfPrivacy)).click();
    }

    public void acceptTermsCheckClick(){
        this.findElement(acceptTerms).sendKeys(Keys.SPACE);
    }

    public WebElement singUpButton(){
        return this.findElement(singUpButton);
    }

    public void singUpButtonClick(){
        this.scrollWebElement(findElement(singUpButton));
        this.fluentWaitWebElementClickable(findElement(singUpButton)).click();
    }

    public void setEmailRandom(){
        this.findElement(email).sendKeys(this.getEmail());
    }

    public void firstNameSendText(String txt){
        this.findElement(firstName).sendKeys(txt);
    }

    public Boolean isSuccess(){
        try{
            this.isTextPresent("Registro exitoso!");
            return browser.getPageSource().contains("Registro exitoso!");
        }catch (Exception e){
            return false;
        }
    }

    private String getEmail(){
        Random rand = new Random();
        int n = rand.nextInt(500);
        return "juan-perez-"+n+"@example.com";
    }

    public boolean isAlertPresentWithMessage(String message){
        return this.isTextPresentInWebElement(alertModal, message);
    }

    public boolean checkValidationMessage(WebElement webElement, String message){
        By locatorValidationMessage = By.xpath("//input[@id='"+webElement.getAttribute("id")+"']/following-sibling::div[contains(@class, 'invalid-feedback')]/span");
        List<WebElement> listValidationMessages = this.fluentWaitWebElements(locatorValidationMessage);
        for (WebElement validationMessage : listValidationMessages){
            if(validationMessage.getText().equals(message)){
                return true;
            }
        }
        return false;
    }

}
