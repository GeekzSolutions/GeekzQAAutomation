package com.synapsys.lmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synapsys.lmt.lib.SeleniumBase;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.webdriven.commands.SelectOption;

public class LMTUserCreationPage extends SeleniumBase{

	//public static String USER_CREATION_URL ;
	public static By btnAdministartion = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnUserCreation = By.xpath(".//*[@id='TreeScreent15']");
	public static By textUserName1 = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_UserName']");
	public static By textFirst_Name1 = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtFname']");
	public static By textLast_Name1 = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtLname']");
	public static By textInitials = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtInitials']");
	public static By textEmployee_No = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtEmpNo']");
	public static By textIdentification = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtNIC']");
	public static By textNationality = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtnationality']");
	public static By cmbEntity = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_ddlGroup']");
	public static By cmbBranch = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_ddlBranchs']");
	public static By textAddress = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtAddress']");
	public static By textE_mail = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_Email']");
	public static By textContact_No = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtTelephone']");
	public static By textMobile = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtMobile']");
	public static By textPassport_No = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_txtPassport']");
	public static By cmbDesignation = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_ddlDesignation']");
	public static By btnSave = By.xpath(".//*[@id='ContentPlaceHolder1_TabContainerUser_TabPanelUserDetails_btnSave']");
	
	
	
	public void CreateLMTUser(String userName1,String firstName1,String last_Name1,String initials,String empNo,String identification,String 
			nationality,String entity,String branch, String address,String email,String contactNo,String mobile,String passport,String designation ){
		try{
	
	   // driver.get(USER_CREATION_URL);
		//Thread.sleep(1000);
			click(btnAdministartion);
			click(btnUserCreation);
		clearAndType(textUserName1, userName1);
		clearAndType(textFirst_Name1, firstName1);
		clearAndType(textLast_Name1, last_Name1);
		clearAndType(textInitials, initials);
		clearAndType(textEmployee_No, empNo);
		clearAndType(textIdentification, identification);
		clearAndType(textNationality, nationality);
		//clearAndType(driver, cmbEntity, entity);
		select(cmbEntity, entity);
		//clearAndType(driver, cmbBranch, branch);
		select(cmbBranch, branch);
		clearAndType(textAddress, address);
		clearAndType(textE_mail, email);
		clearAndType(textContact_No, contactNo);
		clearAndType(textMobile, mobile);
		clearAndType(textPassport_No, passport);
		//clearAndType(driver, cmbDesignation, designation);
		select(cmbDesignation, designation);
		click(btnSave);
		Thread.sleep(20000);
	}

catch(Exception ex){
	System.out.println(ex.getMessage());			
}
	
}
//public static By lblUserCreationSuccess= By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']/text()");
//public static By lblUserCreationSuccess= By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_sucmsg']");
//public static By lblUserCreationSuccess= By.cssSelector("#flash flash-success");

 public static By lblUserCreationSuccess= By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
 //public static By lblUserCreationSuccess= By.id(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
 //public static By lblUserCreationSuccess= By.cssSelector("#ContentPlaceHolder1_Notification1_lblsuccess");
//.//*[@id='ContentPlaceHolder1_Notification1_sucmsg']
//.//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']

public void Is_User_Register_Sucees(String RegisterdMessage) throws Exception{
	if(readAndCompare(lblUserCreationSuccess, RegisterdMessage))
	return;
	else throw new Exception();
}
	

}
