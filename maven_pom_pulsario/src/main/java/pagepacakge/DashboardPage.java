package pagepacakge;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Baseclass;

public class DashboardPage extends Baseclass {

@FindBy (id = "managUserNavSuper")
WebElement manageuser;
@FindBy(id = "ManagePatientsprovider")
WebElement managepatient;

@FindBy(id = "MyInboxprovider")
WebElement inbox;

@FindBy (id= "ProviderReports")
WebElement reports;

public DashboardPage() {
	PageFactory.initElements(driver, this);
}

public Createuserpage clickmanagepatient() {
	managepatient.click();
	return new Createuserpage();
}
public Createuserpage clickManageUser() {
	manageuser.click();
	return new Createuserpage();
}

}