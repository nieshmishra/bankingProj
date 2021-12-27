package com.bankingProj.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtuserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement customerBtn;
	
	@FindBy(xpath="//input[@name='name']")
	@CacheLookup
	WebElement cName;
	
	public void setUsername(String uname) {
		txtuserName.sendKeys(uname);
	}
	

	public void setPassword(String pass) {
		txtpassword.sendKeys(pass);
	}
	
	public void setCustomername(String cname) {
		cName.sendKeys(cname);
	}

	public void clickBtn() {
		btnLogin.click();
	}
	public void clickcBtn() {
		customerBtn.click();
	}
	
}
