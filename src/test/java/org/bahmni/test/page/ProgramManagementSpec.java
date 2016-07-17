package org.bahmni.test.page;

import com.thoughtworks.gauge.BeforeClassSteps;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import org.bahmni.test.DriverFactory;
import org.bahmni.test.page.program.ProgramManagamentPage;
import org.bahmni.test.page.program.domain.Program;

public class ProgramManagementSpec {

	@BeforeClassSteps
	public void waitForAppReady(){
		new BahmniPage().waitForSpinner(DriverFactory.getDriver());
	}

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

	@Step("Edit attribute to registration <registration> and facility <facility>")
	public void editAttributesEnrolledToTheProgram(String registration, String facility) {
		ProgramManagamentPage programManagamentPage = org.bahmni.test.PageFactory.getProgramManagementPage();
		Program programDetails = programManagamentPage.getProgramFromSpecStore();
		programManagamentPage.editProgramAttributes(programDetails, registration, facility);
	}

	@Step("End the program <TB Program>")
	public void endTheProgram(Program program) {
		ProgramManagamentPage programManagamentPage = org.bahmni.test.PageFactory.getProgramManagementPage();
		Program programDetails = programManagamentPage.getProgramFromSpecStore();
		programManagamentPage.endProgram(program);
	}
}
