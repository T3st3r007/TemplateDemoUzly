package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import utilities.ExtentReports.ExtentTestManager;

import java.lang.reflect.Method;

public class LoginTests extends BaseTest {	

	// Test Data
	String wrongUsername = "onur@swtestacademy.com";
	String wrongPassword = "11122233444";

	@Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
	public void invalidLoginTest_InvalidUserNameInvalidPassword(Method method) throws InterruptedException {

		// *************PAGE INSTANTIATIONS*************
		HomePage homePage = new HomePage(driver, wait);

		// *************PAGE METHODS********************

		// Open ISZU Page
		homePage.goToISZU();

		// Login to ISZU
		homePage.loginToISZU(wrongUsername, wrongPassword);

		// *************ASSERTIONS***********************
		homePage.verifyErrorMessage("An incorrect Username or Password was specified");
	}

	@Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
	public void invalidLoginTest_EmptyUserEmptyPassword() throws InterruptedException {

		// *************PAGE INSTANTIATIONS*************
		HomePage homePage = new HomePage(driver, wait);

		// *************PAGE METHODS********************
		homePage.goToISZU();

		homePage.loginToISZU("", "");


		// *************ASSERTIONS***********************
		homePage.verifyErrorMessage("An incorrect Username or Password was specifieddd");
		
		homePage.loginToISZU("balog@balog.sk", "admin");
		homePage.clickFormulare();
		
	}

}
