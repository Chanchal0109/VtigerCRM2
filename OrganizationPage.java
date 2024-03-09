package object_repositary;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class OrganizationPage {

	@FindBy(css="img[src='themes/softed/images/btnL3Add.gif']")
	 private WebElement organization;

	public WebElement getOrganization() {
		return organization;
	} 
	
}
