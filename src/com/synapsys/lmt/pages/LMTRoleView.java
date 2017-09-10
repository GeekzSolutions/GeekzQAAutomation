package com.synapsys.lmt.pages;


import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTRoleView extends SeleniumBase {

	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnRoleView = By.xpath(".//*[@id='TreeScreent1']");
	public static By cmbBusEntity = By.xpath(".//*[@id='ContentPlaceHolder1_ddlBusinessEntity']");
	public static By lblPages = By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles_lblTotalPage']");
	public static By grdRoleName;
	public static By grdStatus;
	public static By btnNextPage = By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles_imgPageNext']");
	public static By txtRoleName = By.xpath(".//*[@id='ContentPlaceHolder1_txtRoleName']"); //.//*[@id='ContentPlaceHolder1_txtRoleName']
	public static By btnBack = By.xpath(".//*[@id='ContentPlaceHolder1_btnClear']");
	public static By btnView;
	
	String first_part = ".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr[";
	String second_part = "]/td[";
	String third_part = "]";
	
	String viewPart1 = ".//*[@id='ContentPlaceHolder1_dtgRoles_lbnEdit_"; //.//*[@id='ContentPlaceHolder1_dtgRoles_lbnEdit_']
	String viewPart2 = "']";	
	// .//*[@id='ContentPlaceHolder1_dtgRoles_lbnEdit_1']
	
	public static int count;
	public static int loop = 0;
	int Row_count; 
	
	public void clickBasic()
	{
		click(btnAdministration);
		click(btnRoleView);
	}
	
	public void selectBusinessEntity(String entity)
	{
		try
		{
			select(cmbBusEntity, entity);
			Thread.sleep(1000);
			Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void Calc_Label_Of_Value()
	{
		 String lblOfValue = driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles_lblTotalPage']")).getText();
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
		
		for (int i=2; i<=Row_count; i++){
			for(int j=1; j<=1; j++){
				
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
					
					String xpath_for_View_Button = viewPart1+(i-2)+viewPart2;
					
					if(readAndCompare(grdRoleName, rolename) && readAndCompare(grdStatus, status))
					{	
						btnView = By.xpath(xpath_for_View_Button);
						click(btnView);
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
	
	public void Single_Page_Search(String rolename, String status)
	{
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		
		for (int i=2; i<=Row_count; i++)
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
					
					String xpath_for_View_Button = viewPart1+(i-1)+viewPart2;
					
					if(readAndCompare(grdRoleName, rolename) && readAndCompare(grdStatus, status))
					{	
						btnView = By.xpath(xpath_for_View_Button);
						click(btnView);
					}
														
					return;
				}	
			}
	}
	
	public void Search_Grid_for_Parameter_Name(String rolename, String status) throws InterruptedException
	{
		if(Row_count<30)
		{
			Single_Page_Search(rolename, status);
		}
		else if(Row_count>30)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_Role_Name(rolename, status);
		}
	}
	
	public void Verify_Role_View_in_Grid(String roleName) throws Exception
	{
		if(readAndCompareByValue(txtRoleName, roleName))
		{
			click(btnBack);
			return;
		}
		else
			throw new Exception();
	}
	
}
