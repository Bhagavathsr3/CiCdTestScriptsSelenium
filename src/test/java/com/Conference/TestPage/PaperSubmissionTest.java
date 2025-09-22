package com.Conference.TestPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Conference.Base.TestBase;
import com.Conference.Listeners.TestListener;
import com.Conference.Pages.PaperSubmissionPage;
import com.Conference.utils.ActionUtils;

@Listeners(TestListener.class)
public class PaperSubmissionTest extends TestBase {

	@Test(priority = 1)
	public void openPaperSubmissionPage() {
		PaperSubmissionPage psp = new PaperSubmissionPage(driver);
		psp.openPublishNowPage();
	}

	@Test(priority = 2)
	public void fillpaperSubmissionForm() {
		PaperSubmissionPage psp = new PaperSubmissionPage(driver);

		psp.fillPaperSubmissionForm("Rocky", "rocky@gmail.com", "This paper is about IT in Agriculture Sector");
	}
}
