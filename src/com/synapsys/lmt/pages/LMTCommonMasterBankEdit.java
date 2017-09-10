package com.synapsys.lmt.pages;

import com.synapsys.lmt.lib.SeleniumBase;

import org.openqa.selenium.By;


public class LMTCommonMasterBankEdit extends SeleniumBase
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnBank_Branches = By.xpath(".//*[@id='TreeScreent25']");
	public static By txtCode = By.xpath(".//*[@id='ContentPlaceHolder1_txtCodeSearch']");
	public static By txtName = By.xpath(".//*[@id='ContentPlaceHolder1_txtNameSearch']");
	public static By btnSearch = By.xpath(".//*[@id='ContentPlaceHolder1_btnSearch']");
	public static By lblPageOf = By.xpath(".//*[@id='ContentPlaceHolder1_grdBank_lblTotalPage']");
	public static By btnNextPage = By.xpath(".//*[@id='ContentPlaceHolder1_grdBank_imgPageNext']");
	public static By txtBankCode=By.xpath(".//*[@id='ContentPlaceHolder1_txtCode']");
	public static By btnSave = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By lblBankEditSuccess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	public static By grdbankCode;
	public static By grdbanName;
	public static By grdstatus;
	public static By btnEdit;
	
	String first_part = ".//*[@id='ContentPlaceHolder1_grdBank']/tbody/tr[";
	String second_part = "]/td[";
	String third_part = "]";
	
	String editPart1 = ".//*[@id='ContentPlaceHolder1_grdBank_lbnEdit_";      
	String editPart2 = "']";
	
	public static int count;
	public static int loop = 0;
	public static int Row_count;
	
	public void initialize(String code, String name)
	{
		click(btnAdministration);
		click(btnBank_Branches);
		clearAndType(txtCode, code);
		clearAndType(txtName, name);
		click(btnSearch);
		Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_grdBank']/tbody/tr")).size();
	}
	
	public void Calc_Label_Of_Value()
	{
		 String lblOfValue = driver.findElement(lblPageOf).getText();
		 System.out.println("############### size " + lblOfValue + "##################" );
		 String[] splited = lblOfValue.split(" ");
		 String maxGridSize = splited[1];
		 System.out.println("############### size " + maxGridSize + "##################" );
		 count = Integer.parseInt(maxGridSize);	
	}
	
	public void Get_Values_According_To_Bank_Code(String code, String name, String status, String newCode) throws InterruptedException
	{	
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		boolean role_name_find = false;
		
		for (int i=2; i<=Row_count; i++)
		{
			for(int j=1; j<=1; j++)
			{
				//Thread.sleep(1000);
				String xpath_for_Bank_Code = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_Bank_Code + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_Bank_Code)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(code)){
					
					System.out.println(" ################### username equals  #################");
					grdbankCode = By.xpath(xpath_for_Bank_Code);
					
					String Xpath_for_Bank_Name = first_part+i+second_part+2+third_part;
					grdbanName =By.xpath(Xpath_for_Bank_Name);
					
					String Xpath_for_Status = first_part+i+second_part+3+third_part;
					grdstatus =By.xpath(Xpath_for_Status);
					
					String xpath_for_Edit_Button = editPart1+(i-2)+editPart2;
					
					if(readAndCompare(grdbankCode, code) && readAndCompare(grdbanName, name) && readAndCompare(grdstatus, status))
					{	
						btnEdit = By.xpath(xpath_for_Edit_Button);
						click(btnEdit);
						clearAndType(txtBankCode, newCode);
						click(btnSave);
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
			Get_Values_According_To_Bank_Code(code, name, status, newCode);
		}	
	}
	
	public void SinglePageSearch(String code, String name, String status, String newCode)
	{		
		for (int i=2; i<=Row_count; i++)
		{
				//Thread.sleep(1000);
			String xpath_for_Bank_Code = first_part+i+second_part+1+third_part; 
			
			System.out.println("####################  username  xpath:" + xpath_for_Bank_Code + " #####################");
			String Table_data = driver.findElement(By.xpath(xpath_for_Bank_Code)).getText();
			System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(code))
				{
					
					System.out.println(" ################### username equals  #################");
					grdbankCode = By.xpath(xpath_for_Bank_Code);
					
					String Xpath_for_Bank_Name = first_part+i+second_part+2+third_part;
					grdbanName =By.xpath(Xpath_for_Bank_Name);
					
					String Xpath_for_Status = first_part+i+second_part+3+third_part;
					grdstatus =By.xpath(Xpath_for_Status);
					
					String xpath_for_Edit_Button = editPart1+(i-2)+editPart2;
					
					if(readAndCompare(grdbankCode, code) && readAndCompare(grdbanName, name) && readAndCompare(grdstatus, status))
					{	
						btnEdit = By.xpath(xpath_for_Edit_Button);
						click(btnEdit);
						clearAndType(txtBankCode, newCode);
						click(btnSave);
					}
				}	
		}
	}
	
	public void Search_Grid_for_Bank_Code(String code, String name, String status, String newCode) throws InterruptedException
	{
		if(Row_count<11)
		{
			SinglePageSearch(code, name, status, newCode);
		}
		else if(Row_count>10)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_Bank_Code(code, name, status, newCode);
		}
	}
	
	public boolean Is_Bank_Edited(String BankUpdateSucessMessage)throws Exception{
		//isTextPresent(RolesucessMessage);
		if(readAndCompare(lblBankEditSuccess, BankUpdateSucessMessage))
		return true;
		else  
			throw new Exception();
	}

}
