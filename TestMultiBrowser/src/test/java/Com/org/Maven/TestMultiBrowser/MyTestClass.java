package Com.org.Maven.TestMultiBrowser;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.*;
import org.openqa.selenium.TakesScreenshot;

public class MyTestClass {
	
	WebDriver driver;
	
	public void grabScreenShot(WebDriver driver, String name) throws IOException
	{
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filePath = "C:\\SeleniumScreenShots\\" + name ;
		FileUtils.copyFile(screenShot, new File(filePath));
	}
	@Before
	public void Initialization()
	{
		//Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumIEChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// IE Driver
		//System.setProperty("webdriver.ie.driver", "C:\\SeleniumIEChromeDriver\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		
		//Firefox 
		//System.setProperty("webdriver.firefox.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		//driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
		//System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
		//driver=new Edge
		
	}
	@After
	public void CleanUp()
	{
		//driver.quit();
		
	}
	@Test
	public void MyTest() throws IOException
	{
		driver.navigate().to("http://docs.seleniumhq.org/");
		String title = driver.getTitle();
		System.out.println(title);
		
		grabScreenShot(driver, "seleniumhq.jpg");
	}
	
	

}
