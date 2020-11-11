package seltestPOMSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import setltestPOMSelbank.AccountsOverviewPage;
import setltestPOMSelbank.LoginPage;
import setltestPOMSelbank.RequestLoansPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Junit_Methods_Parabank {
	private WebDriver driver;
	private final String exePath = "c:\\geckodriver.exe";

	@Before
	public void systemDefine() {
		System.setProperty("webdriver.gecko.driver", exePath);
		driver = new FirefoxDriver();// launch
		
		driver.manage().window().maximize();
	}

	@After
	public void teardown() throws Throwable{ 
		driver.quit();
		//close
	}
	
	@Test
	public void requestLoan() throws Throwable {
		driver.get("https://parabank.parasoft.com/parabankv2/index.htm");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsernameField("john");
		loginpage.setPasswordField("demo");
		loginpage.clickLogin();
		//maven stuff
		String expectedWelcome = "Welcome John Smith";
		String actualWelcome = driver.findElement(By.xpath("//p[@Class='smallText']")).getText();
		Assert.assertEquals(expectedWelcome, actualWelcome);
		
		AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
 		accountsOverviewPage.clickOpenNewAccount(); 
		accountsOverviewPage.navigateRequestLoanButton();
		
		RequestLoansPage requestLoanPage = new RequestLoansPage(driver);
		requestLoanPage.loanAmountWait(driver);
		requestLoanPage.setLoanAmountField("1000");
		requestLoanPage.downPaymentWait(driver);
		requestLoanPage.setDownPaymentField("100");
		requestLoanPage.clickApplyNowWait(driver);
		
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("ParaBank | Loan Request"));
		
		
		System.out.print("Successfully opened the website www.parabank.com");
		
		//wait 3 sec
		Thread.sleep(3000);
	}
	/*
	private void loggingIn() throws Throwable {
		
		driver.get("https://parabank.parasoft.com/parabankv2/index.htm");

		LoginPage loginpage = new LoginPage(driver);

		loginpage.setUsernameField("john");

		loginpage.setPasswordField("demo");

		loginpage.clickLogin();
	}
	
	private void overview() throws Throwable{
		AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
		
 		accountsOverviewPage.clickOpenNewAccount(); 
		
		accountsOverviewPage.navigateRequestLoanButton();	
	}
	
	private void request() throws Throwable{
		RequestLoansPage requestLoanPage = new RequestLoansPage(driver);
		requestLoanPage.loanAmountWait(driver);
		requestLoanPage.setLoanAmountField("1000");
		
		requestLoanPage.downPaymentWait(driver);
		requestLoanPage.setDownPaymentField("100");
		
		requestLoanPage.clickApplyNowWait(driver);
		System.out.print("Successfully opened the website www.parabank.com");
		
		//wait 3 sec
		Thread.sleep(3000);	
	}*/
}
	