package testpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import basepackage.Baseclass;
import pagepacakge.Createuserpage;
import pagepacakge.DashboardPage;
import pagepacakge.Loginpage;
import utilitypackage.Util;

public class Usertest extends Baseclass {
	Loginpage loginpageobj;
	DashboardPage dashboardobj;
	Util utilobj;
	Createuserpage createuserobj;
	
	String sheetName = "contacts";

	public Usertest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		intialization();
		utilobj = new Util();
		createuserobj = new Createuserpage();
		loginpageobj = new Loginpage();
		dashboardobj = loginpageobj.login(prop.getProperty("username"), prop.getProperty("password"));
		//TestUtil.runTimeInfo("error", "login successful");
		//testUtil.switchToFrame();
		createuserobj = dashboardobj.clickManageUser();
	}
	
	@Test(priority =1)
	public void test(){
		createuserobj.clickadduser();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = Util.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewuser(String ROLE, String FNAME, String LNAME, String USER, String EMAIL, String PHONE,
			String ADDRESS, String CITY, String ZIPCODE)
	{
		//homePage.clickOnNewContactLink();
		dashboardobj.clickManageUser();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		//contactsPage.createNewContact(title, firstName, lastName, company);
		createuserobj.clickadduser();
		createuserobj.createNewuser(ROLE, FNAME, LNAME, USER, EMAIL, PHONE, ADDRESS, CITY, ZIPCODE);
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
