package org.bahmni.test.page;

import org.bahmni.test.Common;
import org.bahmni.test.page.home.HomePage;
import org.bahmni.test.page.login.LoginPage;
import org.bahmni.test.page.program.ProgramManagementPage;
import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.RegistrationSearch;
import org.bahmni.test.page.registration.RegistrationVisitDetailsPage;

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

	private static Properties props = new Properties();

	static{
		InputStream is = ClassLoader.getSystemResourceAsStream("page.properties");
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
			BahmniPage bahmniPage = (BahmniPage) org.openqa.selenium.support.PageFactory.initElements(Common.Webdriver, Class.forName((String) props.get(key)));
			Common.waitForSpinner();
			return bahmniPage;
		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException("The class defined in page.properites file ["+props.get(key)+"] not available");
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

	public static ProgramManagementPage getProgramManagementPage() {
		return (ProgramManagementPage) getPage(PROGRAMS_PAGE);
	}
	
	public static RegistrationVisitDetailsPage getRegistrationVisitDetailsPage() {
		return (RegistrationVisitDetailsPage) getPage(REGISTRATION_VISIT_PAGE);
	}
}
