package setltestPOMSelbank;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestLoansPage {
public RequestLoansPage(WebDriver driver){
PageFactory.initElements(driver, this);
	}

@FindBy(xpath = "//input[contains(@ng-model,'loanRequest.amount')]")
	private WebElement loanAmountTextBox;
	
@FindBy(xpath = "//input[contains(@ng-model,'loanRequest.downPayment')]")
	private WebElement downPaymentTextBox;
	
@FindBy(xpath = "//input[contains(@value,'Apply Now')]")
	private WebElement applyNowButton;
	
	public void setLoanAmountField(String text) {
			loanAmountTextBox.sendKeys(text);
		}
	public void setDownPaymentField(String text) {
			downPaymentTextBox.sendKeys(text);
		}
	public void applyNowClickButton() {
			applyNowButton.click();
		}		
	public void loanAmountWait(WebDriver driver) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(loanAmountTextBox));
	}

	public void downPaymentWait(WebDriver driver) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(downPaymentTextBox));
	}
	public void clickApplyNowWait(WebDriver driver) {
		new WebDriverWait(driver, 60).ignoring(ElementClickInterceptedException.class).until(d -> {
			applyNowButton.click();
			return true;
		
		});
	}
}
 
