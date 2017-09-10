package com.synapsys.lmt.pages;


import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTDesignationEdit extends SeleniumBase
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnDesignation = By.xpath(".//*[@id='TreeScreent12']");
	public static By txtDesignation = By.xpath(".//*[@id='ContentPlaceHolder1_txtDesignation']");
	public static By txtDescription = By.xpath(".//*[@id='ContentPlaceHolder1_txtDescription']");
	public static By chkActive = By.xpath(".//*[@id='ContentPlaceHolder1_chkActive']");
	public static By btnSave = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By btnClear = By.xpath(".//*[@id='ContentPlaceHolder1_btnClear']");
	public static By lblDeisgDuplicateMessage = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblerror']");
	public static By lblWarningMark = By.xpath(".//*[@id='ContentPlaceHolder1_RrgDesigantion']/img");
	public static By lblDesigUpdateSuccessMessage = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	public static By lblPages = By.xpath(".//*[@id='ContentPlaceHolder1_grdDesignation_lblTotalPage']");
	public static By btnNextPage = By.xpath(".//*[@id='ContentPlaceHolder1_grdDesignation_imgPageNext']");
	public static By btnEdit;				//.//*[@id='ContentPlaceHolder1_grdDesignation_imgPageNext']
	
	public static By grdID;
	public static By grdDesignation;
	public static By grdDescription;
	public static By grdStatus;
	
	String first_part = ".//*[@id='ContentPlaceHolder1_grdDesignation']/tbody/tr[";
	String second_part = "]/td[";
	String third_part = "]";
	
	String editPart1 = ".//*[@id='ContentPlaceHolder1_grdDesignation_lblEdit_"; 
	String editPart2 = "']";
	
	public static int count;
	public static int loop = 0;
	public static int Row_count;
	
	
	public void clickBasic()throws Exception
	{
		click(btnAdministration);
		click(btnDesignation);
		Thread.sleep(3000);
		Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_grdDesignation']/tbody/tr")).size();
		//JOptionPane.showMessageDialog(null, Row_count);
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
	
	public void Get_Values_According_To_Designation_ID(String designationID, String designation, String description, String status, String newDesignation, String newDescription) throws InterruptedException
	{	
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gridSystemParameter']/tbody/tr")).size(); 
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		boolean parameter_find = false;
		
		for (int i=2; i<=Row_count; i++){
			for(int j=1; j<=1; j++){
				
				//Thread.sleep(1000);
				String xpath_for_Designation_ID = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_Designation_ID + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_Designation_ID)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(designationID)){
					
					System.out.println(" ################### username equals  #################");
					grdID = By.xpath(xpath_for_Designation_ID);
					
					String Xpath_for_Designation = first_part+i+second_part+2+third_part;
					grdDesignation =By.xpath(Xpath_for_Designation);
					
					String xpath_for_Description = first_part+i+second_part+3+third_part;
					grdDescription = By.xpath(xpath_for_Description);
					
					String Xpath_for_Status = first_part+i+second_part+4+third_part;
					grdStatus = By.xpath(Xpath_for_Status);
					
					String xpath_for_Edit_Button = editPart1+(i-2)+editPart2;
					
					if(readAndCompare(grdID, designationID) && readAndCompare(grdDesignation, designation) && readAndCompare(grdDescription, description) && readAndCompare(grdStatus, status))
					{	
						btnEdit = By.xpath(xpath_for_Edit_Button);
						click(btnEdit);
						clearAndType(txtDesignation, newDesignation);
						clearAndType(txtDescription, newDescription);
						click(btnSave);
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
			Get_Values_According_To_Designation_ID(designationID, designation, description, status, newDesignation, newDescription);
		}	
	}
	
	public void Single_Page_Search(String designationID, String designation, String description, String status, String newDesignation, String newDescription) throws InterruptedException
	{	
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gridSystemParameter']/tbody/tr")).size(); 
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		for (int i=2; i<=Row_count; i++)
		{
				//Thread.sleep(1000);
			String xpath_for_Designation_ID = first_part+i+second_part+1+third_part; 
			
			System.out.println("####################  username  xpath:" + xpath_for_Designation_ID + " #####################");
			String Table_data = driver.findElement(By.xpath(xpath_for_Designation_ID)).getText();
			System.out.println("#################### table data :  " + Table_data + " #####################");
			
			if(Table_data.equals(designationID)){
				
				System.out.println(" ################### username equals  #################");
				grdID = By.xpath(xpath_for_Designation_ID);
				
				String Xpath_for_Designation = first_part+i+second_part+2+third_part;
				grdDesignation =By.xpath(Xpath_for_Designation);
				
				String xpath_for_Description = first_part+i+second_part+3+third_part;
				grdDescription = By.xpath(xpath_for_Description);
				
				String Xpath_for_Status = first_part+i+second_part+4+third_part;
				grdStatus = By.xpath(Xpath_for_Status);
				
				String xpath_for_Edit_Button = editPart1+(i-2)+editPart2;
				
				if(readAndCompare(grdID, designationID) && readAndCompare(grdDesignation, designation) && readAndCompare(grdDescription, description) && readAndCompare(grdStatus, status))
				{	
					btnEdit = By.xpath(xpath_for_Edit_Button);
					click(btnEdit);
					clearAndType(txtDesignation, newDesignation);
					clearAndType(txtDescription, newDescription);
					click(btnSave);
				}
																
					return;
				}	
		}
	}
	
	public void Search_Grid_for_Designation(String designationID, String designation, String description, String status, String newDesignation, String newDescription) throws InterruptedException
	{
		if(Row_count<8)
		{
			Single_Page_Search(designationID, designation, description, status, newDesignation, newDescription);
		}
		else if(Row_count>=8)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_Designation_ID(designationID, designation, description, status, newDesignation, newDescription);
		}
	}
	
	public void Is_Designation_Edited(String DesignationEditSuccessMessage) throws Exception
	{
		if(readAndCompare(lblDesigUpdateSuccessMessage, DesignationEditSuccessMessage))
		{
			return;
		}
		else
			throw new Exception();
	}
	
	

}
