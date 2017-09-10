package com.synapsys.lmt.pages;

import org.openqa.selenium.By;
import com.synapsys.lmt.lib.SeleniumBase;

public class LMTExchangeCompanyEdit extends SeleniumBase 
{
	public static By btnBusinessEntity = By.xpath(".//*[@id='NavigationMenu']/ul/li[1]/a/span[2]/span");
	public static By btnECEdit = By.xpath(".//*[@id='TreeScreent11']");
	public static By btnEditCompany;
	
	public static By gridCreatedDate;
	public static By gridECCode;
	public static By gridECName;
	public static By gridCountry;
	public static By gridStatus;
	
	String tablePart1 = ".//*[@id='ContentPlaceHolder1_gdvexhouse']/tbody/tr[";
	String tablePart2 = "]/td[";
	String tablePart3 = "]";
	
	String editPart1 = ".//*[@id='ContentPlaceHolder1_gdvexhouse_btnedit_";
	String editPart2 = "']";
	
	public static int count;
	public static int loop = 0;
	public int Row_count;
	
	public static By btnUpdate = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By btnBack = By.xpath(".//*[@id='ContentPlaceHolder1_btnCancel']");
	public static By lblSuccess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	
	public static By tabContacts = By.xpath(".//*[@id='__tab_ContentPlaceHolder1_tabExHouse_contactTab']/span");
	public static By txtCity = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_contactTab_txtcity']");
	
	public void initailize()
	{
		try
		{
			//navigate to edit page
			click(btnBusinessEntity);
			click(btnECEdit);
			Thread.sleep(2000);
			Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvexhouse']/tbody/tr")).size();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public void Single_Page_Search(String createdDate, String ecCode, String ecName, String country, String status)
	{
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
				System.out.println("################ Row count : " + Row_count + "#######################");
				
				for (int i=2; i<=Row_count; i++)
				{

						
						//Thread.sleep(1000);
						String xpath_for_ECCode = tablePart1+i+tablePart2+2+tablePart3; 
						
						System.out.println("####################  username  xpath:" + xpath_for_ECCode + " #####################");
						String Table_data = driver.findElement(By.xpath(xpath_for_ECCode)).getText();
						System.out.println("#################### table data :  " + Table_data + " #####################");
						
						if(Table_data.equals(ecCode)){
							
							System.out.println(" ################### username equals  #################");
							gridECCode = By.xpath(xpath_for_ECCode);
							
							String Xpath_for_Date = tablePart1+i+tablePart2+1+tablePart3;
							gridCreatedDate =By.xpath(Xpath_for_Date);
							
							String Xpath_for_ECName = tablePart1+i+tablePart2+3+tablePart3;
							gridECName =By.xpath(Xpath_for_ECName);
							
							String Xpath_for_Country = tablePart1+i+tablePart2+4+tablePart3;
							gridCountry =By.xpath(Xpath_for_Country);
							
							String Xpath_for_Status = tablePart1+i+tablePart2+5+tablePart3;
							gridStatus =By.xpath(Xpath_for_Status);
							
							String xpath_for_ComapanyEdit = editPart1+(i-2)+editPart2;
							
							if(readAndCompare(gridECCode, ecCode) && readAndCompare(gridCreatedDate, createdDate) && readAndCompare(gridECName, ecName) && readAndCompare(gridCountry, country) && readAndCompare(gridStatus, status))
							{	
								btnEditCompany = By.xpath(xpath_for_ComapanyEdit);
								click(btnEditCompany);
							}											
							return;
						}	
					}
	}
	
	public void Search_Grid_for_ECCode(String createdDate, String ecCode, String ecName, String country, String status)throws Exception
	{
		if(Row_count<10)
		{
			Single_Page_Search(createdDate, ecCode, ecName, country, status);
		}
		else if(Row_count>10)
		{
			//Calc_Label_Of_Value();
			//Get_Values_According_To_Role_Name(rolename, status);
		}
	}
	
	public void editCompany(String newCity)
	{
		//edit details of the company
		click(tabContacts);
		clearAndType(txtCity, newCity);
		click(btnUpdate);
	}
	
	public void validateEdit(String message)throws Exception
	{
		if(readAndCompare(lblSuccess, message))
		{
			click(btnBack);
		}
		else throw new Exception();
	}
	
	
}
