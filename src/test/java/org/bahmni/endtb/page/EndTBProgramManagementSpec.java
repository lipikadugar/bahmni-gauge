package org.bahmni.endtb.page;

import com.thoughtworks.gauge.Step;
import org.bahmni.endtb.page.registration.EndTBRegistrationFirstPage;
import org.bahmni.test.PageFactory;

public class EndTBProgramManagementSpec {

	@Step("Click on treatment enrollment")
	public void clickOnTreatmentEnrollment() {
		EndTBRegistrationFirstPage registrationFirstPage = (EndTBRegistrationFirstPage)PageFactory.getRegistrationFirstPage();
		registrationFirstPage.clickTreatmentRegistration();
	}
}
