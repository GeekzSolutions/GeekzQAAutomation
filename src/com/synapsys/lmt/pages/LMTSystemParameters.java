package com.synapsys.lmt.pages;

import com.synapsys.lmt.lib.SeleniumBase;
import org.openqa.selenium.By;


public class LMTSystemParameters extends SeleniumBase
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnSystemParameter = By.xpath(".//*[@id='TreeScreent28']");
	public static By txtHeaderName = By.xpath(".//*[@id='ContentPlaceHolder1_txtParameterHeader']");
	public static By txtDetail = By.xpath(".//*[@id='ContentPlaceHolder1_txtdetail']");
	public static By btnSave = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By btnCancel = By.xpath(".//*[@id='ContentPlaceHolder1_btnCancel']");
	public static By lblAddSuccessMessage = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	public static By lblWarningMark = By.xpath(".//*[@id='ContentPlaceHolder1_RrgRoleName']/img");
	
	
	public void SystemParameter_Created(String HeaderDetail, String Detail)
	{
		try
		{
			click(btnAdministration);
			click(btnSystemParameter);
			clearAndType(txtHeaderName, HeaderDetail);
			clearAndType(txtDetail, Detail);
			click(btnSave);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void Is_Parameter_Created(String AddSuccessMessage) throws Exception
	{
		if(readAndCompare(lblAddSuccessMessage, AddSuccessMessage))
			return;
		else
			throw new Exception();
	}
	
	public void Duplicate_Parameter_Created(String HeaderDetail, String Detail)
	{
		try
		{
			clearAndType(txtHeaderName, HeaderDetail);
			clearAndType(txtDetail, Detail);
			click(btnSave);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void Is_Duplicate_Parameter_Created(String ParameterDuplicateMessage) throws Exception
	{
		isTextPresent(ParameterDuplicateMessage);
	}
	
	public void Is_Parameter_Creates_with_Special_Characters()
	{
		isElementPresent(lblWarningMark);
	}
	
	public void Parameter_Save_Cancel(String HeaderDetail, String Detail)
	{
		clearAndType(txtHeaderName, HeaderDetail);
		clearAndType(txtDetail, Detail);
		click(btnCancel);
	}
	
	public void Is_Parameter_Canceled()throws Exception
	{
		if(readAndCompare(txtHeaderName, "") && readAndCompare(txtDetail, ""))
		{
			return;
		}
		else
			throw new Exception();
	}
}
