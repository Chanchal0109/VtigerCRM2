package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

   public  WebDriver driver= new ChromeDriver();
	PropertyFileUtil pu=new PropertyFileUtil();
	WebDriverUtil wu = new WebDriverUtil();
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("connet to database");
		
	}
	
	@BeforeClass
	public void BC() throws IOException
	{
		//@BeforeClass is used to launch application
		String url = pu.getDataFromProertyfile("Url");
		
		//WebDriver driver = new ChromeDriver();
		//to maximize the window
		wu.maximize(driver);
		//to apply wait for findelement
		wu.implicitwait(driver);
		
		  //to launch the application
			driver.get(url);
	}
	
	@BeforeMethod
	public void BM() throws IOException
	{
		//@BeforeMethod is used to login to the application
		
		 String user = pu.getDataFromProertyfile("Username");
		  String pass = pu.getDataFromProertyfile("Password");
		  
		  driver.findElement(By.name("user_name")).sendKeys(user);
		  driver.findElement(By.name("user_password")).sendKeys(pass);
		  driver.findElement(By.id("submitButton")).click();
		   
		
	}
	
	@AfterMethod()
	public void AM() throws InterruptedException
	{
		//@AfterMethodis used to logout/Signout from the application
		
		Thread.sleep(2000);
		WebElement admin = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wu.mousehover(driver, admin);
		//click on signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		
	}
	
	@AfterClass
	public void AC()
	{
		//@AfterClass is used to close the browser
		driver.quit();
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("Disconnect from database");
	}
	
	
	
	
	
	
}
