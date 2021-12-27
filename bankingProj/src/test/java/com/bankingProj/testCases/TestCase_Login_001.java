package com.bankingProj.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingProj.pageObjects.LoginPage;

public class TestCase_Login_001 extends BaseClass{

	@Test
	public void LoginTest() {
		
		test=extentReport.createTest("Loging Test");
		
		driver.get(baseURL);
		LoginPage pg=new LoginPage(driver);
		pg.setUsername(username);
		pg.setPassword(password);
		pg.clickBtn();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	
	@Test
	public void testTitle() {
		test=extentReport.createTest("title Test");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePag")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testaddCustomer() {
		test=extentReport.createTest("addCustomer Module");
		LoginPage pg=new LoginPage(driver);
		pg.clickcBtn();
		pg.setCustomername("Nilesh");
		
	}
}
