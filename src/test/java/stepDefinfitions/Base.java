package stepDefinfitions;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.Loginpage;
import pageObjects.Profilepage;
import pageObjects.Searchfriend;

public class Base {

	public WebDriver driver;
	public Loginpage lp;
	public Profilepage propage;
	public Searchfriend searchfrnd;
	public static Logger logger;
	public static Properties configprop;
	
}
