package org.bahmni.endtb.page.registration;

import com.thoughtworks.gauge.TableRow;
import org.bahmni.endtb.page.registration.domain.EndTBPatient;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.domain.Patient;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class EndTBRegistrationFirstPage extends RegistrationFirstPage {

	@FindBy(how= How.CSS, using = ".confirm")
	public WebElement programEnrollment;

	@FindBy(how= How.ID, using = "nationalIdentificationNumber")
	public WebElement txtNationalIdentificationNumber;

	@Override
	protected void doActions(Patient patient) {
		super.doActions(patient);
		EndTBPatient endTBPatient = (EndTBPatient) patient;
		txtNationalIdentificationNumber.sendKeys(endTBPatient.getNationalIdentificationNumber());
	}

	public void clickTreatmentRegistration(){
		programEnrollment.click();
	}

	public Patient transformTableRowToPatient(TableRow row, List<String> columnNames){
		String randomPatientId = "EMR"+new Random().nextInt();
		EndTBPatient patient = new EndTBPatient(randomPatientId, row.getCell(columnNames.get(1)),
				row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)), new Date(), 50,row.getCell(columnNames.get(6)));

		return patient;
	}
}
