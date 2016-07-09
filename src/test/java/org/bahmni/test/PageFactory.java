package org.bahmni.test;

import org.bahmni.test.page.BahmniPage;
import org.bahmni.test.page.clinical.PatientListingPage;
import org.bahmni.test.page.home.HomePage;
import org.bahmni.test.page.login.LoginPage;
import org.bahmni.test.page.program.ProgramManagamentPage;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.RegistrationSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PageFactory {

	private static final String LOGIN = "login";
	private static final String HOME = "home";
	private static final String REGISTRATION_SEARCH = "registration.search";
	private static final String REGISTRATION_FIRST_PAGE = "registration.page1";
	private static final String REGISTRATION_VISIT_PAGE = "registration.visitPage";
	private static final String PROGRAMS_PAGE = "programs";
	private static final String PATIENT_LISTING_PAGE = "patient.listing.page";

	private static Properties props = new Properties();

	static{
		String implementationName = System.getenv("implementation_name");
		String fileName = implementationName == null ? "page.properties": implementationName + "-page.properties";
		InputStream is = ClassLoader.getSystemResourceAsStream(fileName);
		try {
			props.load(is);
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to locate page.properties");
		}

	}

	public static BahmniPage getPage(String key){
		if(!props.containsKey(key)){
			throw new RuntimeException("The page key ["+key+"] is not defined in page.properties file");
		}

		try {
			BahmniPage bahmniPage = (BahmniPage) org.openqa.selenium.support.PageFactory.initElements(DriverFactory.getDriver(), Class.forName((String) props.get(key)));
			waitForSpinner();
			return bahmniPage;
		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException("The class defined in page.properites file ["+props.get(key)+"] not available");
		}
	}

	public static void waitForSpinner() {
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 60);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#overlay")));
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static LoginPage getLoginPage(){
		return (LoginPage) getPage(LOGIN);
	}

	public static HomePage getHomePage(){
		return (HomePage) getPage(HOME);
	}

	public static RegistrationSearch getRegistrationSearchPage(){
		return (RegistrationSearch) getPage(REGISTRATION_SEARCH);
	}

	public static RegistrationFirstPage getRegistrationFirstPage() {
		return (RegistrationFirstPage) getPage(REGISTRATION_FIRST_PAGE);
	}

	public static ProgramManagamentPage getProgramManagementPage() {
		return (ProgramManagamentPage) getPage(PROGRAMS_PAGE);
	}

	public static PatientListingPage getPatientListingPage() {
		return (PatientListingPage) getPage(PATIENT_LISTING_PAGE);
	}
}
