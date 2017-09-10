package com.synapsys.lmt.pages;

import com.synapsys.lmt.lib.SeleniumBase;

import org.openqa.selenium.By;

public class LMTPartnerView extends SeleniumBase
{
	public static By btnBusinessEntity = By.xpath(".//*[@id='NavigationMenu']/ul/li[1]/a/span[2]/span");
	public static By btnPartnerView = By.xpath(".//*[@id='TreeScreent19']");
	public static By lblPages = By.xpath(".//*[@id='ContentPlaceHolder1_gdvexhouse_lblTotalPage']");
	public static By btnNextPage = By.xpath(".//*[@id='ContentPlaceHolder1_gdvexhouse_imgPageNext']");
	
	public static By grdCreatedDate;
	public static By grdPCode;
	public static By grdPName;
	public static By grdCountry;
	public static By grdStatus;
	public static By btnView;
	
	String first_part = ".//*[@id='ContentPlaceHolder1_gdvexhouse']/tbody/tr[";
	String second_part = "]/td[";
	String third_part = "]";
	
	String viewPart1 = ".//*[@id='ContentPlaceHolder1_gdvexhouse_btnedit_"; //.//*[@id='ContentPlaceHolder1_dtgRoles_lbnEdit_']
	String viewPart2 = "']";
	
	public static int count;
	public static int loop = 0;
	int Row_count;
	
	//tab 1
	public static By txtPartnerCode = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtexcode']");
	public static By cmbPartnerBankName = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_ddlBank']");
	public static By cmbCountry = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_ddlcountry']");
	public static By cmbRelatedDVBBranch = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_ddlperentbranch']");
	
	public static By tabContactDetails = By.xpath(".//*[@id='__tab_ContentPlaceHolder1_tabExHouse_contactTab']/span");
	public static By tabAdmiInfo = By.xpath(".//*[@id='__tab_ContentPlaceHolder1_tabExHouse_userTab']/span");
	public static By tabAccountTransaction = By.xpath(".//*[@id='__tab_ContentPlaceHolder1_tabExHouse_accountTab']/span");
	public static By tabHistory = By.xpath(".//*[@id='__tab_ContentPlaceHolder1_tabExHouse_historyTab']/span");
	
	public static By txtAddLine1 = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_contactTab_txtaddress1']");
	public static By txtStreet = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_contactTab_txtstreet']");
	public static By txtCity = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_contactTab_txtcity']");
	
	//Contact Person Grid
	String cp_first_part = ".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_gdvcontactperson']/tbody/tr[";
	String cp_second_part = "]/td[";
	String cp_third_part = "]";
		
	String cpViewPart1 = ".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_gdvcontactperson_btnedit_";
	String cpViewPart2 = "']";
		
	
	public static By grdContactName;
	public static By grdContactNo;
	public static By grdDesignation;
	public static By grdEmail;
	public static By grdWorkArea;
	
	public static By txtCName = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtcpname']");
	public static By txtCDesignation = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtcpdesignation']");
	public static By txtCNo = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtcpcontactnumber']");
	public static By txtCEmail = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtcpemail']");
	public static By txtWorkArea = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtjobfunction']");
	
	//registration grid
	String reg_first_part = ".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_gdvregistration']/tbody/tr[";
	String reg_second_part = "]/td[";
	String reg_third_part = "]";
	
	String regViewPart1 = ".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_gdvregistration_btnedit_";
	String regViewPart2 = "']";
	
	public static By txtRegType = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtbrntype']");
	public static By txtRegNumber = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtbrn']");
	public static By txtExpireDate = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtlicense']");
	
	public static By grdRegType;
	public static By grdRegNo;
	public static By grdRegExpire;
	
	//super admin
	String adminFirstPart1 = ".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_gdvadmin']/tbody/tr[";
	String adminFirstPart2 = "]/td[";
	String adminFirstPart3 = "]";
		
	String adminViewPart1 = ".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_gdvadmin_btnedit0_";
	String adminViewPart2 = "']";
		
	public static By grdUserName;
	public static By grdFirstName;
	public static By grdLastName;
	
	public static By txtPassportNo = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtpassportno']");
	public static By txtUserName = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtexusername']");
	public static By txtFirstName = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtfname']");
	public static By txtLastName = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtlname']");
	public static By txtInitial = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtnic']");
	public static By txtTelephone = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txttelmobile']");
	public static By txtEmail = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtemail']");
	public static By txtNationality = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtnationality']");
	
	public static By btnBack = By.xpath(".//*[@id='ContentPlaceHolder1_btnCancel']");
	
