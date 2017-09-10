package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTRolePermissionAuthorize extends SeleniumBase
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnRolePAuthorize = By.xpath(".//*[@id='TreeScreent10']");
	public static By cmbBusEntity = By.xpath(".//*[@id='ContentPlaceHolder1_ddlrole']");
	public static By btnAuthorize = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By lblAuthorizeSuccess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification_lblsuccess']");
	
	
	
	public void authorizeRoleP()
	{
		click(btnAdministration);
		click(btnRolePAuthorize);
	}
	
	public void selectBusinessEntity(String entity)
	{
		try
		{
			select(cmbBusEntity, entity);
			Thread.sleep(6000);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void isRoleAuthorized(String authorizeSuccess) throws Exception
	{
		click(btnAuthorize);
		if(readAndCompare(lblAuthorizeSuccess, authorizeSuccess))
		{
			return;
		}
		else
			throw new Exception();
	}

}
