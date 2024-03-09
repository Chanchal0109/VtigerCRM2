package object_repositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	//identify usename tf
	
	@FindBy(name="user_name")
	 private WebElement USERNAME; 
	//identify Password tf
	@FindBy(name="user_password")
	private WebElement Password;
	
	//Identify login button
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	public WebElement getUSERNAME() {
		return USERNAME;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
}

