package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;


public class LMTSDesignationMaintain extends SeleniumBase
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnDesignation = By.xpath(".//*[@id='TreeScreent12']");
	public static By txtDesignation = By.xpath(".//*[@id='ContentPlaceHolder1_txtDesignation']");
	public static By txtDescription = By.xpath(".//*[@id='ContentPlaceHolder1_txtDescription']");
	public static By chkActive = By.xpath(".//*[@id='ContentPlaceHolder1_chkActive']");
	public static By btnSave = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By btnClear = By.xpath(".//*[@id='ContentPlaceHolder1_btnClear']");
	public static By lblDeisgDuplicateMessage = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblerror']");
	public static By lblWarningMark = By.xpath(".//*[@id='ContentPlaceHolder1_RrgDesigantion']/img");
	public static By lblDesigSuccessMessage = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	
	public void Designation_created(String designation, String description)
	{
		try
		{
			click(btnAdministration);
			click(btnDesignation);
			clearAndType(txtDesignation, designation);
			clearAndType(txtDescription, description);
			click(chkActive);
			click(btnSave);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void Is_Designation_Created(String DesignationsucessMessage)throws Exception{
		//isTextPresent(RolesucessMessage);
		if(readAndCompare(lblDesigSuccessMessage, DesignationsucessMessage))
		return;
		else  
			throw new Exception();
	}
	
	
	//Duplicate the roll creation	
	public void Duplicate_Designation_created(String designation, String description){
		try
		{
			clearAndType(txtDesignation, designation);
			clearAndType(txtDescription, description);
			click(chkActive);
			click(btnSave);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
	}
	
	public void Is_Designation_Duplicated(String DesigDuplicateMessage){
		isTextPresent(DesigDuplicateMessage);
	}
	
	
	//Role Creation with special characters
	public void Is_Designation_Creates_With_Special_Characters(){
		isElementPresent(lblWarningMark);
	}
	
	public void Validate_Clear_Button(String designation, String description)
	{
		try
		{
			clearAndType(txtDesignation, designation);
			clearAndType(txtDescription, description);
			click(chkActive);
			click(btnClear);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void Is_Textboxes_Cleared() throws Exception
	{
		if(readAndCompare(txtDesignation, "") && readAndCompare(txtDescription, ""))
		{
			return;
		}
		else
			throw new Exception();
		
	}

}
