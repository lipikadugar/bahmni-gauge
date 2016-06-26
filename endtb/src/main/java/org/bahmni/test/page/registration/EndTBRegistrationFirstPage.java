package org.bahmni.test.page.registration;

import org.bahmni.test.page.registration.domain.EndTBPatient;
import org.bahmni.test.page.registration.domain.Patient;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EndTBRegistrationFirstPage extends RegistrationFirstPage{

	@FindBy(how= How.ID, using = "nationalIdentificationNumber")
	public WebElement txtNationalIdentificationNumber;

	@Override
	protected void doActions(Patient patient) {
		super.doActions(patient);
		EndTBPatient endTBPatient = (EndTBPatient) patient;
		txtNationalIdentificationNumber.sendKeys(endTBPatient.getNationalIdentificationNumber());
	}
}
