package com.synapsys.lmt.pages;


import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTRolePermissionSet extends SeleniumBase
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnRolePermissionSet = By.xpath(".//*[@id='TreeScreent9']");
	public static By cmbRole = By.xpath(".//*[@id='ContentPlaceHolder1_ddlrole']");
	
	public static By chkAuthorize = By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_chckGrantPermission_0']");
	public static By chkCreate = By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_chckGrantPermission_1']");
	public static By chkEdit = By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_chckGrantPermission_2']");
	public static By chkInactivate = By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_chckGrantPermission_3']");
	public static By chkReactivate= By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_chckGrantPermission_4']");
	public static By chkView = By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_chckGrantPermission_5']");
		
	public static By btnSave = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By lblSuccess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification_lblsuccess']");
	
	public void click_Basic()
	{
		click(btnAdministration);
		click(btnRolePermissionSet);
	}
	
	public void selectRole(String role)
	{
		try
		{
			select(cmbRole, role);
			Thread.sleep(3000);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public void setPermissions()throws Exception
	{
		Thread.sleep(8000);
		//check authorise
		click(chkAuthorize);
		click(chkAuthorize);
		click(chkAuthorize);
		click(chkCreate);
		click(chkEdit);
		click(chkInactivate);
		click(chkReactivate);
		click(chkView);
		
		click(btnSave);
	}
	
	public void validatePermissionSet(String successMessage)throws Exception
	{
		if(readAndCompare(lblSuccess, successMessage))
			return;
		else
			throw new Exception();
			
	}
	
}
