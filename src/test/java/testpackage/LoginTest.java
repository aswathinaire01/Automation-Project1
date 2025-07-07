package testpackage;

import org.testng.annotations.Test;
import basepackage.BaseClass;
import pagepackage.LoginPage;
import utilitiespackage.ExcelUtilities;

public class LoginTest extends BaseClass {
	
	@Test
	public void dataDriven() throws Exception
	{
		LoginPage ob=new LoginPage (driver);		
		ob.logoCheck();
		ob.titleCheck();
		ob.loginClick();		
		String xl="C:\\Users\\Lenovo\\Desktop\\Relaxo.xlsx";
		String Sheet="Sheet1";
		int rowCount=ExcelUtilities.getRowCount(xl,Sheet);
		for(int i=1;i<=rowCount;i++)
		{
			
			String Username=ExcelUtilities.getCellValString(xl,Sheet,i,0);
			System.out.println("Username="+Username);
			
			String pwd=ExcelUtilities.getCellValString(xl,Sheet,i,1);
			System.out.println("Password="+pwd);
			
			ob.setValues(Username, pwd);
		}	
		ob.screenShot();
	}
}
