package com.synapsys.lmt.pages;

import org.openqa.selenium.By;
import com.synapsys.lmt.lib.SeleniumBase;
import com.thoughtworks.selenium.webdriven.commands.Click;

public class LMTUserSession extends SeleniumBase{

	public static By cmbBusinessEntity = By.xpath(".//*[@id='ContentPlaceHolder1_ddlGroup']");
	public static By cmbBranch = By.xpath(".//*[@id='ContentPlaceHolder1_ddlBranch']");
	public static By cmbLoginStatus = By.xpath(".//*[@id='ContentPlaceHolder1_ddlLoginStatus']");
	public static By txtUserName = By.xpath(".//*[@id='ContentPlaceHolder1_txtUserName']");
	public static By dtpFromDate = By.xpath(".//*[@id='ContentPlaceHolder1_txtFromDate']");
	public static By dtpToDate = By.xpath(".//*[@id='ContentPlaceHolder1_txtToDate']");
	public static By btnSearch = By.xpath(".//*[@id='ContentPlaceHolder1_btnSearch']");
	
	public static By btnFirstArrow = By.xpath(".//*[@id='ContentPlaceHolder1_txtlicense_CalendarExtender_prevArrow']");
	public static By btnDateAfterFirstArrow = By.xpath(".//*[@id='ContentPlaceHolder1_txtlicense_CalendarExtender_day_0_0']");
	public static By btnSecondArrow = By.xpath(".//*[@id='ContentPlaceHolder1_CalendarExtender1_nextArrow']");
	public static By btnDateAftersecondArrow = By.xpath(".//*[@id='ContentPlaceHolder1_CalendarExtender1_day_5_6']");
	
	public static By textUserName = By.xpath(".//*[@id='txtUserName']");
	public static By textPassword = By.xpath(".//*[@id='txtPassword']");
	public static By btnLoggin = By.xpath(".//*[@id='LoginImageButton']");
	
	public static By lblUnableLogged = By.xpath(".//*[@id='divLiteral']");
	
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnUserSession = By.xpath(".//*[@id='TreeScreent22']");
	public static By btnNext = By.xpath(".//*[@id='ContentPlaceHolder1_gridUserSession_imgPageNext']");
	
	public static int Row_count;
	public static int count;
	public static int loop;
	
	public static By grdUserName;
	public static By grdFullName;
	public static By grdBranch;
	public static By grdLogedStatus;
	//public static By grdStatus;
	public static By btnLogoutInGrid;
	
	String first_part = ".//*[@id='ContentPlaceHolder1_gridUserSession']/tbody/tr["; 
	String second_part = "]/td["; 
	String third_part = "]";
	
	String btnViewInGrid_FirstPart = ".//*[@id='ContentPlaceHolder1_gridUserSession_btnLogut_";
	String btnViewInGrid_SecondPart = "']";
	
