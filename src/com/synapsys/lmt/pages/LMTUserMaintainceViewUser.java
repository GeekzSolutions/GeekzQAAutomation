package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTUserMaintainceViewUser extends SeleniumBase{
	
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnUserMaintaince = By.xpath(".//*[@id='TreeScreent20']");
	public static By lblof = By.xpath(".//*[@id='ContentPlaceHolder1_dtgSearchUser_lblTotalPage']");		
	public static By btnNext = By.xpath(".//*[@id='ContentPlaceHolder1_dtgSearchUser_imgPageNext']");
	public static By grdUserName;
	public static By grdFirstName;
	public static By grdLastName;
	public static By btnViewUserInGrid;
	
	String first_part = "//*[@id='ContentPlaceHolder1_dtgSearchUser']/tbody/tr["; 
	String second_part = "]/td["; 
	String third_part = "]";
	
	//.//*[@id='ContentPlaceHolder1_dtgSearchUser_btnAssignRole_0']
	String btnViewInGrid_FirstPart = ".//*[@id='ContentPlaceHolder1_dtgSearchUser_btnViewUser_";
	String btnViewInGrid_SecondPart = "']";
	
	public static int count;
	public static int loop = 0;
	public static int Row_count;


public void click_Basic(){
	click(btnAdministration);
	click(btnUserMaintaince);		
	Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgSearchUser']/tbody/tr")).size();
}

public void Calc_Label_Of_Value(){		
	
	//.//*[@id='ContentPlaceHolder1_dtgSearchUser_lblTotalPage']
	 String lblOfValue = driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_dtgSearchUser_lblTotalPage']")).getText();
	 System.out.println("############### size " + lblOfValue + "##################" );
	 String[] splited = lblOfValue.split(" ");
	 String maxGridSize = splited[1];
	 System.out.println("############### size " + maxGridSize + "##################" );
	 count = Integer.parseInt(maxGridSize);			
	}

public void SinglePageSearch(String username,String firstName,String lastName) throws Exception{			
	
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
				
				String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-2)+btnViewInGrid_SecondPart;
				btnViewUserInGrid = By.xpath(Xpath_for_btnView);
				click(btnViewUserInGrid);
				
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
				
				String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-1)+btnViewInGrid_SecondPart;
				btnViewUserInGrid = By.xpath(Xpath_for_btnView);
				click(btnViewUserInGrid);
				
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

public static By lblUserName = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_lbluserName']");
public static By txtFirstName = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtFname']");
public static By txtLastName = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtLname']");
public static By txtInitials = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtInitials']");
public static By txtEmployeeNo = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtEmpNo']");
public static By txtIdentification = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtNIC']");
public static By txtNationality = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtnationality']");
public static By cmbEntity = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_ddlGroup']/option[@selected='selected']");
//public static By cmbEntity = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_ddlGroup/option[1]/@value']");  
public static By cmbBranch = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_ddlBranchs']/option[@selected='selected']");

//.//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_ddlGroup']/option[1]/@value

public static By txtAddress = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtAddress']");
public static By txtEmail = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_Email']");
public static By txtContactNo = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtTelephone']");
public static By txtMobile = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtMobile']");
public static By txtPassportNo = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtPassport']");
public static By cmbDesignation = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_ddlDesignation']/option[@selected='selected']");
public static By btnBack = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_btnBack']");

public void User_View_After_Grid(String userName, String firstName, String lastName, String intials, String empNo, String Identification, String nationality, String entity, String branch, String address, String email, String contNo, String mobile, String passport, String designation)throws Exception{
	if(readAndCompare(lblUserName, userName) && (readAndCompareByValue(txtFirstName, firstName)) && (readAndCompareByValue(txtLastName, lastName)) && (readAndCompareByValue(txtInitials, intials)) && (readAndCompareByValue(txtEmployeeNo, empNo)) && (readAndCompareByValue(txtIdentification, Identification)) && (readAndCompareByValue(txtNationality, nationality)) && (readAndCompare(cmbEntity,entity)) && (readAndCompare(cmbBranch, branch)) && (readAndCompareByValue(txtAddress, address)) && (readAndCompareByValue(txtEmail, email)) && (readAndCompareByValue(txtContactNo, contNo)) && (readAndCompareByValue(txtMobile, mobile)) && (readAndCompareByValue(txtPassportNo, passport)) && (readAndCompare(cmbDesignation, designation))){
		click(btnBack);
		return ;
	}
	else 
		throw new Exception();
	
}


}

