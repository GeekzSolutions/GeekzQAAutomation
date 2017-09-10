package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTExchangeCompanyACCreate extends SeleniumBase
{
	public static By btnBusinessEntity = By.xpath(".//*[@id='NavigationMenu']/ul/li[1]/a/span[2]/span");
	public static By btnECACSettings = By.xpath(".//*[@id='TreeScreent14']");
	public static By grdBusinessEntityName;
	public static By btnCreate;
	public static By btnClose = By.xpath("html/body/div[3]/div[1]/a/span");
	
	String tablePart1 = ".//*[@id='ContentPlaceHolder1_GridViewExHouseSearch']/tbody/tr[";
	String tablePart2 = "]/td[";
	String tablePart3 = "]";
	
	String createPart1 = ".//*[@id='ContentPlaceHolder1_GridViewExHouseSearch_btnCreate_";
	String createPart2 = "']";
	
	public static By txtACNo = By.xpath(".//*[@id='txtAccountNo']");
	public static By cmbACType = By.xpath(".//*[@id='ddlAccountType']");
	public static By cmbACBookType = By.xpath(".//*[@id='ddlAccountBookType']");
	public static By cmbCurrency = By.xpath(".//*[@id='ddlCurrency']");
	public static By btnSave = By.xpath(".//*[@id='btnSave']");
	public static By btnCancel = By.xpath(".//*[@id='btnNew']");
	
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
							
							
							String xpath_for_viewButton = createPart1+(i-2)+createPart2;
							
							if(readAndCompare(grdBusinessEntityName, businessEntityName))
							{	
								btnCreate = By.xpath(xpath_for_viewButton);
								click(btnCreate);
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
		}
		else if(Row_count>10)
		{
			//Calc_Label_Of_Value();
			//Get_Values_According_To_Role_Name(rolename, status);
		}
	}
	
	public void createAccount(String accNo, String accType, String accBookType, String currency)
	{
		try
		{
			clearAndType(txtACNo, accNo);
			select(cmbACType, accType);
			select(cmbACBookType, accBookType);
			select(cmbCurrency, currency);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void validateACCreate(String message)
	{
		readAndCompare(lblSuccess, message);
		click(btnClose);
	}
	
}
