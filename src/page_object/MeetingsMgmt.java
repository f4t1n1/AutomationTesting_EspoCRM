package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MeetingsMgmt {
	
	WebDriver driver;
	String expected = null;
	String actual = null;
	
	@FindBy (how = How.XPATH, using="//a[contains(text(),\"Create Meeting\")]")
	WebElement CreateMeetingButton;
	
	public MeetingsMgmt (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getButton() {
		return CreateMeetingButton.isDisplayed();	
	}
	
	public void userMeeting() {
		CreateMeetingButton.click();
	}


}
