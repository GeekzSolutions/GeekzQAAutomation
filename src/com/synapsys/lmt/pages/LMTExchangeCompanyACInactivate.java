package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTExchangeCompanyACInactivate extends SeleniumBase
{
	public static By btnBusinessEntity = By.xpath(".//*[@id='NavigationMenu']/ul/li[1]/a/span[2]/span");
	public static By btnECACSettings = By.xpath(".//*[@id='TreeScreent14']");
	public static By grdBusinessEntityName;
	public static By btnInactivate;
	public static By btnClose = By.xpath("html/body/div[3]/div[1]/a/span");
	
	String tablePart1 = ".//*[@id='ContentPlaceHolder1_GridViewExHouseSearch']/tbody/tr[";
	String tablePart2 = "]/td[";
	String tablePart3 = "]";
	
	String inactivatePart1 = ".//*[@id='ContentPlaceHolder1_GridViewExHouseSearch_btnInactivate_";
	String inactivatePart2 = "']";
	
	String table1Part1 = ".//*[@id='grdBEAccount']/tbody/tr[";
	String table1Part2 = "]/td[";
	String table1Part3 = "]";
	
	String inactivate1Part1 = ".//*[@id='grdBEAccount_lbnEdit_";
	String inactivate1Part2 = "']";
	
	public static By grdACNo;
	public static By grdACName;
	public static By grdType;
	public static By grdBookType;
	public static By grdCurrency;
	public static By grdStatus;
	
	public static By grdBtnInactive;
	
	
	public static By btnSave = By.xpath(".//*[@id='btnSave']");
	public static By btnBack = By.xpath(".//*[@id='btnBack']");
	public static By lblSuccess = By.xpath(".//*[@id='Notification1_lblsuccess']");
	
	public static int count;
	public static int loop = 0;
	public int Row_count;
	public int Row_count1;
	
	public void initailize()
	{
		try
		{
			//navigate to edit page
			click(btnBusinessEntity);
			click(btnECACSettings);
			Thread.sleep(2000);
			Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_GridViewExHouseSearch']/tbody/tr")).size();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void Single_Page_Search_BEName(String businessEntityName)
	{
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
				System.out.println("################ Row count : " + Row_count + "#######################");
				
				for (int i=2; i<=Row_count; i++)
				{

						
						//Thread.sleep(1000);
						String xpath_for_BEName = tablePart1+i+tablePart2+1+tablePart3; 
						
						System.out.println("####################  username  xpath:" + xpath_for_BEName + " #####################");
						String Table_data = driver.findElement(By.xpath(xpath_for_BEName)).getText();
						System.out.println("#################### table data :  " + Table_data + " #####################");
						
						if(Table_data.equals(businessEntityName)){
							
							System.out.println(" ################### username equals  #################");
							grdBusinessEntityName = By.xpath(xpath_for_BEName);
							
							
							String xpath_for_authorizeButton = inactivatePart1+(i-2)+inactivatePart2;
							
							if(readAndCompare(grdBusinessEntityName, businessEntityName))
							{	
								btnInactivate = By.xpath(xpath_for_authorizeButton);
								click(btnInactivate);
							}											
							return;
						}	
					}
	}
	
	public void Search_Grid_for_BEName(String businessEntityName)throws Exception
	{
		if(Row_count<10)
		{
			Single_Page_Search_BEName(businessEntityName);
			Thread.sleep(300);
			Row_count1 = driver.findElements(By.xpath(".//*[@id='grdBEAccount']/tbody/tr")).size();
		}
		else if(Row_count>10)
		{
			//Calc_Label_Of_Value();
			//Get_Values_According_To_Role_Name(rolename, status);
		}
	}
	
	public void Single_Page_Search_ACNo(String acNo, String acName, String type, String bookType, String currency, String status)
	{
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
				System.out.println("################ Row count : " + Row_count + "#######################");
				
				for (int i=2; i<=Row_count1; i++)
				{

						
						//Thread.sleep(1000);
						String xpath_for_acNo = table1Part1+i+table1Part2+1+tablePart3; 
						
						System.out.println("####################  username  xpath:" + xpath_for_acNo + " #####################");
						String Table_data = driver.findElement(By.xpath(xpath_for_acNo)).getText();
						System.out.println("#################### table data :  " + Table_data + " #####################");
						
						if(Table_data.equals(acNo)){
							
							System.out.println(" ################### username equals  #################");
							grdACNo = By.xpath(xpath_for_acNo);
							
							String Xpath_for_ACName = tablePart1+i+tablePart2+2+tablePart3;
							grdACNo =By.xpath(Xpath_for_ACName);
							
							String Xpath_for_Type = tablePart1+i+tablePart2+3+tablePart3;
							grdType =By.xpath(Xpath_for_Type);
							
							String Xpath_for_BookType = tablePart1+i+tablePart2+4+tablePart3;
							grdBookType =By.xpath(Xpath_for_BookType);
							
							String Xpath_for_Currency = tablePart1+i+tablePart2+5+tablePart3;
							grdCurrency =By.xpath(Xpath_for_Currency);
							
							String Xpath_for_Status = tablePart1+i+tablePart2+6+tablePart3;
							grdStatus=By.xpath(Xpath_for_Status);
							
							String xpath_for_authorizeButton = inactivate1Part1+(i-2)+inactivate1Part2;
							
							if(readAndCompare(grdACNo, acNo) && readAndCompare(grdACName, acName) && readAndCompare(grdType, type) && readAndCompare(grdBookType, bookType) && readAndCompare(grdCurrency, currency) && readAndCompare(grdStatus, status))
							{	
								grdBtnInactive = By.xpath(xpath_for_authorizeButton);
								click(grdBtnInactive);
							}											
							return;
						}	
					}
	}
	
	public void Search_Grid_for_ACNo(String acNo, String acName, String type, String bookType, String currency, String status)throws Exception
	{
		if(Row_count<10)
		{
			Single_Page_Search_ACNo(acNo, acName, type, bookType, currency, status);
		}
		else if(Row_count>10)
		{
			//Calc_Label_Of_Value();
			//Get_Values_According_To_Role_Name(rolename, status);
		}
	}
	
	public void validateInactivate(String message)throws Exception
	{
		if(readAndCompare(lblSuccess, message))
		{
			click(btnBack);
		}
		else 
			throw new Exception();
	}
	
	
}
