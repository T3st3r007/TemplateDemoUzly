package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import utilities.ExtentReports.ExtentTestManager;

public class HomePage extends BasePage {

	SoftAssert sa = new SoftAssert();

	// *********Constructor*********
	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// *********Page Variables*********
	String baseURL = "https://iszu.test.uvo.gov.sk/";
	String login = "balog@balog.sk";
	String pass = "admin";

	// *********Web Elements*********
	String meno = "username";
	String heslo = "password";
	String prihlasitSa = "submitbtn";
	String nadmilimitneFormulare = "ui-accordion-content_text-header-0";

	String errorMessageXpath = "//form[@id='loginData']/div[1]/div/div/p";

	// *********Page Methods*********

	// Go to Homepage
	public void goToISZU() {
		driver.get(baseURL);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Loaded to ISZU");
		// driver.navigate().to(baseURL)
	}

	public void loginToISZU(String username, String password) {
		// Enter Username(Email)
		writeText(By.id(meno), username);
		// Enter Password
		writeText(By.id(heslo), password);
		// Click Login Button
		click(By.id(prihlasitSa));
		ExtentTestManager.getTest().log(LogStatus.INFO, "Loged to ISZU");
	}

	// Verify Username or Password Condition
	public void verifyErrorMessage(String expectedText) {
		String errorMessageText = readText(By.xpath(errorMessageXpath));

		if (!errorMessageText.equals(expectedText)) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Ocakavany: " + expectedText + " Realny:" + errorMessageText + "");
		}

		// assert.assertEquals(errorMessageText, expectedText);

	}

	public void clickFormulare() {
		click(By.id(nadmilimitneFormulare));
		ExtentTestManager.getTest().log(LogStatus.INFO, "Formulare Click");
	}
}
