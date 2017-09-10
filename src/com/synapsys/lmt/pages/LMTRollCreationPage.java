package com.synapsys.lmt.pages;

import org.openqa.selenium.By;
import com.synapsys.lmt.lib.SeleniumBase;

public class LMTRollCreationPage extends SeleniumBase {
	
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnRoleCreation = By.xpath(".//*[@id='TreeScreent2']");
	public static By cmbBusinessEntity = By.xpath(".//*[@id='ContentPlaceHolder1_ddlBusinessEntity']");
	public static By textRoleName = By.xpath(".//*[@id='ContentPlaceHolder1_txtRoleName']");
	public static By btnsave = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By lblwaraningMark = By.xpath(".//*[@id='ContentPlaceHolder1_RrgRoleName']/img");
	public static By lblRollCreationSucess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	
	
	//.//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']
	//Role creation
	public void Role_created(String BusinesEntity, String RoleName){
		try{
		click(btnAdministration);
		click(btnRoleCreation);
		select(cmbBusinessEntity, BusinesEntity);
		clearAndType(textRoleName, RoleName);
		click(btnsave);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
	}
	
	public void Is_Role_Created(String RolesucessMessage)throws Exception{
		//isTextPresent(RolesucessMessage);
		if(readAndCompare(lblRollCreationSucess, RolesucessMessage))
		return;
		else  
			throw new Exception();
	}
	
	
	//Duplicate the roll creation	
	public void Duplicate_Role_created(String BusinesEntity, String RoleName){
		try{
		select(cmbBusinessEntity, BusinesEntity);
		clearAndType(textRoleName, RoleName);
		click(btnsave);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
	}
	
	public void Is_Role_Duplicated(String RoleDuplicateMessage){
		isTextPresent(RoleDuplicateMessage);
	}
	
	
	//Role Creation with special characters
	public void Is_Role_Creates_With_Special_Characters(){
		isElementPresent(lblwaraningMark);
	}
	
	
}
