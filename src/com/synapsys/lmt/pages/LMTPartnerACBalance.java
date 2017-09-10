package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTPartnerACBalance extends SeleniumBase
{
	public static By btnBusinessEntity = By.xpath(".//*[@id='NavigationMenu']/ul/li[1]/a/span[2]/span");
	public static By btnACBalance = By.xpath(".//*[@id='TreeScreent28']");
	public static By btnView;
	public static By btnView1;
	
	public static By gridBEName;
	
	String tablePart1 = ".//*[@id='ContentPlaceHolder1_GridViewExHouseSearch']/tbody/tr[";
	String tablePart2 = "]/td[";
	String tablePart3 = "]";
	
	String viewPart1 = ".//*[@id='ContentPlaceHolder1_GridViewExHouseSearch_btnView_";
	String viewPart2 = "']";
	
	public static By gridAccNo;
	public static By gridAccName;
	public static By gridType;
	public static By gridBookType;
	public static By gridCurrency;
	public static By gridAvailableBalance;
	//to be edited
	String table1Part1 = ".//*[@id='grdBEAccount']/tbody/tr[";
	String table1Part2 = "]/td[";
	String table1Part3 = "]";
	
	String view1Part1 = ".//*[@id='grdBEAccount_lbnEdit_";
	String view1Part2 = "']";
	//upto here
	
	public static By btnSearch = By.xpath(".//*[@id='btnSearch']");
	public static By btnBack = By.xpath(".//*[@id='btnBack']");
	public static By btnClose = By.xpath("html/body/div[3]/div[1]/a/span");
	
	public static int count;
	public static int loop = 0;
	public int Row_count;
	public int Row_count1;
	
	public void initailizeAuthorize()
	{
		try
		{
			//navigate to authorise page
			click(btnBusinessEntity);
			click(btnACBalance);
			Thread.sleep(2000);
			Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvexhouse']/tbody/tr")).size(); //change this
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void Single_Page_Search(String businessEntityName)
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
							gridBEName = By.xpath(xpath_for_BEName);
							
							String xpath_for_BEView = viewPart1+(i-2)+viewPart2;
							
							if(readAndCompare(gridBEName, businessEntityName))
							{	
								btnView = By.xpath(xpath_for_BEView);
								click(btnView);
								Row_count1= driver.findElements(By.xpath(".//*[@id='grdBEAccount']/tbody/tr")).size();
							}											
							return;
						}	
					}
	}
	
	public void Single_Page_SearchAcc(String AccNo, String AccName, String Type, String BType, String Currency, String ABalance)
	{
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
				System.out.println("################ Row count : " + Row_count1 + "#######################");
				
				for (int i=2; i<=Row_count1; i++)
				{

						
						//Thread.sleep(1000);
						String xpath_for_AccNo = table1Part1+i+table1Part2+1+table1Part3; 
						
						System.out.println("####################  username  xpath:" + xpath_for_AccNo + " #####################");
						String Table_data = driver.findElement(By.xpath(xpath_for_AccNo)).getText();
						System.out.println("#################### table data :  " + Table_data + " #####################");
						
						if(Table_data.equals(AccNo)){
							
							System.out.println(" ################### username equals  #################");
							gridAccNo = By.xpath(xpath_for_AccNo);
							
							String Xpath_for_AccName = tablePart1+i+tablePart2+2+tablePart3;
							gridAccName =By.xpath(Xpath_for_AccName);
							
							String Xpath_for_Type = tablePart1+i+tablePart2+3+tablePart3;
							gridType =By.xpath(Xpath_for_Type);
							
							String Xpath_for_BookType = tablePart1+i+tablePart2+4+tablePart3;
							gridBookType =By.xpath(Xpath_for_BookType);
							
							String Xpath_for_Currency = tablePart1+i+tablePart2+5+tablePart3;
							gridCurrency =By.xpath(Xpath_for_Currency);
							
							String Xpath_for_ABalance = tablePart1+i+tablePart2+6+tablePart3;
							gridAvailableBalance =By.xpath(Xpath_for_ABalance);
							
							String xpath_for_AccView = view1Part1+(i-2)+view1Part2;
							
							
							
							if(readAndCompare(gridBEName, AccNo))
							{	
								btnView1 = By.xpath(xpath_for_AccView);
								click(btnView1);
							}											
							return;
						}	
					}
	}
	
	public void viewAcc()
	{
		click(btnSearch);
		click(btnBack);
		click(btnClose);
	}
	
}
