package com.Conference.TestPage;

import org.testng.annotations.Test;

import com.Conference.Base.TestBase;
import com.Conference.Pages.HomePage;

public class HomeTest extends TestBase {
@Test
	public void clickLogin() {
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
	}
}
