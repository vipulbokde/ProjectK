package com.projectk.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.projectk.qa.base.TestBase;

public class TextBox extends TestBase {
	
	
	@FindBy(xpath = "//span[text() = 'Text Box']")
	WebElement textboxoption;

	@FindBy(id = "userName")
	WebElement userNameBox;

	@FindBy(id = "userEmail")
	WebElement emailBox;

	@FindBy(id = "currentAddress")
	WebElement addressBox;
	
	@FindBy(id = "permanentAddress")
	WebElement permAddressBox;
	
	@FindBy(id = "submit")
	WebElement submitBtn;
	
	
	public TextBox() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateTextBoxBtn() throws InterruptedException {
		textboxoption.click();
		Thread.sleep(2000);
	}

	public void validateuserNameBox() {
		userNameBox.sendKeys(prop.getProperty("username"));
	}
	
	public void validateemailBox() {
		emailBox.sendKeys(prop.getProperty("email"));
	}
	
	public void validateaddressBox() {
		addressBox.sendKeys(prop.getProperty("currentadress"));	
	}
	public void validatepermAddressBox() throws InterruptedException {
		permAddressBox.sendKeys(prop.getProperty("permaddress"));
		Thread.sleep(2000);
    }
	
	/*
	 * public CheckBox validatesubmitBtn() throws InterruptedException {
	 * submitBtn.click(); Thread.sleep(2000); return new CheckBox(); }
	 */
	
	public void validatesubmitBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
    }
	
	
	public void validateMultipleTestData(String Uname, String email, String cadress, String paddress) throws InterruptedException {
		textboxoption.click();
		userNameBox.sendKeys(Uname);
		emailBox.sendKeys(email);
		addressBox.sendKeys(cadress);
		permAddressBox.sendKeys(paddress);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
	}
}
