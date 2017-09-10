package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTRolePermissionView extends SeleniumBase
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnRolePermissionView = By.xpath(".//*[@id='TreeScreent8']");
	public static By cmbRole = By.xpath(".//*[@id='ContentPlaceHolder1_ddlrole']");
	
	public static By chkAuthorize = By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_CheckBox1_0']");
	public static By chkCreate = By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_CheckBox1_1']");
	public static By chkEdit = By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_CheckBox1_2']");
	public static By chkInactivate = By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_CheckBox1_3']");
	public static By chkReactivate= By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_CheckBox1_4']");
	public static By chkView = By.xpath(".//*[@id='ContentPlaceHolder1_grdMenus_grdScreens_0_grdScreenFunctions_0_grdFunctions_0_CheckBox1_5']");
		
	public void click_Basic()
	{
		click(btnAdministration);
		click(btnRolePermissionView);
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
	
	public void validatePermissions()throws Exception
	{
		final Boolean authorize = driver.findElement(chkAuthorize).getAttribute("checked").equals("true");
		System.out.println("---------- Authorize checkbox is " + authorize.toString() + "---------");
		final Boolean create = driver.findElement(chkCreate).getAttribute("checked").equals("true");
		final Boolean edit = driver.findElement(chkEdit).getAttribute("checked").equals("true");
		final Boolean inactive = driver.findElement(chkInactivate).getAttribute("checked").equals("true");
		final Boolean reactive = driver.findElement(chkReactivate).getAttribute("checked").equals("true");
		final Boolean view = driver.findElement(chkView).getAttribute("checked").equals("true");
		
		if(authorize && create && edit && inactive && reactive && view)
		{
			return;
		}
		else
		{
			throw new Exception();
		}
	}
	
	
	
	
}
