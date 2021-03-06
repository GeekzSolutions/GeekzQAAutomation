package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTPartnerAuthorize extends SeleniumBase
{
	public static By btnBusinessEntity = By.xpath(".//*[@id='NavigationMenu']/ul/li[1]/a/span[2]/span");
	public static By btnPartnerAuthorize = By.xpath(".//*[@id='TreeScreent21']");
	public static By btnAuthorize;
	
	public static By gridCreatedDate;
	public static By gridPCode;
	public static By gridPName;
	public static By gridCountry;
	public static By gridStatus;
	
	String tablePart1 = ".//*[@id='ContentPlaceHolder1_gdvexhouse']/tbody/tr[";
	String tablePart2 = "]/td[";
	String tablePart3 = "]";
	
	String authorizePart1 = ".//*[@id='ContentPlaceHolder1_gdvexhouse_btnedit_";
	String authorizePart2 = "']";
	
	public static int count;
	public static int loop = 0;
	public int Row_count;
	
	public static By btnApprove = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By btnBack = By.xpath(".//*[@id='ContentPlaceHolder1_btnCancel']");
	public static By lblSuccess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	
	public void initailizeAuthorize()
	{
		try
		{
			//navigate to authorise page
			click(btnBusinessEntity);
			click(btnPartnerAuthorize);
			Thread.sleep(2000);
			Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvexhouse']/tbody/tr")).size();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void Single_Page_Search(String createdDate, String pCode, String pName, String country, String status)
	{
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
				System.out.println("################ Row count : " + Row_count + "#######################");
				
				for (int i=2; i<=Row_count; i++)
				{

						
						//Thread.sleep(1000);
						String xpath_for_PCode = tablePart1+i+tablePart2+2+tablePart3; 
						
						System.out.println("####################  username  xpath:" + xpath_for_PCode + " #####################");
						String Table_data = driver.findElement(By.xpath(xpath_for_PCode)).getText();
						System.out.println("#################### table data :  " + Table_data + " #####################");
						
						if(Table_data.equals(pCode)){
							
							System.out.println(" ################### username equals  #################");
							gridPCode = By.xpath(xpath_for_PCode);
							
							String Xpath_for_Date = tablePart1+i+tablePart2+1+tablePart3;
							gridCreatedDate =By.xpath(Xpath_for_Date);
							
							String Xpath_for_PName = tablePart1+i+tablePart2+3+tablePart3;
							gridPName =By.xpath(Xpath_for_PName);
							
							String Xpath_for_Country = tablePart1+i+tablePart2+4+tablePart3;
							gridCountry =By.xpath(Xpath_for_Country);
							
							String Xpath_for_Status = tablePart1+i+tablePart2+5+tablePart3;
							gridStatus =By.xpath(Xpath_for_Status);
							
							String xpath_for_Authorize = authorizePart1+(i-2)+authorizePart2;
							
							if(readAndCompare(gridPCode, pCode) && readAndCompare(gridCreatedDate, createdDate) && readAndCompare(gridPName, pName) && readAndCompare(gridCountry, country) && readAndCompare(gridStatus, status))
							{	
								btnAuthorize = By.xpath(xpath_for_Authorize);
								click(btnAuthorize);
							}											
							return;
						}	
					}
	}
	
	public void Search_Grid_for_PCode(String createdDate, String pCode, String pName, String country, String status)throws Exception
	{
		if(Row_count<10)
		{
			Single_Page_Search(createdDate, pCode, pName, country, status);
		}
		else if(Row_count>10)
		{
			//Calc_Label_Of_Value();
			//Get_Values_According_To_Role_Name(rolename, status);
		}
	}
	
	public void validateAuthorize(String message)throws Exception
	{
		//complete code here
		click(btnApprove);
		
		if(readAndCompare(lblSuccess, message))
		{
			click(btnBack);
		}
		else 
			throw new Exception();
	}
	
}
