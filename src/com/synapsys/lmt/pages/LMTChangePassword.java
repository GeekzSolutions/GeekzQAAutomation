package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;


public class LMTChangePassword extends SeleniumBase{
	
	public static By btnAdministartion = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnChangePassword = By.xpath(".//*[@id='TreeScreent21']");
	public static By lblUserName = By.xpath(".//*[@id='ContentPlaceHolder1_lblUserName']");
	public static By textOldPassword = By.xpath(".//*[@id='ContentPlaceHolder1_txtOldPassword']");
	public static By textNewPassword = By.xpath(".//*[@id='ContentPlaceHolder1_txtNewPaswd']");
	public static By textConfirmPassword = By.xpath(".//*[@id='ContentPlaceHolder1_txtConPassword']");
	public static By btnsave = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	
	
	public void UserName_Availble(String username) throws Exception{
		click(btnAdministartion);
		click(btnChangePassword);
		//Thread.sleep(2000);
		if(readAndCompareByValue(lblUserName, username))
		return;	
		else
			throw new Exception();	
	}
	
	public void Change_Password(String OldPassword,String NewPassword, String ConfirmPassword){
		
		clearAndType(textOldPassword, OldPassword);
		clearAndType(textNewPassword, NewPassword);
		clearAndType(textConfirmPassword, ConfirmPassword);
		click(btnsave);
	}
	
	

	public By lblChangePassword = By.xpath(".//*[@id='ContentPlaceHolder1_lblMsg']");
	public By btnOk = By.xpath(".//*[@id='ContentPlaceHolder1_btnMsgYes']");
	
	public void changepassword_Message(String passwordChangeSucessMessage)throws Exception{
		if(readAndCompare(lblChangePassword, passwordChangeSucessMessage)){
			click(btnOk);	
			return;
		}
		else
			throw new Exception();
		
	}


}
