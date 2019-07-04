package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	
	WebDriver driver;
	
	@FindBy (how = How.XPATH, using="//*[@id=\"navbar\"]/div/div[2]/div/ul/li[4]/ul/li[9]/a")
	WebElement logoutButton;
	
	
	public Logout (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Login userLogout() {
		logoutButton.click();
		return new Login(driver);
	}

}
