package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CallsMgmt {
	
	WebDriver driver;
	
	@FindBy (how = How.XPATH, using="//a[contains(text(),\"Create Call\")]")
	WebElement CreateCallButton;
	@FindBy (how = How.XPATH, using="//select[@data-name='direction']/option[2]")
	WebElement DirectionDropdown;
	
	public CallsMgmt (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getButton() {
		return CreateCallButton.isDisplayed();	
	}
	
	public void userCall() {
		CreateCallButton.click();
	}
	
	public void clickButton() {
		DirectionDropdown.click();
	}
	

}
