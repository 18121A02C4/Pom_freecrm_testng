package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	
//	@FindBy(xpath="//a[contains(text(),'Chloe Decker')]/parent::td/preceding-sibling::td")
//	WebElement ch;
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactsLable() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"
	+name+
	"')]/parent::td/preceding-sibling::td")).click();
	}
	
	
	

}
