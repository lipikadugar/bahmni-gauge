package org.bahmni.test.page;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.bahmni.test.DriverFactory;
import org.bahmni.test.Tasks;
import org.bahmni.test.TestSpecException;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.domain.Patient;
import org.openqa.selenium.WebDriver;

import java.util.List;

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

		RegistrationFirstPage registrationFirstPage = org.bahmni.test.PageFactory.getRegistrationFirstPage();
		Patient patient = registrationFirstPage.transformTableRowToPatient(rows.get(0), columnNames);
		registrationFirstPage.storePatientInSpecStore(patient);
		Tasks task = new Tasks();
		task.waitForSpinner();
		registrationFirstPage.registerPatient(patient);
	}

	@Step("Click on search patient link")
	public void navigateToPatientSearch() {
		RegistrationFirstPage registrationFirstPage = org.bahmni.test.PageFactory.getRegistrationFirstPage();
		registrationFirstPage.navigateToSearchPage();
	}

	@Step("Validate that the patient edit page is opened for previously created patient")
	public void validateThePatientPageIsOpened() {
		RegistrationFirstPage registrationFirstPage = org.bahmni.test.PageFactory.getRegistrationFirstPage();
		registrationFirstPage.verifyPatientWithIdentifierAndName();
	}

	@Step("Ensure that the patient edit page is opened for previously created patient")
	public void ensureThePatientPageIsOpened() {
		RegistrationFirstPage registrationFirstPage = org.bahmni.test.PageFactory.getRegistrationFirstPage();
		registrationFirstPage.verifyPatientWithIdentifierAndName();
	}

	@Step("Start a visit <visit>")
	public void startPatientVisit(String visit) throws InterruptedException {
		RegistrationFirstPage registrationFirstPage = org.bahmni.test.PageFactory.getRegistrationFirstPage();
		registrationFirstPage.startVisit(visit);
	}

	@Step("Select check to enter patient ID manually")
	public void selectCheckToEnterPatientID() {
		RegistrationFirstPage registrationFirstPage = org.bahmni.test.PageFactory.getRegistrationFirstPage();
		registrationFirstPage.selectEnterPatientID();
	}
}
