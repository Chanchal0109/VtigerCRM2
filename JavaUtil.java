package commonUtils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class JavaUtil {
	
//everytime when we have to chne the data of excel sheet textfield that ti,e we use random number
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int num = r.nextInt(500);
		return num;
	}
	

}
