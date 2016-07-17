package org.bahmni.endtb.page;

import com.thoughtworks.gauge.BeforeClassSteps;
import com.thoughtworks.gauge.Step;
import org.bahmni.endtb.page.registration.EndTBRegistrationFirstPage;
import org.bahmni.test.DriverFactory;
import org.bahmni.test.PageFactory;
import org.bahmni.test.page.BahmniPage;

public class EndTBProgramManagementSpec {

	@BeforeClassSteps
	public void waitForAppReady(){ new BahmniPage().waitForSpinner(DriverFactory.getDriver());}

	@Step("Click on treatment enrollment")
	public void clickOnTreatmentEnrollment() {
		EndTBRegistrationFirstPage registrationPage = (EndTBRegistrationFirstPage) PageFactory.getRegistrationFirstPage();
		registrationPage.clickTreatmentRegistration();
	}
}
