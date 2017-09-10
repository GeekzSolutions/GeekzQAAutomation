package com.synapsys.lmt.pages;

import com.synapsys.lmt.lib.SeleniumBase;

import org.openqa.selenium.By;

public class LMTRoleEdit extends SeleniumBase 
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnRoleEdit = By.xpath(".//*[@id='TreeScreent4']");
	public static By cmbBusinessEntity = By.xpath(".//*[@id='ContentPlaceHolder1_ddlBusinessEntity']");
	public static By lblPages = By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles_lblTotalPage']");
	public static By btnNextPage = By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles_imgPageNext']");
	public static By btnUpdate = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By btnBack = By.xpath(".//*[@id='ContentPlaceHolder1_btnClear']");
	public static By txtRoleName = By.xpath(".//*[@id='ContentPlaceHolder1_txtRoleName']");
	public static By lblRoleEditSuccess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	public static By lblWarningMark = By.xpath(".//*[@id='ContentPlaceHolder1_RrgRoleName']/img");
	public static By btnEdit;
	public static By grdRoleName;
	public static By grdStatus;
	
	public static By btnRoleAuthorize = By.xpath(".//*[@id='TreeScreent3']");
	
	String first_part = ".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr[";
	String second_part = "]/td[";
	String third_part = "]";
	
	String editPart1 = ".//*[@id='ContentPlaceHolder1_dtgRoles_lbnEdit_"; //.//*[@id='ContentPlaceHolder1_dtgRoles_lbnEdit_']
	String editPart2 = "']";
	
	public static int count;
	public static int loop = 0;
	public int Row_count;
	
	public void clickBasic()
	{
		click(btnAdministration);
		click(btnRoleEdit);
	}
	
	public void selectBusinessEntity(String entity)
	{
		try
		{
			select(cmbBusinessEntity, entity);
			Thread.sleep(3000);
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
	
	public void Get_Values_According_To_Role_Name(String rolename, String status, String newRoleName) throws InterruptedException
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
					
					String xpath_for_Edit_Button = editPart1+(i-1)+editPart2;
					
					if(readAndCompare(grdRoleName, rolename) && readAndCompare(grdStatus, status))
					{	
						btnEdit = By.xpath(xpath_for_Edit_Button);
						click(btnEdit);
						clearAndType(txtRoleName, newRoleName);
						click(btnUpdate);
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
			Get_Values_According_To_Role_Name(rolename, status, newRoleName);
		}	
	}
	
	public void Single_Page_Search(String rolename, String status, String newRoleName)
	{
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
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
							
							String xpath_for_Edit_Button = editPart1+(i-1)+editPart2;
							
							if(readAndCompare(grdRoleName, rolename) && readAndCompare(grdStatus, status))
							{	
								btnEdit = By.xpath(xpath_for_Edit_Button);
								click(btnEdit);
								clearAndType(txtRoleName, newRoleName);
								click(btnUpdate);
							}										
							return;
						}	
					}
	}
	
	public void Search_Grid_for_RoleName(String rolename, String status, String newRoleName)throws Exception
	{
		if(Row_count<10)
		{
			Single_Page_Search(rolename, status, newRoleName);
		}
		else if(Row_count>10)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_Role_Name(rolename, status, newRoleName);
		}
	}
	
	public void Is_Role_Creates_With_Special_Characters()
	{
		isElementPresent(lblWarningMark);
	}
	
	public void Is_Role_Duplicated(String RoleDuplicateMessage)
	{
		isTextPresent(RoleDuplicateMessage);
	}
	
	public void Verify_Role_Edit(String RoleUpdateSucessMessage) throws Exception
	{
		if(readAndCompare(lblRoleEditSuccess, RoleUpdateSucessMessage))
		{
			click(btnBack);
			return;
		}
			else  
				throw new Exception();
	}
	
}
