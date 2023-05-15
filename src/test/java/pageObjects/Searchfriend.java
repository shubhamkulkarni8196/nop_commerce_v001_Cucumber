package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class Searchfriend {
	
	public WebDriver ldriver;
	
	WaitHelper waithelp ; 
	
	public Searchfriend(WebDriver rdriver){
		
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this);
		
		waithelp = new WaitHelper(ldriver);
	}
	
	
    @FindBy(how=How.XPATH, using= "//a[@href=\"/friends/\"]")
    @CacheLookup
	WebElement friends;
	
    @FindBy(how=How.XPATH, using="//a[@href=\"/friends/requests/\"]")
    @CacheLookup
    WebElement friendrequest;
    
    @FindBy(how=How.XPATH, using ="//span[text()='View sent requests']")
    @CacheLookup
    WebElement viewsentrequest;
    
    
    public void click_friends() {
    	waithelp.wait_forelement(friends, 30);
    	friends.click();
    }
    
    public void click_friendrequest() {
    	waithelp.wait_forelement(friendrequest, 40);
    	friendrequest.click();
    }
    
    
    public void click_viewsentrequest() {
    	waithelp.wait_forelement(viewsentrequest, 60);
    	viewsentrequest.click();
    }
    
    
}

