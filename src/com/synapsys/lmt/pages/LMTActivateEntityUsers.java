package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTActivateEntityUsers extends SeleniumBase{

	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnUserMaintaince = By.xpath(".//*[@id='TreeScreent23']");
	public static By lblof = By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers_lblTotalPage']");		
	public static By btnNext = By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers_imgPageNext']");
	public static By grdUserName;
	public static By grdFirstName;
	public static By grdLastName;
	public static By grdPassportNo;
	public static By grdEmail;
	public static By btnActiveInGrid;
	
	String first_part = "//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr["; 
	String second_part = "]/td["; 
	String third_part = "]";
	
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
	
	
	public void SinglePageSearch(String username,String firstName,String lastName,String passportNo,String email) throws Exception{			
		
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
					
					String Xpath_for_Passport_No = first_part+i+second_part+3+third_part;
					grdPassportNo=By.xpath(Xpath_for_Passport_No);
						
					String Xpath_for_Email = first_part+i+second_part+3+third_part;
					grdEmail=By.xpath(Xpath_for_Email);
														
					this.Verify_User_View_in_Grid(username, firstName, lastName, passportNo, email);
												
					String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-2)+btnViewInGrid_SecondPart;
					btnActiveInGrid = By.xpath(Xpath_for_btnView);
					click(btnActiveInGrid);
					
					user_name_find = true;											
					return;
				}
								
			}
			
		}
	}
	
	public void Search_Grid_for_User_Name(String username,String firstName,String lastName,String passportNo,String email) throws Exception
	{
		if(Row_count<11)
		{
			SinglePageSearch(username, firstName, lastName,passportNo,email);
		}
		else if(Row_count>10)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_User_Name(username, firstName, lastName, passportNo, email);
		}
	}
	
	public void Get_Values_According_To_User_Name(String username,String firstName,String lastName,String passportNo,String email) throws Exception{		
		
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
									
					String Xpath_for_Passport_No = first_part+i+second_part+4+third_part;
					grdPassportNo=By.xpath(Xpath_for_Passport_No);
						
					String Xpath_for_Email = first_part+i+second_part+5+third_part;
					grdEmail=By.xpath(Xpath_for_Email);
					
					this.Verify_User_View_in_Grid(username, firstName, lastName, passportNo, email);
					
					String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-2)+btnViewInGrid_SecondPart;
					btnActiveInGrid = By.xpath(Xpath_for_btnView);
					click(btnActiveInGrid);
					
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
			Get_Values_According_To_User_Name(username,firstName,lastName,passportNo,email);
		}
		

	}

	public void Verify_User_View_in_Grid(String userName,String firstName, String lastName, String passportNo, String email ) throws Exception{
		if(readAndCompare(grdUserName, userName) && readAndCompare(grdFirstName,firstName) && readAndCompare(grdLastName,lastName) && readAndCompare(grdPassportNo,passportNo) && readAndCompare(grdEmail,email) )
			return;
		else
			throw new Exception();
	}
	
	public static By lblUserName = By.xpath(".//*[@id='ContentPlaceHolder1_txtUsername']");
	public static By txtFirstName = By.xpath(".//*[@id='ContentPlaceHolder1_txtFname']");
	public static By txtLastName = By.xpath(".//*[@id='ContentPlaceHolder1_txtLname']");
	public static By txtInitials = By.xpath(".//*[@id='ContentPlaceHolder1_txtInitials']");
	public static By txtEmployeeNo = By.xpath(".//*[@id='ContentPlaceHolder1_txtEmpNo']");
	public static By txtExchangeCompany = By.xpath(".//*[@id='ContentPlaceHolder1_txtExchangeCompanyName']");
	public static By txtPassportNo = By.xpath(".//*[@id='ContentPlaceHolder1_txtNIC']");
	public static By txtEmail = By.xpath(".//*[@id='ContentPlaceHolder1_txtEmail']");
	public static By btnActivate = By.xpath(".//*[@id='ContentPlaceHolder1_btnactive']");
	
	public void User_View_After_Grid(String userName, String firstName, String lastName, String intials, String empNo, String ExchangeCompany, String email, String passport)throws Exception{
		if(readAndCompareByValue(lblUserName, userName) && (readAndCompareByValue(txtFirstName, firstName)) && (readAndCompareByValue(txtLastName, lastName)) && (readAndCompareByValue(txtInitials, intials)) && (readAndCompareByValue(txtEmployeeNo, empNo)) && (readAndCompareByValue(txtExchangeCompany, ExchangeCompany)) && (readAndCompareByValue(txtEmail, email)) && (readAndCompareByValue(txtPassportNo, passport))){
			click(btnActivate);
			return ;
		}
		else 
			throw new Exception();
		
	}
	
	public static By lblEntityActivatedSucessMessage = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	public static By btnBack = By.xpath(".//*[@id='ContentPlaceHolder1_btncancel']");
	
	public void Entity_Activated_Sucess_Message(String EntityActivatedSucessMessage){
		readAndCompare(lblEntityActivatedSucessMessage, EntityActivatedSucessMessage);
		click(btnBack); 
	}
	
	
}
