package Library;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.RegistrationSearch;
import PageObjects.Registration_Page1;

public class Common {

	public static ChromeDriver Webdriver;
	public static String URL;
	
	public static void waitUntilAppReady(ChromeDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Boolean elem_obj = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.cssSelector("#overlay")));
	}
	
	public static ChromeDriver launchApp() throws InterruptedException, IOException {
		/*DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
		capabilities.setCapability("--ignore-ssl-errors", true);
		capabilities = new DesiredCapabilities();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {"--web-security=no", "--ignore-ssl-errors=yes"});*/
        Webdriver = new ChromeDriver();
		URL = getEnvDetails("QA","URL");
		Webdriver.get(URL+"/home");
		Thread.sleep(1000);
		Webdriver.manage().window().setSize(new Dimension(1440, 900));
		
		return Webdriver;
	}

	public static void navigateToDashboard() throws InterruptedException {
		waitUntilAppReady(Webdriver);
		Webdriver.get("https://172.18.2.27/bahmni/home/index.html#/dashboard");
	}

	public static void navigateToSearchPage() throws InterruptedException {
		waitUntilAppReady(Webdriver);
		Webdriver.get("https://172.18.2.27/bahmni/registration/index.html#/search");
	}
	
	public static String getEnvDetails(String jsonPath, String key) throws IOException{
		InputStream fis = new FileInputStream("..//bahmni//Env.json");
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

		InputStream fis = new FileInputStream("..//bahmni//PatientProfile.json");
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

		InputStream fis = new FileInputStream("..//bahmni//PatientProfile.json");
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
		Registration_Page1 registration_page = new Registration_Page1();
		
		Common.navigateToSearchPage();
		registration_search.searchPatientWithID("GAN", getJsonKeyValue("patient", "ID").substring(3,getJsonKeyValue("patient", "ID").length()));
		registration_page.startVisit();
		waitUntilAppReady(Webdriver);
	}
	
	public static void getCurrentTab(){
		ArrayList<String> tabs2 = new ArrayList<String> (Webdriver.getWindowHandles());
		Webdriver.switchTo().window(tabs2.get(0));
		Webdriver.close();
		Webdriver.switchTo().window(tabs2.get(1));
	}
}
