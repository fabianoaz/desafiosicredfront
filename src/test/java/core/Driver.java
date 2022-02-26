package core;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	WebDriver driver;
	
	public WebDriver GetDriver()
	{
		System.setProperty("webdriver.chrome.driver", ".\\DRIVER\\97.exe");
		driver = (WebDriver) new ChromeDriver();	
		return driver;
	}	
}
