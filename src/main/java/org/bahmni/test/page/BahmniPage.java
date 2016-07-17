package org.bahmni.test.page;

import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.bahmni.test.page.program.domain.Program;
import org.bahmni.test.page.registration.domain.Patient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BahmniPage {

	protected static String BASE_URL = System.getenv("bahmni_gauge_env_url");

	public static final String PATIENT_KEY = "patient";
	public static final String PROGRAM_KEY = "program";

	public void storePatientInSpecStore(Patient value) {
		DataStore specStore = DataStoreFactory.getSpecDataStore();
		specStore.put(PATIENT_KEY, value);
	}

	public Patient getPatientFromSpecStore(){
		DataStore specStore = DataStoreFactory.getSpecDataStore();
		return (Patient) specStore.get(PATIENT_KEY);
	}

	public void storeProgramInSpecStore(Program program){
		DataStore specStore = DataStoreFactory.getSpecDataStore();
		specStore.put(PROGRAM_KEY, program);
	}

	public void waitForSpinner(WebDriver driver) {
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#overlay")));
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Program getProgramFromSpecStore(){
		return (Program) DataStoreFactory.getSpecDataStore().get(PROGRAM_KEY);
	}
}
