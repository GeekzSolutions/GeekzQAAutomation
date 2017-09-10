package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTLockUnlockUser extends SeleniumBase{

	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnUserMaintaince = By.xpath(".//*[@id='TreeScreent20']");
	public static By lblof = By.xpath(".//*[@id='ContentPlaceHolder1_dtgSearchUser_lblTotalPage']");		
	public static By btnNext = By.xpath(".//*[@id='ContentPlaceHolder1_dtgSearchUser_imgPageNext']");
	public static By grdUserName;
	public static By grdFirstName;
	public static By grdLastName;
	public static By btnLockUnlockInGrid;
	
	String first_part = "//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr["; 
	String second_part = "]/td["; 
	String third_part = "]";
	
	//.//*[@id='ContentPlaceHolder1_dtgSearchUser_btnAssignRole_0']
	String btnViewInGrid_FirstPart = ".//*[@id='ContentPlaceHolder1_gdvusers_btnedit_";
	String btnViewInGrid_SecondPart = "']";
	
	public static int count;
	public static int loop = 0;
	public static int Row_count;
	
	public void click_Basic(){
		click(btnAdministration);
		click(btnUserMaintaince);		
		Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr")).size();
	}
	
	public void Calc_Label_Of_Value(){		
		
		//.//*[@id='ContentPlaceHolder1_dtgSearchUser_lblTotalPage']
		 String lblOfValue = driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers_lblTotalPage']")).getText();
		 System.out.println("############### size " + lblOfValue + "##################" );
		 String[] splited = lblOfValue.split(" ");
		 String maxGridSize = splited[1];
		 System.out.println("############### size " + maxGridSize + "##################" );
		 count = Integer.parseInt(maxGridSize);			
		}

	public void SinglePageSearch(String username,String firstName,String lastName) throws Exception{			
		
		System.out.println("################ Row count : " + Row_count + "#######################");					
		
		@SuppressWarnings("unused")
		boolean user_name_find = false;
		
		for (int i=2; i<=Row_count; i++){
			for(int j=1; j<=1; j++){
				
				//Thread.sleep(1000);
				String xpath_for_User_name = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_User_name + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_User_name)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(username)){
					
					System.out.println(" ################### username equals  #################");
					grdUserName = By.xpath(xpath_for_User_name);
					
					String Xpath_for_First_name = first_part+i+second_part+2+third_part;
					grdFirstName =By.xpath(Xpath_for_First_name);
					
					String Xpath_for_Last_name = first_part+i+second_part+3+third_part;
					grdLastName=By.xpath(Xpath_for_Last_name);
												
					this.Verify_User_View_in_Grid(username, firstName, lastName);
					Thread.sleep(1000);
					System.out.println("############## i : " + i + "#################");
					String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-1)+btnViewInGrid_SecondPart;
					btnLockUnlockInGrid = By.xpath(Xpath_for_btnView);
					
					click(btnLockUnlockInGrid);
					
					user_name_find = true;											
					return;
				}
								
			}
			
		}
	}

	public void Search_Grid_for_User_Name(String username,String firstName,String lastName) throws Exception
	{
		if(Row_count<11)
		{
			SinglePageSearch(username, firstName, lastName);
		}
		else if(Row_count>10)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_User_Name(username, firstName, lastName);
		}
	}
	
	
	public void Get_Values_According_To_User_Name(String username,String firstName,String lastName) throws Exception{		
		
		System.out.println("################ Row count : " + Row_count + "#######################");					
		
		boolean user_name_find = false;
		
		for (int i=2; i<=Row_count; i++){
			for(int j=1; j<=1; j++){
				
				//Thread.sleep(1000);
				String xpath_for_User_name = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_User_name + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_User_name)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(username)){
					
					System.out.println(" ################### username equals  #################");
					grdUserName = By.xpath(xpath_for_User_name);
					
					String Xpath_for_First_name = first_part+i+second_part+2+third_part;
					grdFirstName =By.xpath(Xpath_for_First_name);
					
					String Xpath_for_Last_name = first_part+i+second_part+3+third_part;
					grdLastName=By.xpath(Xpath_for_Last_name);
									
					this.Verify_User_View_in_Grid(username, firstName, lastName);
					
					Thread.sleep(3000);
					System.out.println("############## i : " + i + "#################");
					String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-1)+btnViewInGrid_SecondPart;
					btnLockUnlockInGrid = By.xpath(Xpath_for_btnView);
					click(btnLockUnlockInGrid);
					
					user_name_find = true;											
					return;
				}
								
			}
			
		}
		
		if((!user_name_find)&&(loop < count)){
			click(btnNext);
			loop++;
			Thread.sleep(1000);
			System.out.println("#### Move to next Grid ######  "+loop);
			Get_Values_According_To_User_Name(username,firstName,lastName);
		}
		

	}

	
	public void Verify_User_View_in_Grid(String userName,String firstName, String lastName) throws Exception{
		if(readAndCompare(grdUserName, userName) && readAndCompare(grdFirstName,firstName) && readAndCompare(grdLastName,lastName))
			return;
		else
			throw new Exception();
	}
	
	public static By lblUserName = By.xpath(".//*[@id='ContentPlaceHolder1_lblUserName']");
	public static By txtRemarks = By.xpath(".//*[@id='ContentPlaceHolder1_txtRemarks']");
	public static By chkLock = By.xpath(".//*[@id='ContentPlaceHolder1_chklock']");
	public static By btnSave = By.xpath(".//*[@id='ContentPlaceHolder1_btnUnlock']");
	
	public void User_Lock_Sucess(String userName,String remarks)throws Exception{
		if(readAndCompare(lblUserName, userName)){
			click(chkLock);
			clearAndType(txtRemarks, remarks);			
			click(btnSave);
			return ;
		}
		else 
			throw new Exception();
	}

	public static By lblUserlockedSucessMessage = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	public static By btnBack = By.xpath(".//*[@id='ContentPlaceHolder1_btnBack']");
	
	public void User_Locked_Sucess_Message(String UserLockedSucessMessage){
		readAndCompare(lblUserlockedSucessMessage, UserLockedSucessMessage);
		click(btnBack); 
	}
	
}
