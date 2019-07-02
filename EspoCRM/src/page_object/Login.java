package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	
	@FindBy (how = How.NAME, using="username")
	WebElement Username;
	@FindBy (how = How.NAME, using="password")
	WebElement Password;
	@FindBy (how = How.ID, using="btn-login")
	WebElement Submit;
	
	
	public Login (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Homepage userLogin(String uname,String pword) {
		Username.sendKeys(uname);
		Password.sendKeys(pword);
		Submit.click();
		return new Homepage(driver);
	}
	
	public boolean getButton() {
		return Submit.isDisplayed();
	}


}