	public void clickBasic()
	{
		click(btnBusinessEntity);
		click(btnPartnerView);
		Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvexhouse']/tbody/tr")).size();
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
	
	public void Get_Values_According_To_Role_Name(String date, String code, String name, String country, String status) throws InterruptedException
	{	
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		boolean role_name_find = false;
		
		for (int i=2; i<=Row_count; i++){
			for(int j=1; j<=1; j++){
				
				//Thread.sleep(1000);
				String xpath_for_BE_Code = first_part+i+second_part+2+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_BE_Code + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_BE_Code)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(code)){
					
					System.out.println(" ################### username equals  #################");
					grdPCode = By.xpath(xpath_for_BE_Code);
					
					String Xpath_for_Date = first_part+i+second_part+1+third_part;
					grdCreatedDate =By.xpath(Xpath_for_Date);
					
					String Xpath_for_Name = first_part+i+second_part+3+third_part;
					grdPName =By.xpath(Xpath_for_Name);
					
					String Xpath_for_Country = first_part+i+second_part+4+third_part;
					grdCountry =By.xpath(Xpath_for_Country);
					
					String Xpath_for_Status = first_part+i+second_part+5+third_part;
					grdStatus =By.xpath(Xpath_for_Status);
					
					String xpath_for_View_Button = viewPart1+(i-2)+viewPart2;
					
					if(readAndCompare(grdCreatedDate, date) && readAndCompare(grdPName, name) && readAndCompare(grdPCode, code) && readAndCompare(grdCountry, country) && readAndCompare(grdStatus, status))
					{	
						btnView = By.xpath(xpath_for_View_Button);
						click(btnView);
					}
					
					role_name_find = true;											
					return;
				}	
			}
		}
				
