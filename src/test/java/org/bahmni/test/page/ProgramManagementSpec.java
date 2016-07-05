package org.bahmni.test.page;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import org.bahmni.test.page.program.ProgramManagamentPage;
import org.bahmni.test.page.program.domain.Program;

public class ProgramManagementSpec {

	@Step("Register the patient to following program <programDetails>")
	public void enrollPatientToProgram(Table programDetails) {
		ProgramManagamentPage programManagamentPage = org.bahmni.test.PageFactory.getProgramManagementPage();
		Program treatment = programManagamentPage.transformTableToProgram(programDetails);
		programManagamentPage.storeProgramInSpecStore(treatment);
		programManagamentPage.enrollPatientToProgram(treatment);
	}

	@Step("Ensure that the patient is registered to mentioned program")
	public void verifyThePatientIsEnrolledToTheProgram() {
		ProgramManagamentPage programManagamentPage = org.bahmni.test.PageFactory.getProgramManagementPage();
		Program programDetails = programManagamentPage.getProgramFromSpecStore();
		programManagamentPage.isPatientEnrolledToProgram(programDetails);

	}
}
