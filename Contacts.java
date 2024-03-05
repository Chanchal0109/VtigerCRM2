package VtigerCRM;

import java.io.IOException;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.ListenerImplimentation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

@Listeners(ListenerImplimentation.class)
public class Contacts {

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
	    String firstname = eu.getDataFromExcel("Contacts", 0, 1);
	   String lastname = eu.getDataFromExcel("Contacts", 1, 1);
	   String group = eu.getDataFromExcel("Contacts", 2, 1);
	   String orgname = eu.getDataFromExcel("Contacts", 3, 1);
	    //to launch the application
		driver.get(url);
		//to login to application
		driver.findElement(By.name("user_name")).sendKeys(user);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		//to enter the firstname in firstname tf
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		
		//to enter the lastname in lasttname tf
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
		//to fail the testscript using asserttrue
		WebElement notifycheckbox = driver.findElement(By.name("notify_owner"));
		Assert.assertTrue(notifycheckbox.isSelected());
//		
		
		//to select the group dropdown 
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		//to select option from the dropdown
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wu.handledropdown(dropdown, group);
		
		//to click on the + of organization name
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		//to get the count of present windows windows
		
		//Transfer the Driver control from parent to child
		wu.switchWindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");

		//to inspect the search tf
		driver.findElement(By.cssSelector("input[name='search_text']")).sendKeys(orgname);
		
		//to click on search now
		driver.findElement(By.cssSelector("input[name='search']")).click();
		
		//click on the intel84 option 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Intel84']")).click();
		
		//Transfer the Driver control from parent to child
		wu.switchWindow(driver,"http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		//click on save button
        driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
        
        //to take screenshot
       // wu.screenshot(driver,"contact");
		
		//mouse hover on administrative
		Thread.sleep(2000);
		WebElement admin = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wu.mousehover(driver, admin);
		//click on signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
		

		
	}
}
