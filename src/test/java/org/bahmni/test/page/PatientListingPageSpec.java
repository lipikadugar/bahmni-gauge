package org.bahmni.test.page;

import com.thoughtworks.gauge.BeforeClassSteps;
import com.thoughtworks.gauge.Step;
import org.bahmni.test.DriverFactory;
import org.bahmni.test.PageFactory;
import org.bahmni.test.page.clinical.PatientListingPage;
import org.bahmni.test.page.registration.domain.Patient;

/**
 * Created by dharmens on 7/5/16.
 */
public class PatientListingPageSpec extends BahmniPage {

    @BeforeClassSteps
    public void waitForAppReady(){
        new BahmniPage().waitForSpinner(DriverFactory.getDriver());
    }

    @Step({"Select existing patient from patient listing page under tab <tab>","Select the existing patient from patient listing page under tab <tab>"})
    public void selectPatientFromTab(String tab) {
        PatientListingPage patientListing = PageFactory.getPatientListingPage();
        Patient patient = getPatientFromSpecStore();
        patientListing.searchSelectPatientFromTab(patient.getIdNumber(),tab);
    }

}
