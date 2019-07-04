package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	
	@FindBy (how = How.XPATH, using="//span[contains(.,'Home')]")
	WebElement HomeLink;
	@FindBy (xpath="//span[text()=\"Accounts\"]")
	WebElement AccountLink;
	@FindBy (how = How.XPATH, using="//span[text()=\"Contacts\"]")
	WebElement ContactLink;
	@FindBy (how = How.XPATH, using="//span[text()=\"Leads\"]")
	WebElement LeadLink;
	@FindBy (how = How.XPATH, using="//span[text()=\"Opportunities\"]")
	WebElement OpportunityLink;
	@FindBy (how = How.XPATH, using="//span[text()=\"Cases\"]")
	WebElement CaseLink;
	@FindBy (how = How.XPATH, using="//span[text()=\"Meetings\"]")
	WebElement MeetingLink;
	@FindBy (how = How.XPATH, using="//span[text()=\"Calls\"]")
	WebElement CallLink;
	@FindBy (how = How.XPATH, using="//span[text()=\"Tasks\"]")
	WebElement TaskLink;
	@FindBy (how = How.XPATH, using="//*[@id=\"navbar\"]/div/div[2]/div/ul/li[4]")
	WebElement Option;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean returnLink() {
		return HomeLink.isDisplayed();
	}
	
	public AccountsMgmt clickAccounts() {
		AccountLink.click();
		return new AccountsMgmt(driver);
	}

	public ContactsMgmt clickContacts() {
		ContactLink.click();
		return new ContactsMgmt(driver);
	}

	public LeadsMgmt clickLeads() {
		LeadLink.click();
		return new LeadsMgmt(driver);
	}

	public OpportunitiesMgmt clickOpportunities() {
		OpportunityLink.click();
		return new OpportunitiesMgmt(driver);
	}

	public CasesMgmt clickCases() {
		CaseLink.click();
		return new CasesMgmt(driver);
	}

	public MeetingsMgmt clickMeetings() {
		MeetingLink.click();
		return new MeetingsMgmt(driver);
	}

	public CallsMgmt clickCalls() {
		CallLink.click();
		return new CallsMgmt(driver);
	}

	public TasksMgmt clickTasks() {
		TaskLink.click();
		return new TasksMgmt(driver);
	}
	
	public Logout clickLogout() {
		Option.click();
		return new Logout(driver);
	}

}
