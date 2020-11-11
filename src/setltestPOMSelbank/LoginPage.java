package setltestPOMSelbank;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//username pom
	@FindBy(xpath = "//input[contains(@name,'username')]")
	private WebElement usernameField;
		
	//pass POM
	@FindBy(xpath = "//input[contains(@name,'password')]")
	private WebElement passwordField;	

	//click
	@FindBy(xpath = "//input[contains(@value,'Log In')]")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
		 this.driver = driver;
		 wait = new WebDriverWait(driver, 10);
	}
	
	public void setUsernameField(String text) {
		usernameField.sendKeys(text);
	}
	
	public void setPasswordField(String text) {
		passwordField.sendKeys(text);
	}
	public void clickLogin() {
		waitUntilClickable(loginButton).click();
	}
	
	private WebElement waitUntilClickable(WebElement element) {
		return wait.until(elementToBeClickable(element));
	}
}
