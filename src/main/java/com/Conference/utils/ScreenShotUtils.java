package com.Conference.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Conference.Base.TestBase;

public class ScreenShotUtils extends TestBase{

	public static String captureScreenShot(String testName) {
		String filePath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
	}
}
