package radioAndCheckbx;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class HandleRadioCheck {

	WebDriver driver;

	public void invokeBrowser() throws InterruptedException {
		//Way to open Firefox Browser
		//System.setProperty("webdriver.gecko.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\geckodriver.exe");
		//driver = new FirefoxDriver();
		
		//Way to open Chrome Browser
		//System.setProperty("webdriver.chrome.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		//Way to open Microsoft Edge Browser
		//System.setProperty("webdriver.edge.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\MS Edge Webdriver\\MicrosoftWebDriver.exe");
		//driver = new EdgeDriver();
		
		//Way to open Microsoft IE Browser
		//System.setProperty("webdriver.ie.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\IEDriverServer_Win32_3.13.0\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		
		//Way to open Opera Browser (below 4 lines needed)
		System.setProperty("webdriver.opera.driver", "C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\operadriver_win64\\operadriver.exe");
		OperaOptions options = new OperaOptions();
		options.setBinary (new File("C:\\Users\\hck\\AppData\\Local\\Programs\\Opera\\launcher.exe"));
		driver = new OperaDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.com");
		Thread.sleep(5000);
	}

	public void selRadioCheck() {
		try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        driver.findElement(By.xpath(".//*[@id='BlogArchive1_ArchiveList']/ul[3]/li/a[2]")).click();
	        driver.findElement(By.xpath(".//*[@id='BlogArchive1_ArchiveList']/ul[3]/li/ul[4]/li/a[2]")).click();
	        WebElement Element = driver.findElement(By.xpath(".//*[@id='post-body-4966932485064487229']"));
	        js.executeScript("arguments[0].scrollIntoView();", Element);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser() {
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		HandleRadioCheck fb = new HandleRadioCheck();
		fb.invokeBrowser();
		fb.selRadioCheck();
		fb.closeBrowser();
	}


}
