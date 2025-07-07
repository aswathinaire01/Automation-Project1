package testpackage;

import org.testng.annotations.Test;
import basepackage.BaseClass;
import pagepackage.RegisterPage;

public class RegisterTest extends BaseClass{
			
	@Test
    public void registerToRelaxoSite() throws InterruptedException {
        RegisterPage ob = new RegisterPage(driver);
        ob.logIn();
        ob.openCreateAccountForm();    
        ob.setValues("Aswathi", "Nair", "aswathi123@gmail.com", "test@1234");
        ob.clickCreate();
    }	
}
