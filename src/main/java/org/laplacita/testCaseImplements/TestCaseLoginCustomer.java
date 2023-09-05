package org.laplacita.testCaseImplements;

import org.laplacita.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestCaseLoginCustomer {
    protected static WebDriver browser;

    @BeforeClass
    public static void beforeClass(){
        browser = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod(){
        browser.get("https://ezone-web.uat.creativaconsultores.com/login");
        LoginPage login = new LoginPage(browser);
        login.setLogin("mmejiaalvarenga@gmail.com", "$Mariojose1998");
    }

    @AfterClass
    public void afterClass(){
        //browser.close();
    }
}
