package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestLogin extends BaseTest
{
	@Test
	public void testLogin()
	{
		
		LoginPage login=new LoginPage(driver);
		for(int i=1;i<=Lib.getRowCount("InvalidLogin");i++)
		{
	
		String un=Lib.getCellValue("InvalidLogin", i, 0);
		String pw=Lib.getCellValue("InvalidLogin", i, 1);
		//String expectedTitle=Lib.getCellValue("ValidLogin", 1, 2);
		login.setUsername(un);
		login.setPassword(pw);
		login.clickLogin();
		String actualTitle=driver.getTitle();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualTitle, "");
		s.assertAll();
		}
		
		
	}

}
