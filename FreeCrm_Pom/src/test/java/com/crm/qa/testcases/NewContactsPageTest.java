package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class NewContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	NewContactsPage newContactsPage;
	String sheetName = "NewContacts";

	public NewContactsPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil=new TestUtil();
//		contactsPage=new ContactsPage();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		newContactsPage=homePage.clickOnNewContactLink();

	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company)  {
		newContactsPage.createNewContact(title, firstName, lastName, company);
		

//		newContactsPage.createNewContact("Mr.","Tom","Hanks","Disney");
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