		if((!role_name_find)&&(loop < count))
		{
			click(btnNextPage);
			loop++;
			System.out.println("#### Move to next Grid ######");
			Get_Values_According_To_Role_Name(date, code, name, country, status);
		}	
	}
	
	public void Single_Page_Search(String date, String code, String name, String country, String status)
	{
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		for (int i=2; i<=Row_count; i++)
		{
				
				//Thread.sleep(1000);
				String xpath_for_BE_Code = first_part+i+second_part+2+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_BE_Code + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_BE_Code)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(code)){
					
					System.out.println(" ################### username equals  #################");
					grdPCode = By.xpath(xpath_for_BE_Code);
					
					String Xpath_for_Date = first_part+i+second_part+1+third_part;
					grdCreatedDate =By.xpath(Xpath_for_Date);
					
					String Xpath_for_Name = first_part+i+second_part+3+third_part;
					grdPName =By.xpath(Xpath_for_Name);
					
					String Xpath_for_Country = first_part+i+second_part+4+third_part;
					grdCountry =By.xpath(Xpath_for_Country);
					
					String Xpath_for_Status = first_part+i+second_part+5+third_part;
					grdStatus =By.xpath(Xpath_for_Status);
					
					String xpath_for_View_Button = viewPart1+(i-2)+viewPart2;
					
					if(readAndCompare(grdCreatedDate, date) && readAndCompare(grdPName, name) && readAndCompare(grdPCode, code) && readAndCompare(grdCountry, country) && readAndCompare(grdStatus, status))
					{	
						btnView = By.xpath(xpath_for_View_Button);
						click(btnView);
					}										
					return;
				}	
		}
	}
	
	public void Search_Grid_for_Partner_Code(String date, String code, String name, String country, String status) throws InterruptedException
	{
		if(Row_count<10)
		{
			Single_Page_Search(date, code, name, country, status);
		}
		else if(Row_count>11)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_Role_Name(date, code, name, country, status);
		}
	}
	
	public void Single_Page_Search_Contact_Person(String name, String designation, String contactNo, String Email, String workArea)
	{
		int Row_Count_ContactPerson = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_gdvcontactperson']/tbody/tr")).size();
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		for (int i=2; i<=Row_Count_ContactPerson; i++)
		{
				
				//Thread.sleep(1000);
				String xpath_for_Contact_Name = cp_first_part+i+cp_second_part+1+cp_third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_Contact_Name + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_Contact_Name)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(name)){
					
					System.out.println(" ################### username equals  #################");
					grdContactName = By.xpath(xpath_for_Contact_Name);
					
					String Xpath_for_CNo = cp_first_part+i+cp_second_part+3+cp_third_part; 
					grdContactNo =By.xpath(Xpath_for_CNo);
					
					String Xpath_for_Designation = first_part+i+second_part+2+third_part;
					grdDesignation =By.xpath(Xpath_for_Designation);
					
					String Xpath_for_Email = cp_first_part+i+cp_second_part+4+cp_third_part;
					grdEmail =By.xpath(Xpath_for_Email);
					
					String Xpath_for_WorkArea = cp_first_part+i+cp_second_part+5+cp_third_part;
					grdWorkArea =By.xpath(Xpath_for_WorkArea);
					
					String xpath_for_View_Button = cpViewPart1+(i-2)+cpViewPart2;
					
					if(readAndCompare(grdContactName, name) && readAndCompare(grdDesignation, designation) && readAndCompare(grdContactNo, contactNo) && readAndCompare(grdEmail, Email) && readAndCompare(grdWorkArea, workArea))
					{	
						btnView = By.xpath(xpath_for_View_Button);
						click(btnView);
					}										
					return;
				}	
		}
	}
	
	public void validatePartnerInfo(String PartnerCode, String PartnerBName, String PartnerCountry, String name, String designation, String contactNo, String Email, String workArea)
	{
		if (readAndCompareByValue(txtPartnerCode, PartnerCode) && readAndCompareByValue(cmbPartnerBankName, PartnerBName) &&readAndCompareByValue(cmbCountry, PartnerCountry))
		{
			Single_Page_Search_Contact_Person(name, designation, contactNo, Email, workArea);
			if(readAndCompareByValue(txtCName, name) && readAndCompareByValue(txtCDesignation, designation) && readAndCompareByValue(txtCNo, contactNo) && readAndCompareByValue(txtCEmail, Email) && readAndCompareByValue(txtWorkArea, workArea))
			{
				click(tabContactDetails);
			}
		}
	}
	
	public void validateContactInfo(String addl1, String street, String city)
	{
		if(readAndCompareByValue(txtAddLine1, addl1) && readAndCompareByValue(txtStreet, street) && readAndCompareByValue(txtCity, city))
		{
			click(tabAdmiInfo);
		}
	}
	
	public void Single_Page_Search_Registration(String type, String regNo, String expire, String lexpire)
	{
		int Row_Count_Registration = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_gdvregistration']/tbody/tr")).size();
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		for (int i=2; i<=Row_Count_Registration; i++)
		{
				
				//Thread.sleep(1000);
				String xpath_for_regNo = reg_first_part+i+reg_second_part+2+reg_third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_regNo + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_regNo)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(regNo)){
					
					System.out.println(" ################### username equals  #################");
					grdRegNo = By.xpath(xpath_for_regNo);
					
					String Xpath_for_Type = reg_first_part+i+reg_second_part+1+reg_third_part; 
					grdRegType =By.xpath(Xpath_for_Type);
					
					String Xpath_for_Expire = reg_first_part+i+reg_second_part+3+reg_third_part;
					grdRegExpire =By.xpath(Xpath_for_Expire);
					
					String xpath_for_View_Button = regViewPart1+(i-2)+regViewPart2;
					
					if(readAndCompare(grdRegType, type) && readAndCompare(grdRegNo, regNo) && readAndCompare(grdRegExpire, expire))
					{	
						btnView = By.xpath(xpath_for_View_Button);
						click(btnView);
					}										
					return;
				}	
		}
	}
	
	public void validateRegistrationInfo(String type, String regNo, String expire, String lexpire)throws Exception
	{
		Single_Page_Search_Registration(type, regNo, expire, lexpire);
		if(readAndCompareByValue(txtRegType, type) && readAndCompareByValue(txtRegNumber, regNo) && readAndCompareByValue(txtExpireDate, lexpire))
		{
			return;
		}
		else
			throw new Exception();
	}
	
	public void Single_Page_Search_Admin(String userName, String fName, String lName)
	{
		int Row_Count_Registration = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_gdvadmin']/tbody/tr")).size();
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		for (int i=2; i<=Row_Count_Registration; i++)
		{
				
				//Thread.sleep(1000);
				String xpath_for_userName = adminFirstPart1+i+adminFirstPart2+1+adminFirstPart3; 
				
				System.out.println("####################  username  xpath:" + xpath_for_userName + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_userName)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(userName)){
					
					System.out.println(" ################### username equals  #################");
					grdUserName = By.xpath(xpath_for_userName);
					
					String Xpath_for_FirstName = adminFirstPart1+i+adminFirstPart2+2+adminFirstPart3; 
					grdFirstName =By.xpath(Xpath_for_FirstName);
					
					String Xpath_for_LastName = adminFirstPart1+i+adminFirstPart2+3+adminFirstPart3;
					grdLastName =By.xpath(Xpath_for_LastName);
					
					String xpath_for_View_Button = adminViewPart1+(i-2)+adminViewPart2;
					
					if(readAndCompare(grdUserName, userName) && readAndCompare(grdFirstName, fName) && readAndCompare(grdLastName, lName))
					{	
						btnView = By.xpath(xpath_for_View_Button);
						click(btnView);
					}										
					return;
				}	
		}
	}
	
	public void validateAdminInfo(String userName, String fName, String lName, String passport, String initial, String id, String telephone, String email, String nationality)throws Exception
	{
			Single_Page_Search_Admin(userName, fName, lName);
			if(readAndCompareByValue(txtPassportNo, passport) && readAndCompareByValue(txtUserName, userName) && readAndCompareByValue(txtFirstName, fName) && readAndCompareByValue(txtLastName, lName))
			{
				click(tabAccountTransaction);
				click(tabHistory);
				click(btnBack);
			}
			else 
				throw new Exception();
	}
	
}
