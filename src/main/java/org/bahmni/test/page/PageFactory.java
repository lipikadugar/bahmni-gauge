package org.bahmni.test.page;

import org.bahmni.test.Common;

public class PageFactory {

	public static LoginPage getLoginPage(){
		LoginPage loginPage = org.openqa.selenium.support.PageFactory.initElements(Common.Webdriver, LoginPage.class);
		Common.waitForSpinner();
		return loginPage;
	}

	public static HomePage getHomePage(){
		HomePage homePage = org.openqa.selenium.support.PageFactory.initElements(Common.Webdriver, HomePage.class);
		Common.waitForSpinner();;
		return homePage;
	}

	public static RegistrationSearch getRegistrationSearchPage(){
		RegistrationSearch registrationSearch = org.openqa.selenium.support.PageFactory.initElements(Common.Webdriver, RegistrationSearch.class);
		Common.waitForSpinner();;
		return registrationSearch;
	}


}
