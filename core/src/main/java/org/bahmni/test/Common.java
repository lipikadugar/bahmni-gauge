package org.bahmni.test;

import org.bahmni.test.page.registration.RegistrationFirstPage;
import org.bahmni.test.page.registration.RegistrationSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Common {

	public static ChromeDriver Webdriver;
	public static String URL = "https://172.18.2.35";
	public static String patientID;

	public static void waitForSpinner(){
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(Webdriver, 60);
			Boolean spinner = wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.cssSelector("#overlay")));

		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static ChromeDriver launchApp() throws InterruptedException, IOException {
        Webdriver = new ChromeDriver();
//		URL = getEnvDetails("QA","URL");
		Webdriver.get(URL+"/home");
		Thread.sleep(1000);
		Webdriver.manage().window().setSize(new Dimension(1440, 900));
		
		return Webdriver;
	}

	public static void navigateToDashboard() throws InterruptedException {
		waitForSpinner();
		Webdriver.get(URL+"/bahmni/home/index.html#/dashboard");
	}

	public static void navigateToSearchPage() throws InterruptedException {
		waitForSpinner();
		Webdriver.get(URL+"/bahmni/registration/index.html#/search");
	}
	
	public static String getEnvDetails(String jsonPath, String key) throws IOException{
		InputStream fis = new FileInputStream("Env.json");
		JsonReader jsonReader = Json.createReader(fis);
		// get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();
		JsonArray jsonArray = jsonObject.getJsonArray("Environments");

		String[] path = jsonPath.split("/");
		jsonObject = (JsonObject) jsonArray.get(0);

		for (int i = 0; i < path.length; i++)
			jsonObject = (JsonObject) jsonObject.get(path[i]);

		jsonReader.close();
		fis.close();

		if (jsonObject.get(key) != null)
			return jsonObject.get(key).toString()
					.substring(1, jsonObject.get(key).toString().length() - 1);

		return null;
	}

	public String getJsonKeyValue(String jsonPath, String key)
			throws IOException {

		InputStream fis = new FileInputStream("..//endtb-functional-tests//PatientProfile.json");
		JsonReader jsonReader = Json.createReader(fis);
		// get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();
		JsonArray jsonArray = jsonObject.getJsonArray("patients");

		String[] path = jsonPath.split("/");
		jsonObject = (JsonObject) jsonArray.get(0);

		for (int i = 0; i < path.length; i++)
			jsonObject = (JsonObject) jsonObject.get(path[i]);

		jsonReader.close();
		fis.close();

		if (jsonObject.get(key) != null)
			return jsonObject.get(key).toString()
					.substring(1, jsonObject.get(key).toString().length() - 1);

		return null;
	}
	
	public String putJsonKeyValue(String key, String value)
			throws IOException {

		InputStream fis = new FileInputStream("..//endtb-functional-tests//PatientProfile.json");
		JsonReader jsonReader = Json.createReader(fis);
		// get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();
		JsonArray jsonArray = jsonObject.getJsonArray("patients");

		jsonReader.close();
		fis.close();
		
		JsonValue val = jsonArray;	
		//jsonObject = (JsonObject) jsonArray.put("ID", value);

		if (jsonObject.get(key) != null)
			return jsonObject.get(key).toString()
					.substring(1, jsonObject.get(key).toString().length() - 1);

		return null;
	}
	
	public void searchAndOpenVisit() throws InterruptedException, IOException{
		
		RegistrationSearch registration_search = new RegistrationSearch();
		RegistrationFirstPage registration_page = new RegistrationFirstPage();
		
		Common.navigateToSearchPage();
		registration_search.searchByIdentifier("GAN", getJsonKeyValue("patient", "ID").substring(3,getJsonKeyValue("patient", "ID").length()));
		registration_page.startVisit();
		waitForSpinner();
	}

	public static void getCurrentTab(){
		ArrayList<String> tabs2 = new ArrayList<String> (Webdriver.getWindowHandles());
		Webdriver.switchTo().window(tabs2.get(0));
		Webdriver.close();
		Webdriver.switchTo().window(tabs2.get(1));
	}
}
