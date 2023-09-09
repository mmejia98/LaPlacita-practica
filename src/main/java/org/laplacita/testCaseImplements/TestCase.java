package org.laplacita.testCaseImplements;

import org.laplacita.utilities.PLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestCase {
    protected static WebDriver browser;

    @BeforeClass
    public static void beforeClass(){
        browser = new ChromeDriver();
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
