package com.synapsys.lmt.pages;

import com.synapsys.lmt.lib.SeleniumBase;

import org.openqa.selenium.By;

public class LMTSystemParameterEdit extends SeleniumBase
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnSystemParameter = By.xpath(".//*[@id='TreeScreent28']");
	public static By txtHeaderName = By.xpath(".//*[@id='ContentPlaceHolder1_txtParameterHeader']");
	public static By txtDetail = By.xpath(".//*[@id='ContentPlaceHolder1_txtdetail']");
	public static By btnSave = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By btnCancel = By.xpath(".//*[@id='ContentPlaceHolder1_btnCancel']");
	public static By lblPages = By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles_lblTotalPage']");
	public static By btnNextPage = By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles_imgPageNext']");
	public static By lblEditSuccessMessage = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	public static By btnEdit;
	
	public static By grdSystemParameterID;
	public static By grdParameterHeader;
	public static By grdParameterDetail;
	
	String first_part = ".//*[@id='ContentPlaceHolder1_gridSystemParameter']/tbody/tr[";
	String second_part = "]/td[";
	String third_part = "]";
	
	String editPart1 = ".//*[@id='ContentPlaceHolder1_gridSystemParameter_lblEdit_"; 
	String editPart2 = "']";
	
	public static int count;
	public static int loop = 0;
	public static int Row_count;
	
	public void clickBasic()throws Exception
	{
		click(btnAdministration);
		click(btnSystemParameter);
		Thread.sleep(3000);
		Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gridSystemParameter']/tbody/tr")).size();
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
	
	public void Get_Values_According_To_Parameter_Name(String parameterID, String headerName, String headerDetail) throws InterruptedException
	{	
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gridSystemParameter']/tbody/tr")).size(); 
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		boolean parameter_find = false;
		
		for (int i=2; i<=Row_count; i++){
			for(int j=1; j<=1; j++){
				
				//Thread.sleep(1000);
				String xpath_for_Parameter_ID = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_Parameter_ID + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_Parameter_ID)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(parameterID)){
					
					System.out.println(" ################### username equals  #################");
					grdSystemParameterID = By.xpath(xpath_for_Parameter_ID);
					
					String Xpath_for_Parameter_Header = first_part+i+second_part+2+third_part;
					grdParameterHeader =By.xpath(Xpath_for_Parameter_Header);
					
					String xpath_for_Parameter_Detail = first_part+i+second_part+3+third_part;
					grdParameterDetail = By.xpath(xpath_for_Parameter_Detail);
					
					String xpath_for_Edit_Button = editPart1+(i-2)+editPart2;
					
					if(readAndCompare(grdSystemParameterID, parameterID) && readAndCompare(grdParameterHeader, headerName) && readAndCompare(grdParameterDetail, headerDetail))
					{	
						btnEdit = By.xpath(xpath_for_Edit_Button);
						click(btnEdit);
					}
					
					parameter_find = true;											
					return;
				}	
			}
		}
				
		if((!parameter_find)&&(loop < count))
		{
			click(btnNextPage);
			loop++;
			System.out.println("#### Move to next Grid ######");
			Get_Values_According_To_Parameter_Name(parameterID, headerName, headerDetail);
		}	
	}
	
	public void Single_Page_Search(String parameterID, String headerName, String headerDetail) throws InterruptedException
	{	
		int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gridSystemParameter']/tbody/tr")).size(); 
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		for (int i=2; i<=Row_count; i++)
		{
				//Thread.sleep(1000);
				String xpath_for_Parameter_ID = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_Parameter_ID + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_Parameter_ID)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(parameterID))
				{
					
					System.out.println(" ################### username equals  #################");
					grdSystemParameterID = By.xpath(xpath_for_Parameter_ID);
					
					String Xpath_for_Parameter_Header = first_part+i+second_part+2+third_part;
					grdParameterHeader =By.xpath(Xpath_for_Parameter_Header);
					
					String xpath_for_Parameter_Detail = first_part+i+second_part+3+third_part;
					grdParameterDetail = By.xpath(xpath_for_Parameter_Detail);
					
					String xpath_for_Edit_Button = editPart1+(i-2)+editPart2;
					
					if(readAndCompare(grdSystemParameterID, parameterID) && readAndCompare(grdParameterHeader, headerName) && readAndCompare(grdParameterDetail, headerDetail))
					{	
						btnEdit = By.xpath(xpath_for_Edit_Button);
						click(btnEdit);
					}
																
					return;
				}	
		}
	}
	
	public void Search_Grid_for_Parameter_Name(String parameterID, String headerName, String headerDetail) throws InterruptedException
	{
		if(Row_count<30)
		{
			Single_Page_Search(parameterID, headerName, headerDetail);
		}
		else if(Row_count>30)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_Parameter_Name(parameterID, headerName, headerDetail);
		}
	}
	
	public void Is_Parameter_Edited(String EditSuccessMessage) throws Exception
	{
		if(readAndCompare(lblEditSuccessMessage, EditSuccessMessage))
			return;
		else
			throw new Exception();
	}
	
	public void Verify_Parameter_Edit_in_Grid(String headerName, String newHeaderDetail) throws Exception
	{
		if(readAndCompareByValue(txtHeaderName, headerName))
		{
			clearAndType(txtDetail, newHeaderDetail);
			click(btnSave);
			return;
		}
		else
			throw new Exception();
	}

}
