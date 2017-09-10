package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTUserEdit extends SeleniumBase{
	
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnUserEdit= By.xpath(".//*[@id='TreeScreent17']");	
	public static By btnNext = By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers_imgPageNext']");
	public static By grdUserName;
	public static By grdFirstName;
	public static By grdLastName;
	public static By grdEmail;
	public static By grdStatus;
	public static By btnEditInGrid;
	
	public static int count;
	public static int loop = 0;
	public static int Row_count;
	
	public void click_Basic(){			
		click(btnAdministration);
		click(btnUserEdit);
		 Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr")).size(); 
	}
	
	public void Search_Grid_for_User_Name(String username,String firstName,String lastName,String email, String status) throws Exception
	{
		if(Row_count<11)
		{
			SinglePageSearch(username, firstName, lastName, email, status);
		}
		else if(Row_count>10)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_User_Name(username, firstName, lastName, email, status);
		}
	}
	
	
	public void Calc_Label_Of_Value(){		
		
		 String lblOfValue = driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers_lblTotalPage']")).getText();
		 System.out.println("############### size " + lblOfValue + "##################" );
		 String[] splited = lblOfValue.split(" ");
		 String maxGridSize = splited[1];
		 System.out.println("############### size " + maxGridSize + "##################" );
		 count = Integer.parseInt(maxGridSize);			
		}
	
	String first_part = ".//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr["; 
	String second_part = "]/td["; 
	String third_part = "]";
	
	String btnViewInGrid_FirstPart = ".//*[@id='ContentPlaceHolder1_gdvusers_btnedit_";
	String btnViewInGrid_SecondPart = "']";
	
public void SinglePageSearch(String username,String firstName,String lastName,String email, String status) throws Exception{
		
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
					grdFirstName =By.xpath(Xpath_for_First_name);
					
					String Xpath_for_Last_name = first_part+i+second_part+3+third_part;
					grdLastName=By.xpath(Xpath_for_Last_name);
					
					String Xpath_for_Email = first_part+i+second_part+4+third_part;
					grdEmail=By.xpath(Xpath_for_Email);
					
					String Xpath_for_Status = first_part+i+second_part+5+third_part;
					grdStatus=By.xpath(Xpath_for_Status);
					
					this.Verify_User_View_in_Grid(username, firstName, lastName, email, status);
					
					String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-2)+btnViewInGrid_SecondPart;
					btnEditInGrid = By.xpath(Xpath_for_btnView);
					click(btnEditInGrid);
					
					user_name_find = true;											
					return;
				}
								
			}
			
		}
}
	
public void Get_Values_According_To_User_Name(String username,String firstName,String lastName,String email, String status) throws Exception{
		
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
					grdFirstName =By.xpath(Xpath_for_First_name);
					
					String Xpath_for_Last_name = first_part+i+second_part+3+third_part;
					grdLastName=By.xpath(Xpath_for_Last_name);
					
					String Xpath_for_Email = first_part+i+second_part+4+third_part;
					grdEmail=By.xpath(Xpath_for_Email);
					
					String Xpath_for_Status = first_part+i+second_part+5+third_part;
					grdStatus=By.xpath(Xpath_for_Status);
					
					this.Verify_User_View_in_Grid(username, firstName, lastName, email, status);
					
					String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-2)+btnViewInGrid_SecondPart;
					btnEditInGrid = By.xpath(Xpath_for_btnView);
					click(btnEditInGrid);
					
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
			Get_Values_According_To_User_Name(username,firstName,lastName,email,status);
		}
			
	}
	

public void Verify_User_View_in_Grid(String userName,String firstName, String lastName, String email, String status) throws Exception{
	if(readAndCompare(grdUserName, userName) && readAndCompare(grdFirstName,firstName) && readAndCompare(grdLastName,lastName) && readAndCompare(grdEmail,email) && readAndCompare(grdStatus,status))
		return;
	else
		throw new Exception();
}

public static By lblUserName = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_lbluserName']");
public static By txtFirstName = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtFname']");
public static By txtLastName = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtLname']");
public static By txtInitials = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtInitials']");
public static By txtEmployeeNo = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtEmpNo']");
public static By txtIdentification = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtNIC']");
public static By txtNationality = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtnationality']");
public static By cmbEntity = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_ddlGroup']");
public static By cmbBranch = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_ddlBranchs']");
public static By txtAddress = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtAddress']");
public static By txtEmail = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_Email']");
public static By txtContactNo = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtTelephone']");
public static By txtMobile = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtMobile']");
public static By txtPassportNo = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtPassport']");
public static By cmbDesignation = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_ddlDesignation']");
public static By btnApprove = By.xpath("//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_btnSave']");
public static By btnBack = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_btnBack']");

public void UpdateLMTUser(String firstName1,String last_Name1,String initials,String empNo,String identification,String 
		nationality,String entity,String branch, String address,String email,String contactNo,String mobile,String passport,String designation ){
	try{

   	clearAndType(txtFirstName, firstName1);
	clearAndType(txtLastName, last_Name1);
	clearAndType(txtInitials, initials);
	clearAndType(txtEmployeeNo, empNo);
	clearAndType(txtIdentification, identification);
	clearAndType(txtNationality, nationality);	
	select(cmbEntity, entity);	
	select(cmbBranch, branch);
	clearAndType(txtAddress, address);
	clearAndType(txtEmail, email);
	clearAndType(txtContactNo, contactNo);
	clearAndType(txtMobile, mobile);
	clearAndType(txtPassportNo, passport);	
	select(cmbDesignation, designation);
	click(btnApprove);
	Thread.sleep(20000);
}

catch(Exception ex){
System.out.println(ex.getMessage());			
}
}

public static By lblSuccessUpdate = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");

public void User_Authorized_Sucess_Message(String UserUpdatedSucessMessage){
	readAndCompare(lblSuccessUpdate, UserUpdatedSucessMessage);
	click(btnBack);
}
}
