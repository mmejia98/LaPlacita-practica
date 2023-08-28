package org.laplacita.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class Page {
    protected WebDriver browser;

    public Page(WebDriver driver){
        this.browser = driver;
    }

    public WebElement findElement(By loc){
        return browser.findElement(loc);
    }

    public void findElementAndClick(WebElement elem){
        WebElement link = this.fluentWaitWebElement(elem);
        link.click();
    }

    public WebElement fluentWaitWebElement(WebElement elem){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(this.browser)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOf(elem));
    }

    public WebElement fluentWaitWebElementClickable(WebElement element){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(this.browser)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollAndClickElement(WebElement element){
        scrollToElement(element);
        WebElement link = fluentWaitWebElementClickable(element);
        link.click();
    }

    public WebElement fluentWait(By loc){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(this.browser)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    public void isTextPresent(final String txt){
        Wait<WebDriver> wait = new FluentWait<>(this.browser)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(new Function<WebDriver, Boolean>(){
           public Boolean apply(WebDriver driver){
               return driver.getPageSource().contains(txt);
           }
        });
    }

    private void scrollToElement(WebElement element){
        ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true)", element);
    }
}
