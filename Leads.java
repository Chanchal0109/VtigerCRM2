package VtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class Leads {

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
	   String firstname = eu.getDataFromExcel("Leads", 0, 1);
	   String lastname = eu.getDataFromExcel("Leads", 1, 1);
	   String company = eu.getDataFromExcel("Leads", 2, 1);
	   String assignto = eu.getDataFromExcel("Leads", 3, 1);
	    //to launch the application
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(user);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		
		driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
		
		//to enter the first name in firstname tf
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		//to enter the last name in lastname tf
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		//to enter the company name in company tf
	    driver.findElement(By.name("company")).sendKeys(company);
	    
	    //to click on group radio button
	    driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		//to select option from the dropdown
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wu.handledropdown(dropdown,assignto );
		
		//to click on save button
		//  driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		
		
		
		
		
		
		
		
		
		
}
}
