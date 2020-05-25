package testpackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.Baseclass;
import pagepacakge.DashboardPage;
import pagepacakge.Loginpage;

public class Logintest extends Baseclass {
Loginpage loginpageobj;
DashboardPage dashboardobj;

public Logintest() {
	super();
}

@BeforeMethod
public void setUp(){
intialization();
loginpageobj = new Loginpage();
}

@Test(priority=1)
public void loginPageTitleTest(){
	String title = loginpageobj.validateLoginPageTitle();
	Assert.assertEquals(title, "Pulsario | Login");
}

@Test(priority=2)
public void crmLogoImageTest(){
	boolean flag = loginpageobj.validateImage();
	Assert.assertTrue(flag);
}


@Test(priority=3)
public void loginTest(){
	dashboardobj = loginpageobj.login(prop.getProperty("username"),prop.getProperty("password"));
}



@AfterMethod
public void tearDown(){
driver.quit();
}
}
