package object_repositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	
	//identify organization
	
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	 private WebElement organization; 
	
	//identify Contacts
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement contacts ; 
	
	//identify Leads
	@FindBy(xpath="(//a[text()='Leads'])[1]")
	 private WebElement leads ; 
	
	//identify administrative img
	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement img ; 
	
	//identify Signout
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout ;

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getLeads() {
		return leads;
	}

	public WebElement getImg() {
		return img;
	}

	public WebElement getSignout() {
		return signout;
	}
	
	
}
