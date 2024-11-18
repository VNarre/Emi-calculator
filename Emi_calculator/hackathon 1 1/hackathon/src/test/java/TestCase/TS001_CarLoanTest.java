package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.CarLoan;


public class TS001_CarLoanTest extends BaseClass{
	

	@Test
	public void carLoan() throws IOException 
	{
		
		CarLoan obj = new CarLoan(driver);
		obj.navigator();
		obj.clickCarLoan();
		obj.setLoanAmt(p.getProperty("carLoanAmt"));
		obj.setInterest(p.getProperty("carLoanInt"));
		obj.moveLoanTenureSlider(p.getProperty("carLoanYr"));
		obj.clickOnYear();
		obj.scrollToTable();
		obj.clickOnYears();
		obj.printTheEMIPaymentTable();
		Assert.assertTrue(true);
		
	   captureScreen("TC1");
	}

}
