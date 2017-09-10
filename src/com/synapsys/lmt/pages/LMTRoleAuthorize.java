package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTRoleAuthorize extends SeleniumBase {

	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnRoleAuthorize = By.xpath(".//*[@id='TreeScreent3']");
	public static By cmbBusinessEntity = By.xpath(".//*[@id='ContentPlaceHolder1_ddlBusinessEntity']");
	public static By txtrolename = By.xpath(".//*[@id='ContentPlaceHolder1_txtRoleName']");
	public static By btnApprove = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By btnBack = By.xpath(".//*[@id='ContentPlaceHolder1_btnClear']");
	public static By btnNextPage = By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles_imgPageNext']");
	public static By lblAuthorizeSuccess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	public static By grdRoleName;
	public static By grdStatus;
	public static By btnApproveIcon;
	
	String tablePart1 = ".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr[";
	String tablePart2 = "]/td[";
	String tablePart3 = "]";
	
	String authorizePart1 = ".//*[@id='ContentPlaceHolder1_dtgRoles_lbnEdit_";
	String authorizePart2 = "']";
	
	public static int count;
	public static int loop = 0;
	public int Row_count;
	
	public void initailizeAuthorize()
	{
		try
		{
			//navigate to authorise page
			click(btnAdministration);
			click(btnRoleAuthorize);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void navigate()
	{
		click(btnAdministration);
		click(btnRoleAuthorize);
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
				String xpath_for_Role_Name = tablePart1+i+tablePart2+1+tablePart3; 
				
				System.out.println("####################  username  xpath:" + xpath_for_Role_Name + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_Role_Name)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(rolename)){
					
					System.out.println(" ################### username equals  #################");
					grdRoleName = By.xpath(xpath_for_Role_Name);
					
					String Xpath_for_Status = tablePart1+i+tablePart2+2+tablePart3;
					grdStatus =By.xpath(Xpath_for_Status);
					
					String xpath_for_Approve_Button = authorizePart1+(i-2)+authorizePart2;
					
					if(readAndCompare(grdRoleName, rolename) && readAndCompare(grdStatus, status))
					{	
						btnApproveIcon = By.xpath(xpath_for_Approve_Button);
						click(btnApproveIcon);
					}
					
					role_name_find = true;											
					return;
				}	
			}
		}
				
		if((!role_name_find)&&(loop < count))
		{
			//Thread.sleep(1000);
			click(btnNextPage);
			//Thread.sleep(1000);
			loop++;
			System.out.println("#### Move to next Grid ######");
			Get_Values_According_To_Role_Name(rolename, status);
		}	
	}
	
	public void Single_Page_Search(String rolename, String status)
	{
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
				System.out.println("################ Row count : " + Row_count + "#######################");
				
				for (int i=2; i<=Row_count; i++)
				{

						
						//Thread.sleep(1000);
						String xpath_for_Role_Name = tablePart1+i+tablePart2+1+tablePart3; 
						
						System.out.println("####################  username  xpath:" + xpath_for_Role_Name + " #####################");
						String Table_data = driver.findElement(By.xpath(xpath_for_Role_Name)).getText();
						System.out.println("#################### table data :  " + Table_data + " #####################");
						
						if(Table_data.equals(rolename)){
							
							System.out.println(" ################### username equals  #################");
							grdRoleName = By.xpath(xpath_for_Role_Name);
							
							String Xpath_for_Status = tablePart1+i+tablePart2+2+tablePart3;
							grdStatus =By.xpath(Xpath_for_Status);
							
							String xpath_for_Approve_Button = authorizePart1+(i-2)+authorizePart2;
							
							if(readAndCompare(grdRoleName, rolename) && readAndCompare(grdStatus, status))
							{	
								btnApproveIcon = By.xpath(xpath_for_Approve_Button);
								click(btnApproveIcon);
							}											
							return;
						}	
					}
	}
	
	public void Search_Grid_for_RoleName(String rolename, String status)throws Exception
	{
		if(Row_count<10)
		{
			Single_Page_Search(rolename, status);
		}
		else if(Row_count>10)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_Role_Name(rolename, status);
		}
	}
	
	public void Is_Role_Authorized(String RoleAuthorizeSucessMessage)throws Exception
	{
		//isTextPresent(RolesucessMessage);
		if(readAndCompare(lblAuthorizeSuccess, RoleAuthorizeSucessMessage))
		return;
		else  
			throw new Exception();
	}
	
	public void Verify_Role_Authorize(String roleName, String RoleAuthorized) throws Exception
	{
		if(readAndCompareByValue(txtrolename, roleName))
		{
			click(btnApprove);
			Is_Role_Authorized(RoleAuthorized);
			click(btnBack);
			return;
		}
		else
			throw new Exception();
	}
	
	
}
