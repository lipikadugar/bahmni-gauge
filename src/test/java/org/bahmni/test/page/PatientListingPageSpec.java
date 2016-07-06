package org.bahmni.test.page;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import org.bahmni.test.page.clinical.PatientListingPage;
import org.bahmni.test.page.program.ProgramManagamentPage;
import org.bahmni.test.page.program.domain.Program;
import org.bahmni.test.page.registration.domain.Patient;

/**
 * Created by dharmens on 7/5/16.
 */
public class PatientListingPageSpec extends BahmniPage {

    @Step({"Select existing patient from patient listing page under tab <tab>","Select the existing patient from patient listing page under tab <tab>"})
    public void selectPatientFromTab(String tab) {
        PatientListingPage patientListing = org.bahmni.test.page.PageFactory.getPatientListingPage();
        Patient patient = getPatientFromSpecStore();
        patientListing.searchSelectPatientFromTab(patient.getIdNumber(),tab);
    }

}
