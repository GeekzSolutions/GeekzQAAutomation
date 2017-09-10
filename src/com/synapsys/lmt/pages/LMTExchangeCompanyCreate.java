package com.synapsys.lmt.pages;

import com.synapsys.lmt.lib.SeleniumBase;
import org.openqa.selenium.By;


public class LMTExchangeCompanyCreate extends SeleniumBase
{
	public static By btnBusinessEntity = By.xpath(".//*[@id='NavigationMenu']/ul/li[1]/a/span[2]/span");
	public static By btnECCreate = By.xpath(".//*[@id='TreeScreent9']");
	
	public static By txtECName = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtexhousename']");
	public static By cmbCountry = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_ddlcountry']");
	public static By txtContactPersonName = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtcpname']");
	public static By txtContactPersonNumber = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtcpcontactnumber']");
	public static By txtWorkArea = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtjobfunction']");
	public static By txtDesignation = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtcpdesignation']");
	public static By txtEmail = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_txtcpemail']");
	public static By btnContactPersonAdd = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_generalTab_btnaddcontactperson']");
	
	public static By tabContactDetails = By.xpath(".//*[@id='__tab_ContentPlaceHolder1_tabExHouse_contactTab']/span");
	
	public static By txtAddressl1 = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_contactTab_txtaddress1']");
	public static By txtAddressl2 = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_contactTab_txtaddress2']");
	public static By txtCity = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_contactTab_txtcity']");
	public static By cmbContactType = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_contactTab_ddlcontactType']");
	public static By txtContactDetail = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_contactTab_txtcontactdetail']");
	public static By btnAddContactDetails = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_contactTab_btnaddcontact']");
	
	public static By tabAdminInfo = By.xpath(".//*[@id='__tab_ContentPlaceHolder1_tabExHouse_userTab']/span");
	
	public static By txtRegType = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtbrntype']");
	public static By txtRegNo = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtbrn']");
	public static By txtLExpire = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtlicense']");
	public static By btnAddRegInfo = By.xpath("//.//*[@id='ContentPlaceHolder1_tabExHouse_userTab_btnregistration']");
	//.//*[@id='ContentPlaceHolder1_tabExHouse_userTab_btnregistration']
	
	public static By txtPassNo = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtpassportno']");
	public static By txtUserName = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtexusername']");
	public static By txtFName = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtfname']");
	public static By txtLName = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtlname']");
	public static By txtInitials = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtinitials']");
	public static By txtGlobalID = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtnic']");
	public static By txtTelephoneNo = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txttelmobile']");
	public static By txtAdminEmail = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtemail']");
	public static By txtNationality = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_txtnationality']");
	public static By btnAddAdmin = By.xpath(".//*[@id='ContentPlaceHolder1_tabExHouse_userTab_btnadminregistration']");
	
	public static By btnSave = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By btnCancel = By.xpath(".//*[@id='ContentPlaceHolder1_btnCancel']");
	
	public static By lblDuplicate = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblerror']");
	public static By lblSuccess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	
	
	public void clickBasic()
	{
		click(btnBusinessEntity);
		click(btnECCreate);
	}
	
	public void generalInfo(String ECName, String Country, String CPName, String ContactNo, String WorkArea, String Designation, String Email)throws Exception
	{
		clearAndType(txtECName, ECName);
		select(cmbCountry, Country);
		clearAndType(txtContactPersonName, CPName);
		clearAndType(txtContactPersonNumber, ContactNo);
		clearAndType(txtWorkArea, WorkArea);
		clearAndType(txtDesignation, Designation);
		clearAndType(txtEmail, Email);
		click(btnContactPersonAdd);
		click(tabContactDetails);
	}
	
	public void contactDetails(String addl1, String addl2, String city, String contactNo, String contactType)throws Exception
	{
		clearAndType(txtAddressl1, addl1);
		clearAndType(txtAddressl2, addl2);
		clearAndType(txtCity, city);
		select(cmbContactType, contactType);
		clearAndType(txtContactDetail, contactNo);
		click(btnAddContactDetails);
		click(tabAdminInfo);
	}
	
	public void adminInfo(String regType, String regNo, String licenseExpire, String passport, String userName, String fName, String lName, String initials, String id, String tNo, String email, String nationality)throws Exception
	{
		clearAndType(txtRegType, regType);
		clearAndType(txtRegNo, regNo);
		clearAndType(txtLExpire, licenseExpire);
		Thread.sleep(3000);
		clearAndType(txtPassNo, passport);
		clearAndType(txtUserName, userName);
		clearAndType(txtFName, fName);
		clearAndType(txtLName, lName);
		clearAndType(txtInitials, initials);
		clearAndType(txtGlobalID, id);
		clearAndType(txtTelephoneNo, tNo);
		clearAndType(txtAdminEmail, email);
		clearAndType(txtNationality, nationality);
		click(btnAddAdmin);
		click(btnAddRegInfo);
	}
	
	public void validateCreate(String successMessage)throws Exception
	{
		click(btnSave);
		if(readAndCompare(lblSuccess, successMessage))
		{
			return;
		}
		else
			throw new Exception();
	}

}
