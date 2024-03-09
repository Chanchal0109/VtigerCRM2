package object_repositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationInformationPage {

	//identify the orgnanization name
	@FindBy(name="accountname")
    private WebElement organizaationnametf;

	public WebElement getOrganizaationnametf() {
		return organizaationnametf;
	}
     public WebElement getGroupbtn() {
		return groupbtn;
	}
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
     private WebElement groupbtn;
		
	
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;

	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getDropdown() {
		return dropdown;
	}
	//identify save button
	@FindBy(xpath="(//input[@name='button'])[2]")
	private WebElement savebtn;
	}
	

