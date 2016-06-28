package org.bahmni.test.page.program;

import org.bahmni.test.page.program.domain.Program;
import org.bahmni.test.page.registration.domain.EndTBProgram;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class EndTBProgramManagementPage extends ProgramManagamentPage{

	@FindBy(how= How.ID, using = "Registration Number")
	public WebElement txtRegistrationNumber;

	@FindBy(how= How.ID, using = "Registration Facility")
	public WebElement cmbRegistrationFacility;

	protected void doActions(Program treatment) {
		super.doActions(treatment);
		EndTBProgram endTBProgram = (EndTBProgram) treatment;
		txtRegistrationNumber.sendKeys(endTBProgram.getRegistrationNumber());
		new Select(cmbRegistrationFacility).selectByVisibleText(endTBProgram.getRegistrationFacility());
	}

	protected void doModifyEnrollmentDetails(WebElement programToModify, Program treatment) {
		super.doModifyEnrollmentDetails(programToModify,treatment);

		EndTBProgram endTBProgram = (EndTBProgram)treatment;

		WebElement txtEditRegistrationNumber = programToModify.findElement(By.cssSelector("[id='Registration Number']"));
		txtEditRegistrationNumber.clear();
		txtEditRegistrationNumber.sendKeys(endTBProgram.getRegistrationNumber());

		WebElement cmbEditRegistrationFacility = programToModify.findElement(By.cssSelector("[id='Registration Facility']"));
		new Select(cmbEditRegistrationFacility).selectByVisibleText(endTBProgram.getRegistrationFacility());

	}

}
