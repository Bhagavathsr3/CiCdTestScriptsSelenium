package com.Conference.TestPage;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Conference.Base.TestBase;
import com.Conference.Listeners.TestListener;
import com.Conference.Pages.LoginPage;
import com.Conference.utils.ExcelUtils;


@Listeners(TestListener.class)
public class LoginTest extends TestBase {

	@DataProvider(name = "loginData")
	public Object[][] loginDataProvider() {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/LoginTestData.xlsx";
		try {
			return ExcelUtils.getTestData(filePath, "Login");
		} catch (IOException e) {
			throw new RuntimeException("Failed to read login test data from Excel file", e);
		}
	}

	@Test(dataProvider = "loginData", description = "Data-Driven Valid Login Test")
	public void validLogin(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.validlogin(email, password);

	}

}