package com.projectk.qa.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.projectk.qa.base.TestBase;
import com.projectk.qa.pages.TextBox;
import com.projectk.qa.util.TestUtil;

public class TextBoxTest extends TestBase {

	TextBox textBox;
	String sheetName = "Testdata";
	
	public TextBoxTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		textBox = new TextBox();
	}
	
	@Test(priority = 1) // (priority = 1 ,groups= {""})
	public void textBoxButtonTest() throws InterruptedException {
		textBox.validateTextBoxBtn();
		textBox.validateuserNameBox();
		textBox.validateemailBox();
		textBox.validateaddressBox();
		textBox.validatepermAddressBox();
		textBox.validatesubmitBtn();
	}
	
	@DataProvider
	public Object[][] getprojectKTestData () {
		Object data [][] =TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 2 , dataProvider = "getprojectKTestData")
	public void dataDriventextBoxButtonTest(String Uname, String email, String cadress, String padress) throws InterruptedException {
	textBox.validateMultipleTestData(Uname, email, cadress, padress);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
