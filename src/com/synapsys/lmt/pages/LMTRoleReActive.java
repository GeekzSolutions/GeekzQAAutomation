package com.synapsys.lmt.pages;


import javax.swing.JOptionPane;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;


public class LMTRoleReActive extends SeleniumBase 
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnRoleReActive = By.xpath(".//*[@id='TreeScreent6']");
	public static By cmbBusEntity = By.xpath(".//*[@id='ContentPlaceHolder1_ddlBusinessEntity']");
	public static By lblPages = By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles_lblTotalPage']");
	public static By btnNextPage = By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles_imgPageNext']");
	public static By txtRoleName = By.xpath(".//*[@id='ContentPlaceHolder1_txtRoleName']");
	public static By btnReActivate = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By btnBack = By.xpath(".//*[@id='ContentPlaceHolder1_btnClear']");
	public static By lblReActiveSuccess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	public static By grdRoleName;
	public static By grdStatus;
	public static By btnReActive;
	
	String first_part = ".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr[";
	String second_part = "]/td[";
	String third_part = "]";
	
	String reactivePart1 = ".//*[@id='ContentPlaceHolder1_dtgRoles_lbnEdit_";      
	String reactivePart2 = "']";
	
	public static int count;
	public static int loop = 0;
	public static int Row_count;
	
	public void clickBasic()
	{
		click(btnAdministration);
		click(btnRoleReActive);
	}
	
	public void selectBusinessEntity(String entity)
	{
		try
		{
			select(cmbBusEntity, entity);
			Thread.sleep(6000);
			Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size();
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void Calc_Label_Of_Value()
	{
		 String lblOfValue = driver.findElement(lblPages).getText();
		 System.out.println("############### size " + lblOfValue + "##################" );
		 String[] splited = lblOfValue.split(" ");
		 String maxGridSize = splited[1];
		 System.out.println("############### size " + maxGridSize + "##################" );
		 count = Integer.parseInt(maxGridSize);	
	}
	
	public void Get_Values_According_To_Role_Name(String rolename, String status) throws InterruptedException
	{	
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		boolean role_name_find = false;
		
		for (int i=2; i<=Row_count; i++)
		{
			for(int j=1; j<=1; j++)
			{
				//Thread.sleep(1000);
				String xpath_for_Role_Name = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_Role_Name + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_Role_Name)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(rolename)){
					
					System.out.println(" ################### username equals  #################");
					grdRoleName = By.xpath(xpath_for_Role_Name);
					
					String Xpath_for_Status = first_part+i+second_part+2+third_part;
					grdStatus =By.xpath(Xpath_for_Status);
					
					String xpath_for_ReActive_Button = reactivePart1+(i-2)+reactivePart2;
					
					if(readAndCompare(grdRoleName, rolename) && readAndCompare(grdStatus, status))
					{	
						btnReActive = By.xpath(xpath_for_ReActive_Button);
						click(btnReActive);
						
					}
					
					role_name_find = true;											
					return;
				}	
			}
		}
				
		if((!role_name_find)&&(loop < count))
		{
			click(btnNextPage);
			loop++;
			System.out.println("#### Move to next Grid ######");
			Get_Values_According_To_Role_Name(rolename, status);
		}	
	}
	
	public void SinglePageSearch(String rolename, String status)
	{		
		try
		{
		for (int i=2; i<=Row_count; i++)
		{
				//Thread.sleep(1000);
				String xpath_for_Role_Name = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_Role_Name + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_Role_Name)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(rolename))
				{
					
					System.out.println(" ################### username equals  #################");
					grdRoleName = By.xpath(xpath_for_Role_Name);
					
					String Xpath_for_Status = first_part+i+second_part+2+third_part;
					grdStatus =By.xpath(Xpath_for_Status);
					
					String xpath_for_ReActive_Button = reactivePart1+(i-2)+reactivePart2;
					
					if(readAndCompare(grdRoleName, rolename) && readAndCompare(grdStatus, status))
					{	
						btnReActive = By.xpath(xpath_for_ReActive_Button);
						click(btnReActive);
						
					}
															
					return;
				}	
		}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void Search_Grid_for_Role_Name(String rolename, String status) throws Exception
	{
		if(Row_count<11)
		{
			SinglePageSearch(rolename, status);
		}
		else if(Row_count>10)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_Role_Name(rolename, status);
		}
	}
	
	public void reactivateRole(String roleName) throws Exception
	{
		if(readAndCompareByValue(txtRoleName, roleName))
		{
			click(btnReActivate);			
		}
		else
			throw new Exception();
	}
	
	public void verifyReactivate(String lblReActiveSuccessMessage)throws Exception
	{
		if(readAndCompare(lblReActiveSuccess, lblReActiveSuccessMessage))
		{
			click(btnBack);
			return;
		}
		else
			throw new Exception();
	}
	
}
