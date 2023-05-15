package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.*;

public class Profilepage {
	
	public WebDriver ldriver;
	
	public Profilepage(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this);
	}
	
	
	By profilemenu = By.xpath("//a[@aria-label=\"Shubh Kulkarni\"]");
	
	//upload photo by camera icon
	By cameraicon = By.xpath("//i[@class=\"x1b0d499 xmgbrsx\"]");

	//upload photo by Add photo button
	
	By addphoto = By.xpath("//div[@class=\"xb57i2i x1q594ok x5lxg6s x6ikm8r x1ja2u2z x1pq812k"
			+ " x1rohswg xfk6m8 x1yqm8si xjx87ck"
			+ " xx8ngbg xwo3gff x1n2onr6 x1oyok0e x1odjw0f x1e4zzel x1qjc9v5 x9f619 "
			+ "x78zum5 xdt5ytf xkhd6sd x4uap5 x1ten1a2 xz7cn9q x168biu4\"]/div/div[1]/div[1]");
	
	
	
	//Action methods
	
	
	public String get_title() {
		
		return ldriver.getTitle();
	}
	
	
	public void click_profile_menu() {
		
		ldriver.findElement(profilemenu).click();
	}
	
	public String get_title_profilepage() {
		
		return ldriver.getTitle();
	}
	
    public void click_camera_icon() {
		
		ldriver.findElement(cameraicon).click();
	}
    
    public void click_addphto() {
		
		ldriver.findElement(addphoto).click();
	}

    
    
}
