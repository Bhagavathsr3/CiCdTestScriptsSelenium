package com.Conference.Listeners;

import com.Conference.utils.ScreenShotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentSparkReporter spark;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        String reportPath = System.getProperty("user.dir") + "/extentReports/myReport.html";

        spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("UI Automation Suite");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Add system info for better reporting
        extent.setSystemInfo("Project Name", "Conference App");
        extent.setSystemInfo("Tester", "Bhagavath");
        extent.setSystemInfo("Environment", "Prod");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail("Test Failed : " + result.getMethod().getMethodName());
        test.get().fail(result.getThrowable());

        
        String screenshotPath = ScreenShotUtils.captureScreenShot(result.getMethod().getMethodName());
        test.get().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped : " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush(); // Generate the report
        }
    }
}
