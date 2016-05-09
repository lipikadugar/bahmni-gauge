package test.bahmni;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

	public static ChromeDriver Webdriver;

	public static void waitUntilAppReady(ChromeDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Boolean elem_obj = wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.cssSelector("#overlay")));
	}

	public static ChromeDriver launchApp() throws InterruptedException {
		Webdriver = new ChromeDriver();
		Webdriver.manage().window().setSize(new Dimension(1440, 900));
		Webdriver.get("https://172.18.2.27/home");
		Thread.sleep(1000);

		return Webdriver;
	}
	
	public static ChromeDriver launchAppWithURL(String URL) throws InterruptedException {
		Webdriver = new ChromeDriver();
		Webdriver.manage().window().setSize(new Dimension(1440, 900));
		Webdriver.get(URL);
		Thread.sleep(1000);

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
		//jsonObject = (JsonObject) jsonObject.put("ID", value);

		if (jsonObject.get(key) != null)
			return jsonObject.get(key).toString()
					.substring(1, jsonObject.get(key).toString().length() - 1);

		return null;
	}
}
