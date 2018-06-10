package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public WebDriver driver;
	public WebDriverWait wait;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeClass(description = "Class Level Setup!")
	public void setup() {
		driver = driverSetup("FF");
	}

	@AfterClass(description = "Class Level Teardown!")
	public void teardown() {
		driver.quit();
	}

	public WebDriver driverSetup(String driverType) {
		driverType = driverType.toLowerCase();
		WebDriver driver = null;
		if (driverType.equals("ff") || driverType.equals("firefox")) {
			System.out.println("Used driver:" + driverType);
			// set up path to driver
			System.setProperty("webdriver.gecko.driver", "D:\\testing\\workspace\\TemplateDemo\\drivers\\geckodriver.exe");
			// Create a Firefox driver. All test classes use this.
			driver = new FirefoxDriver();
			// Maximize Window
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 15);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		} else if (driverType.equals("chrome")) {
			System.out.println("Used driver:" + driverType);
			// set up path to driver
			System.setProperty("webdriver.chrome.driver", "D:\\testing\\workspace\\TemplateDemo\\drivers\\chromedriver.exe");
			// Create a Chrome driver. All test classes use this.
			driver = new ChromeDriver();
			// Maximize Window
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 15);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} else if (driverType.equals("ie") || driverType.equals("internet explorer")) {
			System.out.println("Used driver:" + driverType);
			// set up path to driver
			System.setProperty("webdriver.ie.driver", "D:\\testing\\workspace\\TemplateDemo\\drivers\\IEDriverServer.exe");
			// Create a IE driver. All test classes use this.
			driver = new InternetExplorerDriver();
			// Maximize Window
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 15);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} else {
			System.out.println("Driver is not supported");
		}
		return driver;
	}

}
