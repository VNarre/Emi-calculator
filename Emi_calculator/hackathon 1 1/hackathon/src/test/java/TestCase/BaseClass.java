package TestCase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Properties p;
	public static String targetFilePath;
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default : System.out.println("Invalid Browser name"); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}catch(NoAlertPresentException e) {
			
		}
	}
	public void captureScreen(String name) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    targetFilePath=System.getProperty("user.dir")+".\\Screenshots\\" + name +".png";
		File targetFile=new File(targetFilePath);
		FileUtils.copyFile(sourceFile, targetFile);
		}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

}
