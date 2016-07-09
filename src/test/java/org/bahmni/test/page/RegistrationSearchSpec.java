package org.bahmni.test.page;

import com.thoughtworks.gauge.Step;
import org.bahmni.test.page.registration.RegistrationSearch;
import org.bahmni.test.page.registration.domain.Patient;

public class RegistrationSearchSpec {

	@Step("Click on create new patient link")
	public void clickOnCreateNew() {
		RegistrationSearch registrationSearch = org.bahmni.test.PageFactory.getRegistrationSearchPage();
		registrationSearch.clickCreateNew();
	}

	@Step({"Click on search patient link","Navigate to Registration search page"})
	public void clickOnSearch() {
		RegistrationSearch registrationSearch = org.bahmni.test.PageFactory.getRegistrationSearchPage();
		registrationSearch.clickSearch();
	}

	@Step("Search patient with prefix <prefix> identifier <identifier>")
	public void clickOnSearch(String prefix, String identifier) {
		RegistrationSearch registrationSearch = org.bahmni.test.PageFactory.getRegistrationSearchPage();
		registrationSearch.searchByIdentifier(prefix, identifier);
	}

	@Step("Search previously created patient with exact identifier")
	public void searchPreviousCreatedPatientWithIdentifier() {
		RegistrationSearch registrationSearch = org.bahmni.test.PageFactory.getRegistrationSearchPage();
		Patient recentlyCreatedPatient = registrationSearch.getPatientFromSpecStore();
		registrationSearch.searchByExactIdentifier(recentlyCreatedPatient.getPrefix(), recentlyCreatedPatient.getIdNumber());

	}

	@Step("Validate that the search results are displayed")
	public void validateSearchResults() {
			RegistrationSearch registrationSearch = org.bahmni.test.PageFactory.getRegistrationSearchPage();
			registrationSearch.verifySearchResults();
	}
}
