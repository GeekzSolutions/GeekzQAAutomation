package com.synapsys.lmt.pages;

import com.synapsys.lmt.lib.SeleniumBase;

import org.openqa.selenium.By;

public class LMTCommonMasterBankCreation extends SeleniumBase
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnBank_Branches = By.xpath(".//*[@id='TreeScreent25']");
	public static By txtCode = By.xpath(".//*[@id='ContentPlaceHolder1_txtCode']");
	public static By txtName = By.xpath(".//*[@id='ContentPlaceHolder1_txtName']");
	public static By txtAddress = By.xpath(".//*[@id='ContentPlaceHolder1_txtAddress']");
	public static By txtContactNo = By.xpath(".//*[@id='ContentPlaceHolder1_txtContactNumber']");
	public static By chkActive = By.xpath(".//*[@id='ContentPlaceHolder1_chbActive']");
	public static By btnSave = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By btnNew = By.xpath(".//*[@id='ContentPlaceHolder1_btnNew']");
	public static By lblBankCreateSuccessMessage = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	public static By lblWarningMark = By.xpath(".//*[@id='ContentPlaceHolder1_regValName']/img");
	
	
	public void createBank(String code, String name, String address, String contactNo)throws Exception
	{
		try
		{
			click(btnAdministration);
			click(btnBank_Branches);
			clearAndType(txtCode, code);
			clearAndType(txtName, name);
			clearAndType(txtAddress, address);
			clearAndType(txtContactNo, contactNo);
			click(chkActive);
			click(btnSave);
		}
		catch(Exception ex)
		{
			throw new Exception();
		}
	}
	
	public void isBankCreated(String bankCreateSuccess) throws Exception
	{
		if(readAndCompare(lblBankCreateSuccessMessage, bankCreateSuccess))
			return;
			else  
				throw new Exception();
	}
	
	public void duplicateBankCodeCreated(String code, String name, String address, String contactNo) throws Exception
	{
		try
		{
			clearAndType(txtCode, code);
			clearAndType(txtName, name);
			clearAndType(txtAddress, address);
			clearAndType(txtContactNo, contactNo);
			click(chkActive);
			click(btnSave);
		}
		catch(Exception ex)
		{
			throw new Exception();
		}
	}
	
	public void isBankCodeDuplicated(String BankCodeDuplicated)
	{
		isTextPresent(BankCodeDuplicated);
	}
	
	public void isBankCreatewithSpecialCharacters()
	{
		isElementPresent(lblWarningMark);
	}

}
