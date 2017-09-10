package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTExchangeCompanyCSView extends SeleniumBase
{
	public static By btnBusinessEntity = By.xpath(".//*[@id='NavigationMenu']/ul/li[1]/a/span[2]/span");
	public static By btnChargeSetup = By.xpath(".//*[@id='TreeScreent15']");
	public static By grdBusinessEntityName;
	public static By btnView;
	public static By btnClose = By.xpath("html/body/div[3]/div[1]/a/span");
	
	String tablePart1 = ".//*[@id='ContentPlaceHolder1_GridViewExHouseSearch']/tbody/tr[";
	String tablePart2 = "]/td[";
	String tablePart3 = "]";
	
	String viewPart1 = ".//*[@id='ContentPlaceHolder1_GridViewExHouseSearch_btnView_";
	String viewPart2 = "']";
	
	String table1Part1 = ".//*[@id='grdviewTransation']/tbody/tr[";
	String table1Part2 = "]/td[";
	String table1Part3 = "]";
	
	public static By grdTransType;
	public static By grdCcy;
	public static By grdCalType;
	public static By grdStatus;
	
	public static By grdBtnView;
	
	String view1Part1 = ".//*[@id='grdviewTransation_btnedit_";
	String view1Part2 = "']";
	
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
			click(btnChargeSetup);
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
							
							
							String xpath_for_viewButton = viewPart1+(i-2)+viewPart2;
							
							if(readAndCompare(grdBusinessEntityName, businessEntityName))
							{	
								btnView = By.xpath(xpath_for_viewButton);
								click(btnView);
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
	
	public void Single_Page_Search_TransType(String transType, String ccy, String calType, String status)
	{
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
				System.out.println("################ Row count : " + Row_count + "#######################");
				
				for (int i=2; i<=Row_count1; i++)
				{

						
						//Thread.sleep(1000);
						String xpath_for_transType = table1Part1+i+table1Part2+1+tablePart3; 
						
						System.out.println("####################  username  xpath:" + xpath_for_transType + " #####################");
						String Table_data = driver.findElement(By.xpath(xpath_for_transType)).getText();
						System.out.println("#################### table data :  " + Table_data + " #####################");
						
						if(Table_data.equals(transType)){
							
							System.out.println(" ################### username equals  #################");
							grdTransType = By.xpath(xpath_for_transType);
							
							String Xpath_for_ccy = tablePart1+i+tablePart2+2+tablePart3;
							grdCcy =By.xpath(Xpath_for_ccy);
							
							String Xpath_for_calType = tablePart1+i+tablePart2+3+tablePart3;
							grdCalType =By.xpath(Xpath_for_calType);
							
							String Xpath_for_status = tablePart1+i+tablePart2+4+tablePart3;
							grdStatus =By.xpath(Xpath_for_status);
							
							String xpath_for_viewButton = view1Part1+(i-2)+view1Part2;
							
							if(readAndCompare(grdTransType, transType) && readAndCompare(grdCcy, ccy) && readAndCompare(grdCalType, calType) && readAndCompare(grdStatus, status))
							{	
								grdBtnView = By.xpath(xpath_for_viewButton);
								click(grdBtnView);
							}											
							return;
						}	
					}
	}
	
	public void Search_Grid_for_ACNo(String transType, String ccy, String calType, String status)throws Exception
	{
		if(Row_count<10)
		{
			Single_Page_Search_TransType(transType, ccy, calType, status);
		}
		else if(Row_count>10)
		{
			//Calc_Label_Of_Value();
			//Get_Values_According_To_Role_Name(rolename, status);
		}
	}
	
	
	
	
}
