package org.laplacita.testCaseImplements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
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

    @AfterClass
    public void afterClass(){
        browser.close();
    }
}
