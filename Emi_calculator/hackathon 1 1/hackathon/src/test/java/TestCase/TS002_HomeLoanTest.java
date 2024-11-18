package TestCase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.HomeLoan;

public class TS002_HomeLoanTest extends BaseClass{
	
	
	
	@Test
	public void homeloan() throws IOException
	{
		HomeLoan home = new HomeLoan(driver);
		home.navigator();
		home.scrollToTable();
		home.getTableData();
		
		captureScreen("TC2");
		
	}

}
