package org.laplacita.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class Page {
    protected WebDriver browser;

    public Page(WebDriver driver){
        this.browser = driver;
    }

    public WebElement findElement(By loc){
        return browser.findElement(loc);
    }

    public List<WebElement> findElements(By loc){
        return browser.findElements(loc);
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

    public List<WebElement> fluentWaitWebElements(By loc){
        Wait<WebDriver> wait = new FluentWait<>(this.browser)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
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
        wait.until(driver -> driver.getPageSource().contains(txt));
    }

    public boolean isTextPresentInWebElement(By loc, String text){
        Wait<WebDriver> wait = new FluentWait<>(this.browser)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(loc, text));
    }

    public boolean equalsPathUrl(final String pathUrl){
        return this.browser.getCurrentUrl().equals(pathUrl);
    }

    private void scrollToElement(WebElement element){
        ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement scrollWebElement(WebElement element){
        ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.fluentWaitWebElement(element);
    }

    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy(0,-5000)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollBy(double x, double y){
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollBy("+x+","+y+")");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitElement() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean elementExists(By loc){
        return !browser.findElements(loc).isEmpty();
    }

}
