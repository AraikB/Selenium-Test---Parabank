package seltestPOMSel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import setltestPOMSelbank.AccountsOverviewPage;
import setltestPOMSelbank.LoginPage;
import setltestPOMSelbank.RequestLoansPage;

public class First_sel_test {
	public static void main(String[] args) throws InterruptedException {

		String exePath = "C:\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", exePath);
		
		// new instance of the driver (browser)
		WebDriver driver = new FirefoxDriver();
		
		//launch 
		driver.get("https://parabank.parasoft.com/parabankv2/index.htm");
		//login page actions
		LoginPage loginpage = new LoginPage(driver);
		loginpage.waitUntilClickable(UserNameField);
		loginpage.setUsernameField("john");
		loginpage.setPasswordField("demo");
		loginpage.clickLogin();

		//accounts overview actions
		AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
		
		accountsOverviewPage.navigateRequestLoanButton();
		
		RequestLoansPage requestLoanPage = new RequestLoansPage(driver);
		requestLoanPage.loanAmountWait(driver);
		requestLoanPage.setLoanAmountField("1000");
		
		requestLoanPage.downPaymentWait(driver);
		requestLoanPage.setDownPaymentField("100");
		
		requestLoanPage.clickApplyNowWait(driver);
		
		
		System.out.print("Successfully opened the website www.parabank.com");
		
		//wait 3 sec
		Thread.sleep(3000);
		//close
		driver.quit();
		}
}