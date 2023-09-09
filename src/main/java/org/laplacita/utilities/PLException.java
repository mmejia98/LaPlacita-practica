package org.laplacita.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;

public class PLException extends WebDriverException {
    public PLException(String className, String msg, WebDriver driver){
        super(msg);
        addScreenshot(driver);
    }

    public static String addScreenshot(WebDriver driver){
        if(driver instanceof TakesScreenshot){
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            new File("./target/images").mkdir();
            try {
                FileUtils.copyFileToDirectory(screenshot, new File("./target/images"));
                return screenshot.getName();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return null;
    }
}
