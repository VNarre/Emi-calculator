package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoanUI extends BasePage{
	
	public LoanUI(WebDriver driver) {
		// BasePage constructor //
			super(driver);
		}
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public Actions move = new Actions(driver);
	
	public String loanCalcTitle() {
		String Title_p3 = driver.getTitle();
		return Title_p3;
	}
	
	@FindBy(id="menu-item-dropdown-2696")
	WebElement calculators;
	
	public void menubar() {
		calculators.click();
	}
	
	@FindBy(xpath="//*[@id=\"menu-item-2423\"]/a")
	WebElement loan_calc;
	
	public void loancalc() {
		loan_calc.click();
	}
	
	// EMI Button
	
	@FindBy(xpath="//*[@id=\"emi-calc\"]/a[1]")
	WebElement emi;
	
	public void emi() {
		emi.click();
	}
	
	
	@FindBy(xpath="//*[@id=\"loanamountslider\"]/div")
	WebElement loan_amt;
	@FindBy(id="loanamount")
	WebElement loan_amount;
	
	public String loanamt() {
		Action l_amt = (Action) move.dragAndDropBy(loan_amt, 112, 0).build();
		l_amt.perform();
		String loan_value = loan_amount.getAttribute("value");
		return loan_value;
	}
	
	
	@FindBy(id="loaninterestslider")
	WebElement interest_r;
	@FindBy(id="loaninterest")
	WebElement interest_rate_;
	
	public String interest() {
		Action int_r = (Action) move.dragAndDropBy(interest_r, 112, 0).build();
        int_r.perform();
        String int_rate = interest_rate_.getAttribute("value");
		return int_rate;
	}
	
	//Loan Tenure for Year
	
	@FindBy(xpath="//label[text()=\"Loan Amount\"]")
	WebElement loan_ten;
	@FindBy(id="loantermslider")
	WebElement loan_tenure_;
	@FindBy(xpath="//*[@id=\"loantermslider\"]/span")
	WebElement tenure_;
	@FindBy(id="loanterm")
	WebElement tenure_yr;
	
	public String loanTenureYear() {
		js.executeScript("arguments[0].scrollIntoView();",loan_ten);
		Action loan_1 = (Action) move.dragAndDropBy(loan_tenure_, -150, 0).build();
		loan_1.perform();
		String tenure_loan1 = tenure_.getAttribute("style");
		return tenure_loan1;
	}
	
	public String loanTenureYr() {
		tenure_yr.clear();
		String tenure_loan2 = tenure_.getAttribute("style");
		return tenure_loan2;
	}
	
	
	//Loan Tenure for Month
	
	@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[2]")
	WebElement loanten_mon;
	
	public String loanTenureMonth() {
		loanten_mon.click();
		Action loan_2 = (Action) move.dragAndDropBy(loan_tenure_, -150, 0).build();
		loan_2.perform();
		String tenure_loan3 = tenure_.getAttribute("style");
		return tenure_loan3;
	}
	
	public String loanTenureMn() {
		tenure_yr.clear();
		String tenure_loan4 = tenure_.getAttribute("style");
		return tenure_loan4;
	}
	
	
	//Loan Amount
	
	@FindBy(id="loan-amount-calc")
	WebElement loanamount;
	
	public void loanAmount() {
		js.executeScript("arguments[0].scrollIntoView();",loanamount);
		loanamount.click();
	}

	
	@FindBy(id="loanemislider")
	WebElement loanemi;
	
	@FindBy(id="loanemi")
	WebElement l_e;
	
	public String loanEMI() {
		Action loan_emi = (Action) move.dragAndDropBy(loanemi, -151, 0).build();
		loan_emi.perform();
		String loan_emi_ = l_e.getAttribute("value");
		return loan_emi_;
	}
	
	@FindBy(id="loan-tenure-calc")
	WebElement loantenure;
	
	public void loanTenure() {
		loantenure.click();
	}

}
