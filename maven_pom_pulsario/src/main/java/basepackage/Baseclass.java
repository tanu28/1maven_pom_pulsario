package basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilitypackage.Util;

public class Baseclass {
	public static WebDriver driver;
	public static Properties prop;

	//public  static EventFiringWebDriver e_driver;
	//public static WebDriverEventListener eventListener;

	public Baseclass () {
		try {
	prop = new Properties();
	FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/config/config.properties");

//	FileInputStream ip= new FileInputStream(System.getProperty("user.dir") +filepath);
	prop.load(ip);
		}
		catch (FileNotFoundException e){
	e.printStackTrace();
		} 
		catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
		}
	}

public static void intialization() {
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "E:\\selenium drivers\\chromedriver_win32\\chromedriver.exe");	
		driver = new ChromeDriver(); 
	}
	else if(browserName.equals("FF")){
		System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
		driver = new FirefoxDriver(); 
	}
	
	//for print the logs
	/*
	e_driver = new EventFiringWebDriver(driver);
	
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	*/
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));

}
}