	public void closeBrowser(){
		try{			
			driver.quit();			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void logged_using_same_user(String userName, String password){
		try{ 
			openPage(BASEURL);
			Thread.sleep(10000);
			clearAndType(textUserName, userName);
			clearAndType(textPassword, password);
			click(btnLoggin);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void same_user_unable_logged_message(String unableToLogMessage){
		readAndCompare(lblUnableLogged, unableToLogMessage);
		}
	
	public void click_Basic(){
		click(btnAdministration);
		click(btnUserSession);
	}
	
	public void enter_details_for_user_session(String businessEntity, String branch, String loginStatus, String userName){
		try{
		select(cmbBusinessEntity, businessEntity);
		select(cmbBranch, branch);
		select(cmbLoginStatus, loginStatus);
		clearAndType(txtUserName, userName);
		click(dtpFromDate);
		click(btnFirstArrow);
		click(btnDateAfterFirstArrow);
		click(dtpToDate);
		click(btnSecondArrow);
		click(btnDateAftersecondArrow);		
		click(btnSearch);
		Thread.sleep(500);
		Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gridUserSession']/tbody/tr")).size();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void Search_Grid_for_User_Name(String username,String fullName,String branch,String logoutStatus) throws Exception
	{
		if(Row_count<11)
		{
			SinglePageSearch(username, fullName, branch, logoutStatus);
		}
		else if(Row_count>10)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_User_Name(username, fullName, branch, logoutStatus);
		}
	}
	
	
	public void Calc_Label_Of_Value(){		//.//*[@id='ContentPlaceHolder1_gridUserSession_lblTotalPage']
		
		 String lblOfValue = driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_gridUserSession_lblTotalPage']")).getText();
		 System.out.println("############### size " + lblOfValue + "##################" );
		 String[] splited = lblOfValue.split(" ");
		 String maxGridSize = splited[1];
		 System.out.println("############### size " + maxGridSize + "##################" );
		 count = Integer.parseInt(maxGridSize);
			
		}
	
public void SinglePageSearch(String username,String fullName,String branch,String logoutStatus) throws Exception{		
		
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr")).size(); 
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
							grdFullName =By.xpath(Xpath_for_First_name);
							
							String Xpath_for_Last_name = first_part+i+second_part+3+third_part;
							grdBranch=By.xpath(Xpath_for_Last_name);
							
							String Xpath_for_Email = first_part+i+second_part+6+third_part;
							grdLogedStatus=By.xpath(Xpath_for_Email);
																				
							this.Verify_User_View_in_Grid(username, fullName, branch, logoutStatus);
							
							String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-2)+btnViewInGrid_SecondPart;
							btnLogoutInGrid = By.xpath(Xpath_for_btnView);
							click(btnLogoutInGrid);
							
							user_name_find = true;											
							return;
						}
										
					}
					
				}
				
		}
		
	
	
	public void Get_Values_According_To_User_Name(String userName, String fullName, String branch, String logoutStatus) throws Exception{
		System.out.println("################ Row count : " + Row_count + "#######################");					
		
		boolean user_name_find = false;
		
		for (int i=2; i<=Row_count; i++){
			for(int j=1; j<=1; j++){
				
				//Thread.sleep(1000);
				String xpath_for_User_name = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_User_name + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_User_name)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(userName)){
					
					System.out.println(" ################### username equals  #################");
					grdUserName = By.xpath(xpath_for_User_name);
					
					String Xpath_for_First_name = first_part+i+second_part+2+third_part;
					grdFullName =By.xpath(Xpath_for_First_name);
					
					String Xpath_for_Last_name = first_part+i+second_part+3+third_part;
					grdBranch=By.xpath(Xpath_for_Last_name);
					
					String Xpath_for_Email = first_part+i+second_part+6+third_part;
					grdLogedStatus=By.xpath(Xpath_for_Email);
																		
					this.Verify_User_View_in_Grid(userName, fullName, branch, logoutStatus);
					
					String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-2)+btnViewInGrid_SecondPart;
					btnLogoutInGrid = By.xpath(Xpath_for_btnView);
					click(btnLogoutInGrid);
					
					user_name_find = true;											
					return;
				}
								
			}
			
		}
		
		if((!user_name_find)&&(loop < count)){
			click(btnNext);
			loop++;
			//Thread.sleep(1000);
			System.out.println("#### Move to next Grid ######");
			Get_Values_According_To_User_Name(userName,fullName,branch,logoutStatus);
		}
		
	}
	
	
	public void Verify_User_View_in_Grid(String userName, String fullName, String branch, String logoutStatus) throws Exception{
		if(readAndCompare(grdUserName, userName) && readAndCompare(grdFullName,fullName) && readAndCompare(grdBranch,branch) && readAndCompare(grdLogedStatus,logoutStatus))
			return;
		else
			throw new Exception();
	}
	
	public static By lblSuccess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");


	public void User_Logout_Sucess_Message(String UserLoggedOutfromGridSucessMessage){
		readAndCompare(lblSuccess, UserLoggedOutfromGridSucessMessage);
		
	}
	
}
