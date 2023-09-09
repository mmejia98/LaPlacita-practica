package org.laplacita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class SignupPage extends Page{

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By phone = By.id("phone");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By acceptTerms = By.id("acceptTerms");
    private By singUpButton = By.xpath("//button[text() = 'Regístrate']");

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

    public void acceptTermsCheckClick(){
        this.findElement(acceptTerms).sendKeys(Keys.SPACE);
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
        return "juan.perez-"+n+"@example.com";
    }

}
