package org.bahmni.test.page;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.bahmni.test.DriverFactory;
import org.bahmni.test.TestSpecException;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.domain.Patient;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class RegistrationFirstPageSpec {

	private final WebDriver driver;

	public static final String PATIENT_KEY = "patient";

	public RegistrationFirstPageSpec() {
		this.driver = DriverFactory.getDriver();
	}

	@Step("On the new patient creation page")
	public void navigateToPatientCreatePage() {
		driver.get(RegistrationFirstPage.URL);
	}

	@Step("Create the following patient <table>")
	public void createPatients(Table table) {
		List<TableRow> rows = table.getTableRows();
		List<String> columnNames = table.getColumnNames();

		if (rows.size() != 1) {
			throw new TestSpecException("Only one patient should be provided in the table");
		}

		Patient patient = transformTableRowToPatient(columnNames, rows.get(0));

		RegistrationFirstPage registrationFirstPage = org.bahmni.test.PageFactory.getRegistrationFirstPage();
		registrationFirstPage.storePatientInSpecStore(patient);
		registrationFirstPage.registerPatient(patient);
	}

	@Step("Click on search patient link")
	public void navigateToPatientSearch() {
		RegistrationFirstPage registrationFirstPage = org.bahmni.test.PageFactory.getRegistrationFirstPage();
		registrationFirstPage.navigateToSearchPage();
	}

	@Step("Ensure that the patient edit page is opened for previously created patient")
	public void ensureThePatientPageIsOpened() {
		RegistrationFirstPage registrationFirstPage = org.bahmni.test.PageFactory.getRegistrationFirstPage();
		registrationFirstPage.verifyPatientWithIdentifierAndName();
	}

	private Patient transformTableRowToPatient(List<String> columnNames, TableRow row) {
		String randomPatientId = "EMR"+new Random().nextInt();
		Patient patient = new Patient(randomPatientId, row.getCell(columnNames.get(1)),
				row.getCell(columnNames.get(2)), row.getCell(columnNames.get(3)), new Date(), 50);

		return patient;
	}
}
