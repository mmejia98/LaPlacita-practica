package org.laplacita.testCaseImplements;

import org.laplacita.utilities.PLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestCaseHeadless {

    protected static WebDriver browser;

    @BeforeClass
    public static void beforeClass(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        browser = new ChromeDriver(options);
    }

    @BeforeMethod
    public void beforeMethod(){
        browser.get("https://ezone-web.uat.creativaconsultores.com/home");
    }

    @AfterMethod
    public void checkFail(ITestResult result){
        if(!result.isSuccess()){
            PLException.addScreenshot(browser);
        }
    }

    @AfterClass
    public void afterClass(){
        //browser.close();
    }

    public void assertTrue(Boolean condition){
        if(!condition){
            throw new PLException(this.getClass().getName(), "Fallo", browser);
        }
    }

}
