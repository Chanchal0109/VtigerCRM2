package VtigerCRM;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.ListenerImplimentation;
import commonUtils.ListenerImplimentation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

@Listeners(ListenerImplimentation.class)
public class Organization {

	//all ojects should be created before @Test
	PropertyFileUtil pu=new PropertyFileUtil();
	WebDriverUtil wu = new WebDriverUtil();
	ExcelUtil eu = new ExcelUtil();
	JavaUtil ju=new JavaUtil();
	
	@Test
	public void organizationTest() throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		//to maximize the window
		wu.maximize(driver);
		//to apply wait for findelement
		wu.implicitwait(driver);
		//to read data from propertyfile
		String url = pu.getDataFromProertyfile("Url");
	    String user = pu.getDataFromProertyfile("Username");
	    String pass = pu.getDataFromProertyfile("Password");
	    
	    //to read data from excel file
	    String orgname = eu.getDataFromExcel("Organizations", 0, 1);
	   String group = eu.getDataFromExcel("Organizations", 1, 1);
	    //to launch the application
		driver.get(url);
		//to logn to application
		driver.findElement(By.name("user_name")).sendKeys(user);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		//to click on organization
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		//to click on organisation (+) sign
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		//to eneter data in organisaton textfield
		driver.findElement(By.name("accountname")).sendKeys(orgname+ju.getRandomNumber());
		//to assigned to click on Group the radio button
         driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
//		//to select the option from the dropdown by creating obj of the select class
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wu.handledropdown(dropdown, group);
		//click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		//mouse hover on administrative
		Thread.sleep(2000);
		WebElement admin = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wu.mousehover(driver, admin);
		//click on signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
		
		 
     	
//		
		
		
		
		
		
		
	}
}
