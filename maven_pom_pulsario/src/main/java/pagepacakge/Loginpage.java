package pagepacakge;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Baseclass;



public class Loginpage extends Baseclass {
	//Page Factory - OR:
			@FindBy(id="EmailAddress")
			WebElement username;
			
			@FindBy(name="Password")
			WebElement password;
			
			@FindBy(id="btnSubmitValidate")
			WebElement loginBtn;
			
			@FindBy(xpath="/html/body/div/div/img")
			WebElement pulsarioLogo;
			
			//Initializing the Page Objects:
			public Loginpage()
			{
				PageFactory.initElements(driver, this);
			}
			
			//Actions:
			public String validateLoginPageTitle(){
				return driver.getTitle();
			}
			
			public boolean validateImage(){
				return pulsarioLogo.isDisplayed();
			}
			
			public DashboardPage login(String un, String pwd){
				username.sendKeys(un);
				password.sendKeys(pwd);
				//loginBtn.click();
				    	JavascriptExecutor js = (JavascriptExecutor)driver;
				    	js.executeScript("arguments[0].click();", loginBtn);
				    return new DashboardPage();	
				
	}
			
}
