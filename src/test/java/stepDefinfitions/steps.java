package stepDefinfitions;

import pageObjects.Loginpage;

import pageObjects.Profilepage;
import pageObjects.Searchfriend;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class steps extends Base {
	
	public WebDriver driver;
	public Loginpage lp;
	
	@Before
	public void setup() throws IOException {
		
		//reading properties
		
		configprop = new Properties();
		
		FileInputStream fileconfigprop = new FileInputStream("config.properties");
		
		configprop.load(fileconfigprop);
		
	logger = (org.apache.logging.log4j.Logger) Logger.getLogger("nopcommerce");  //added logger
		
		PropertyConfigurator.configure("log4j.properties");
		
		 String br = configprop.getProperty("browser");
		 
		 if(br.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
		driver = new ChromeDriver();
	 }
		
		 if(br.equals("firefox")) {
				
				System.setProperty("webdriver.chrome.driver", configprop.getProperty("firefoxpath"));
				driver = new FirefoxDriver();
	   }
		
		logger.info("****************** launching browser ********************************");
		
	}
	
	
	@Given("user launch chrome browser")	
	public void	user_launch_chrome_browser() {
		
		lp = new Loginpage(driver);
	}

	
	@When("user opens url {string}")
	public void user_open_url(String url){
		
		logger.info("****************** opening url of application ********************************");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	@When("user enter email {string} and password {string}")
    public void user_enter_email(String email, String Password){
	
		logger.info("****************** providing logging details ********************************");
	
		lp.setEmail(email);
		lp.setPassword(Password);
	}
	
	
	
    @When("user click login")
    public void user_click_login() {
    	
    	logger.info("****************** started loggin ********************************");
    	lp.clicklogin();
    }
	
	
    @Then("page title ")
    public void page_title(String title) {
    	
      if(driver.getPageSource().contains("The email address you entered isn't connected to an account. ")){
    	  
    	  logger.info("******************login passed ********************************");
    	  driver.close();
    	  Assert.assertTrue(false);
      }
      
      else {
    	   
    	  logger.info("****************** login failed ********************************");
    	  Assert.assertEquals(title, driver.getTitle());
      }
    }
    
    @When("user click on logout")
    public void user_click_logout() throws InterruptedException {
    	
    	logger.info("****************** click on logout ********************************");
    	lp.clicklogout();	
    	Thread.sleep(3000);
    }
	
    
    @Then("close broswer")
    public void close_browser() {
    	
    	driver.close();
    }

    
    //profile add photo feature step defintion
    
    @Then("user can view title page")
    public void get_title() {
    	
    	propage = new Profilepage(driver);
    	
        Assert.assertEquals("(2) Facebook", propage.get_title());
    }
    
    
    @When("user click profilemenu")
    public void user_click_profilemenu() throws InterruptedException {
    	
    	propage.click_profile_menu();
    	Thread.sleep(3000);
    }
    
    
    public void profilepage_title() throws InterruptedException {
    	
    	propage.get_title_profilepage();
    	Thread.sleep(3000);
    	
    	 Assert.assertEquals("(2) Shubh Kulkarni | Facebook", propage.get_title_profilepage());
    }
    
    
    @When("user click camraicon")
    public void user_click_cameraicon() throws InterruptedException {
    	
    	propage.click_camera_icon();
    	Thread.sleep(3000);
    }
    
    @When("user click addphoto")
    public void user_click_addphoto() throws InterruptedException {
    	
    	logger.info("****************** adding new photo ********************************");
    	propage.click_addphto();
    	Thread.sleep(3000);
    }
    
    //profile search friends 
    @When("user click friends")
    public void user_click_friend() {
    	
    	searchfrnd = new Searchfriend(driver);
    	searchfrnd.click_friends();
    }
    
    @When("user click frndrequest")
    public void user_click_frndrequest() {
    	searchfrnd.click_friendrequest();
    }
    
    @When("user click viewrequest")
    public void user_click_viewsentrequest() {
    	
    	searchfrnd.click_viewsentrequest();
    }
    
    @Then("get title")
    public void view_message(String title) {
    	if(driver.getPageSource().contains("The email address you entered isn't connected to an account. ")){
      	  
      	  driver.close();
      	  Assert.assertTrue(false);
        }
        
        else {
      	  
      	  Assert.assertEquals(title, driver.getTitle());
        }
    }
}
