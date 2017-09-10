package com.synapsys.lmt.pages;

import org.openqa.selenium.By;
import com.synapsys.lmt.lib.SeleniumBase;

public class LMTUserViewAfterGrid extends SeleniumBase{
	
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By lblof = By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers_lblTotalPage']");

	public static By btnUserView = By.xpath(".//*[@id='TreeScreent14']");	
	public static By btnNext = By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers_imgPageNext']");
	public static By grdUserName;
	public static By grdFirstName;
	public static By grdLastName;
	public static By grdEmail;
	public static By grdStatus;
	public static By btnView;
		
	String first_part = "//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr["; 
	String second_part = "]/td["; 
	String third_part = "]";
	
	String btnViewInGrid_FirstPart = ".//*[@id='ContentPlaceHolder1_gdvusers_btnedit_";
	String btnViewInGrid_SecondPart = "']";
	
	public static int count;
	public static int loop = 0;
	public static int Row_count;
	
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
	
	public void click_Basic(){
		//String entity = driver.findElement(cmbEntity).getText();
		//System.out.println("######################" + entity + "#####################");
		click(btnAdministration);
		click(btnUserView);
		Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr")).size(); 
	}
	
	
	public void Calc_Label_Of_Value(){		
		
		 String lblOfValue = driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers_lblTotalPage']")).getText();
		 System.out.println("############### size " + lblOfValue + "##################" );
		 String[] splited = lblOfValue.split(" ");
		 String maxGridSize = splited[1];
		 System.out.println("############### size " + maxGridSize + "##################" );
		 count = Integer.parseInt(maxGridSize);
			
		}
	
	public void Search_Grid_for_User_Name(String username) throws Exception
	{
		if(Row_count<11)
		{
			SinglePageSearch(username);
		}
		else if(Row_count>10)
		{
			Calc_Label_Of_Value();
			Get_User_View_According_To_User_Name(username);
		}
	}
	
public void SinglePageSearch(String username) throws InterruptedException{				
		
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr")).size(); 
	//	System.out.println("################ Row count : " + Row_count + "#######################");				
		
		boolean user_name_find = false;
		
		for (int i=2; i<=Row_count; i++){
			for(int j=1; j<=1; j++){
				
				//Thread.sleep(1000);
				String xpath_for_User_name = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_User_name + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_User_name)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(username)){
													
					String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-2)+btnViewInGrid_SecondPart;
					btnView = By.xpath(Xpath_for_btnView);
					click(btnView);
					user_name_find = true;											
					return;
				}
				
				
			}
			
		}
}
	
public void Get_User_View_According_To_User_Name(String username) throws InterruptedException{				
		
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr")).size(); 
	//	System.out.println("################ Row count : " + Row_count + "#######################");				
		
		boolean user_name_find = false;
		
		for (int i=2; i<=Row_count; i++){
			for(int j=1; j<=1; j++){
				
				//Thread.sleep(1000);
				String xpath_for_User_name = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_User_name + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_User_name)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(username)){
													
					String Xpath_for_btnView = btnViewInGrid_FirstPart+(i-2)+btnViewInGrid_SecondPart;
					btnView = By.xpath(Xpath_for_btnView);
					click(btnView);
					user_name_find = true;											
					return;
				}
				
				
			}
			
		}
		
		if((!user_name_find)&&(loop < count)){
			click(btnNext);
			loop++;
			
			System.out.println("#### Move to next Grid ######");
			Get_User_View_According_To_User_Name(username);
		}		
	
	}	

public void User_View_After_Grid(String userName, String firstName, String lastName, String intials, String empNo, String Identification, String nationality, String entity, String branch, String address, String email, String contNo, String mobile, String passport, String designation)throws Exception{
	if(readAndCompare(lblUserName, userName) && (readAndCompareByValue(txtFirstName, firstName)) && (readAndCompareByValue(txtLastName, lastName)) && (readAndCompareByValue(txtInitials, intials)) && (readAndCompareByValue(txtEmployeeNo, empNo)) && (readAndCompareByValue(txtIdentification, Identification)) && (readAndCompareByValue(txtNationality, nationality)) && (readAndCompare(cmbEntity,entity)) && (readAndCompare(cmbBranch, branch)) && (readAndCompareByValue(txtAddress, address)) && (readAndCompareByValue(txtEmail, email)) && (readAndCompareByValue(txtContactNo, contNo)) && (readAndCompareByValue(txtMobile, mobile)) && (readAndCompareByValue(txtPassportNo, passport)) && (readAndCompare(cmbDesignation, designation))){
		click(btnBack);
		return ;
	}
	else 
		throw new Exception();
	
}

}
