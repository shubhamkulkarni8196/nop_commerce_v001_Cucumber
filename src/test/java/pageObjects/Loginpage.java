package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	public WebDriver ldriver;
	
	public Loginpage (WebDriver rdriver) {
		
		ldriver = rdriver ;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="email")
	@CacheLookup
	WebElement email;
	
	
	@FindBy(id="pass")
	@CacheLookup
	WebElement password;
	
	
	@FindBy(name="login")
	@CacheLookup
	WebElement btnlogin;
	
	
	@FindBy(xpath="//*[local-name()='svg'][@class='x1lliihq x1k90msu x2h7rmj x1qfuztq x198g3q0 x1kpxq89 xsmyaan']")
    @CacheLookup
	WebElement profilebtn;
	//@FindBy(xpath="//span[text()='Friends']")
	//@CacheLookup
	//WebElement btnfriends;
	
	
	@FindBy(xpath="//span[text()='Log Out']")
	@CacheLookup
	WebElement Logout;
	
	public void setEmail (String emailname) {
		
		email.clear();
		email.sendKeys(emailname);
	}

     
	public void setPassword (String passwordname) {
		
		password.clear();
		password.sendKeys(passwordname);
	}
	
	
	public void clicklogin() {
		
		btnlogin.click();
	}
	
	
	public void clicklogout() {
		
		Logout.click();
	}
}
