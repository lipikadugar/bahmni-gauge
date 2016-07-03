package org.bahmni.test;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Common {

	public static ChromeDriver Webdriver;
	public static String URL = "https://172.18.2.27";
	public static String patientID;

	public static void waitForSpinner(){
	}

//	public static ChromeDriver launchApp() throws InterruptedException, IOException {
//        Webdriver = new ChromeDriver();
////		URL = getEnvDetails("QA","URL");
//		Webdriver.get(URL+"/home");
//		Thread.sleep(1000);
//		Webdriver.manage().window().setSize(new Dimension(1440, 900));
//
//		return Webdriver;
//	}

	public static void navigateToDashboard() throws InterruptedException {
//		waitForSpinner();
		Webdriver.get(URL+"/bahmni/home/index.html#/dashboard");
	}

	public static void navigateToSearchPage() throws InterruptedException {
//		waitForSpinner();
		Webdriver.get(URL+"/bahmni/registration/index.html#/search");
	}

	public static void getCurrentTab(){
		ArrayList<String> tabs2 = new ArrayList<String> (Webdriver.getWindowHandles());
		Webdriver.switchTo().window(tabs2.get(0));
		Webdriver.close();
		Webdriver.switchTo().window(tabs2.get(1));
	}
}
