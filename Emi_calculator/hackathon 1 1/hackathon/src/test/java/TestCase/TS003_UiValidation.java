package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LoanUI;

public class TS003_UiValidation extends BaseClass {
	LoanUI ui;
	
	@Test(priority = 1,groups= {"master","sanity"})
	void calcLoan() {
		ui = new LoanUI(driver);
		ui.menubar();
		ui.loancalc();
		Assert.assertEquals(ui.loanCalcTitle(), "Loan Calculator — Calculate EMI, Affordability, Tenure & Interest Rate");
		
		
	}
	
	@Test(priority = 2,groups= {"master","sanity"})
	void emiBtn() {
		ui.emi();
		
	}
	
	
	@Test(priority = 3,groups= {"master","regression"})
	void rInterest() {
		Assert.assertEquals(ui.interest(),"13.5");
	
	}
	
	//Loan Tenure for Year
	@Test(priority = 4,groups= {"master","regression"})
	void yearLoanTenure() throws IOException {
		Assert.assertNotEquals(ui.loanTenureYear(), ui.loanTenureYr());
		
	}
	
	//Loan Tenure for Month
	@Test(priority = 5,groups= {"master","regression"})
	void monthLoanTenure() throws IOException {
		Assert.assertNotEquals(ui.loanTenureMonth(), ui.loanTenureMn());
	
	}
	
	@Test(priority = 6,groups= {"master","regression"})
	void amountLoan() throws IOException {
		ui.loanAmount();
		Assert.assertEquals(ui.loanEMI(), "26,500.00");
		Assert.assertEquals(ui.interest(),"13.5");
		Assert.assertNotEquals(ui.loanTenureYear(), ui.loanTenureYr());
		Assert.assertNotEquals(ui.loanTenureYear(), ui.loanTenureYr());
		
	}
	
	@Test(priority = 7,groups= {"master","regression"})
	void tenureLoan() throws IOException {
		ui.loanTenure();
		Assert.assertEquals(ui.loanamt(),"41,00,000");
		Assert.assertEquals(ui.loanEMI(), "46,961.90");
		Assert.assertEquals(ui.interest(),"13.5");
		
	}
	

}
