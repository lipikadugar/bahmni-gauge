package org.bahmni.test.page.registration;

import org.bahmni.test.Common;
import org.bahmni.test.page.BahmniPage;
import org.bahmni.test.page.PageFactory;
import org.bahmni.test.page.home.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationVisitDetailsPage extends BahmniPage{
	
	@FindBy(how= How.CSS, using = "#observation_1")
	public WebElement height;
	
	@FindBy(how= How.CSS, using = "#observation_2")
	public WebElement weight;
	
	@FindBy(how= How.CSS, using = "#observation_4")
	public WebElement fees;
	
	@FindBy(how= How.CSS, using = "#observation_5")
	public WebElement comments;
	
	@FindBy(how= How.CSS, using = ".confirm")
	public WebElement saveButton;
	
	@FindBy(how= How.CSS, using = ".fa-home")
	public WebElement homeButton;
	
	@FindBy(how= How.CSS, using = "button[ng-click='back()']")
	public WebElement backButton;

	@FindBy(how= How.CSS, using = "button.cancel")
	public WebElement closeVisit;
	
	@FindBy(how= How.CSS, using = ".fa-search")
	public WebElement searchLink;


	public RegistrationVisitDetailsPage enterVisitDetails(String Height, String Weight, String Fees, String Comments) {
		height.sendKeys(Height);
		weight.sendKeys(Weight);
		fees.sendKeys(Fees);
		comments.sendKeys(Comments);
		return clickSave();
	}
	
	public RegistrationVisitDetailsPage clickSave(){
		saveButton.click();
		Common.waitForSpinner();
		return PageFactory.getRegistrationVisitDetailsPage();
	}
	
	public HomePage navigateToHome(){
		homeButton.click();
		Common.waitForSpinner();
		return PageFactory.getHomePage();
	}
	
	public RegistrationFirstPage goToPatientPage(){
		backButton.click();
		Common.waitForSpinner();
		return PageFactory.getRegistrationFirstPage();
	}
	
	public RegistrationSearch closeVisit(){
		closeVisit.click();
		Common.waitForSpinner();
		return PageFactory.getRegistrationSearchPage();
	}
	
	public RegistrationSearch navigateToPatientSearchPage(){
		searchLink.click();
		Common.waitForSpinner();
		return PageFactory.getRegistrationSearchPage();
		
	}

}
