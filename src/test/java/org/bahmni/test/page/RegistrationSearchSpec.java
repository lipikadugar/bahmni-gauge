package org.bahmni.test.page;

import com.thoughtworks.gauge.Step;
import org.bahmni.test.page.registration.RegistrationSearch;
import org.bahmni.test.page.registration.domain.Patient;

public class RegistrationSearchSpec {

	@Step("Click on create new patient link")
	public void clickOnCreateNew(){
		RegistrationSearch registrationSearch = org.bahmni.test.PageFactory.getRegistrationSearchPage();
		registrationSearch.clickCreateNew();
	}

	@Step("Search previously created patient with exact identifier")
	public void searchPreviousCreatedPatientWithIdentifier(){
		RegistrationSearch registrationSearch = org.bahmni.test.PageFactory.getRegistrationSearchPage();
		Patient recentlyCreatedPatient = registrationSearch.getPatientFromSpecStore();
		registrationSearch.searchByExactIdentifier(recentlyCreatedPatient.getPrefix(),recentlyCreatedPatient.getIdNumber());

	}
}
