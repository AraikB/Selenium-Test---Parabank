package setltestPOMSelbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverviewPage {
		public AccountsOverviewPage(WebDriver driver) {
			 PageFactory.initElements(driver, this);
		}
		@FindBy(xpath = "//a[@href='/parabankv2/openaccount.htm']")
		private WebElement openNewAccountButton;

		@FindBy(xpath = "//a[@href='/parabankv2/requestloan.htm']")
		private WebElement navigateRequestLoan;
		
		public void clickOpenNewAccount() {
			openNewAccountButton.click();
			
		}	
		public void navigateRequestLoanButton() {
			navigateRequestLoan.click();
		}
}
 