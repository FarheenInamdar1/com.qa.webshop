package com.ws.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverScript {
	
	/*
	 * public driver reference which can be accessed acorss the project.
	 * global prop variable to use it out of the constructor.
	 */
	public static WebDriver driver ;
	static Properties prop ;                    
	
	/*
	 * This constructor is responsible for loading the properties file.
	 */
	public DriverScript()
	{
		try
		{
			File file = new File("./src/test/resources/config/config.properties") ;
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Unable to load Properties file : ");
			e.printStackTrace();              //System.out.println(e.getMessage());
		}
	}
	/*
	 * This method is used to launch browser, maximize it,
	 * apply all the wait settings, & navigate to application
	 */
	
	public void initApplication()
	{
		String browser = prop.getProperty("browser");
		if (browser.trim().equalsIgnoreCase("chrome")) 
		{
			System.out.println("Browser in use : " + browser);
			driver = new ChromeDriver();
		}
		else if (browser.trim().equalsIgnoreCase("Firefox")) 
		{
			System.out.println("Browser in use : " + browser);
			driver = new FirefoxDriver();
		}
		else if (browser.trim().equalsIgnoreCase("Edge")) 
		{
			System.out.println("Browser in use : " + browser);
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Unsupported browser type. Please check the config file.");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getAppURL();             
	}
	/*
	 * This method is used to get the app url from the properties file.
	 */
	public void getAppURL()
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}
	/*
	 * This method is used to quit the driver instance.
	 */
	public static void quitDriver()
	{
		driver.quit();
	}
}
