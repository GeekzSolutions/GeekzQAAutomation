package com.synapsys.lmt.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	  protected static int TIME_OUT;
	    protected static String BROWSER_TYPE;
	    protected static String IE_BIT_VERSION;
	    
	    protected static String BASEURL ;
	    protected static Properties baseProperties;
	    protected static String USER_NAME;
	    protected static String PASSWORD ;
	    protected static String FULL_NAME ;
	    protected static String BRANCH ;
	    protected static WebDriver driver;
	    protected static String ADMIN_USER_NAME;
	    protected static String ADMIN_PASSWORD;
	    protected static String ADMIN_BRANCH;
	    protected static String ADMIN_FULLNAME;
	    protected static String USER_CREATION_URL;
	    protected static String USER_CREATION_SUCESS_MESSAGE;
	    protected static String PASSWORD_CHANGE_MESSAGE;
	    protected static String RoleSucessfullyCreatedMessage;
	    protected static String ROlE_DUPLICATE_MESSAGE;
	    protected static String ROLE_AUTHORIZE_SUCCESS_MESSAGE;
	    protected static String ROLE_UPDATE_SUCCESS_MESSAGE;
	    protected static String ROLE_INACTIVE_SUCCESS_MESSAGE;
	    protected static String ROLE_REACTIVE_SUCCESS_MESSAGE;
	    protected static String SYSTEM_PARAMETER_ADD_SUCCESS_MESSAGE;
	    protected static String SYSTEM_PARAMETER_DUPLICATE_MESSAGE;
	    protected static String DESIGNATION_CREATION_SUCCESS_MESSAGE;
	    protected static String DESIGNATION_DUPLICATION_MESSAGE;
	    protected static String DESIGNATION_UPDATE_MESSAGE;
	    protected static String BANK_CREATE_SUCCESS_MSG;
	    protected static String BANK_CODE_DUPLICATED_MSG;
	    protected static String BANK_UPDATE_SUCCESS_MSG;
	    protected static String BRANCH_CREATE_SUCCESS_MSG;
	    protected static String BRANCH_CODE_DUPLICATED_MSG;
	    protected static String BRANCH_CODE_UPDATED_MSG;
	    protected static String excellFilePath;
	    protected static String USER_AUTHORIZED_SUCESS_MESSAGE;
	    protected static String USER_SUCESSFULLY_UPDATED_MESSAGE;
	    protected static String USER_INACTIVE_MESSAGE;    
	    protected static String USER_REACTIVE_MESSAGE;
	    protected static String USER_PASSWORD_RESET_MESSAGE;
	    protected static String USER_ROLE_SAVED_USER_MAINTAINCE;
	    protected static String USER_LOCK_SUCESSFULLY_MESSAGE;        
	    protected static String USER_UNLOCK_SUCESSFULLY_MESSAGE; 
	    protected static String USER_ENTITY_ACTIVATION_MESSAGE;
	    protected static String ROLE_PERMISSION_SET_SUCCESS_MESSAGE;
	    protected static String ROLE_PERMISSION_AUTHORIZE_SUCCESS_MSG;
	    protected static String USER_UNABLE_LOG_MORE_TIMES;
	    protected static String USER_LOGGED_OUT_FROM_GRID_SUCCESS_MESSAGE;
	    protected static String EXCHANGE_COMPANY_DUPLICATE_MESSAGE;
	    protected static String EXCHANGE_COMPANY_SUCCESS_MESSAGE;
	    protected static String EXCHANGE_COMPANY_AUTHORIZE_SUCCESS_MESSAGE;
	    protected static String EXCHANGE_COMPANY_EDIT_SUCCESS_MESSAGE;
	    protected static String EXCHANGE_COMPANY_INACTIVE_SUCCESS_MESSAGE;
	    protected static String EXCHANGE_COMPANY_REACTIVE_SUCCESS_MESSAGE;
	    protected static String EXCHANGE_COMPANY_ACCREATE_SUCCESS_MESSAGE;
	    protected static String EXCHANGE_COMPANY_ACCREATE_AUTHORIZE_SUCCESS_MESSAGE;
	    protected static String EXCHANGE_COMPANY_ACEDIT_SUCCESS_MESSAGE;
	    protected static String EXCHANGE_COMPANY_ACINACTIVATE_SUCCESS_MESSAGE;
	    protected static String EXCHANGE_COMPANY_ACREACTIVATE_SUCCESS_MESSAGE;
	    protected static String PARTNER_CREATE_SUCCESS_MESSAGE;
	    protected static String PARTNER_AUTHORIZE_SUCCESS_MESSAGE;
	    protected static String PARTNER_EDIT_SUCCESS_MESSAGE;
	    protected static String PARTNER_INACTIVATE_SUCCESS_MESSAGE;
	    protected static String PARTNER_REACTIVATE_SUCCESS_MESSAGE;
	    
		@BeforeSuite 
	    public void beforeSuite() throws Exception {
	       try {
	            baseProperties = new Properties();
	            baseProperties.load(new FileInputStream(".\\config\\base.properties"));
	            BASEURL = baseProperties.getProperty("BASE_URL")  ;
	            TIME_OUT = Integer.parseInt(baseProperties.getProperty("TIME_OUT"));
	            BROWSER_TYPE = baseProperties.getProperty("BROWSER_TYPE");
	            IE_BIT_VERSION=baseProperties.getProperty("IE_BIT_VERSION");
	            USER_NAME = baseProperties.getProperty("USER_NAME")  ;
	            PASSWORD = baseProperties.getProperty("PASSWORD") ;
	            FULL_NAME = baseProperties.getProperty("FULLNAME") ;
	            BRANCH= baseProperties.getProperty("BRANCH") ;
	            driver = getWebDriver();
	            ADMIN_USER_NAME = baseProperties.getProperty("ADMIN_USER_NAME");
	            ADMIN_PASSWORD = baseProperties.getProperty("ADMIN_PASSWORD");
	            ADMIN_BRANCH = baseProperties.getProperty("ADMIN_BRANCH");
	            ADMIN_FULLNAME = baseProperties.getProperty("ADMIN_FULLNAME");
	            USER_CREATION_URL=baseProperties.getProperty("USER_CREATION_URL");
	            USER_CREATION_SUCESS_MESSAGE=baseProperties.getProperty("User_Creation_Sucess_Message");
	            PASSWORD_CHANGE_MESSAGE=baseProperties.getProperty("password_change_Message");
	            DESIGNATION_CREATION_SUCCESS_MESSAGE = baseProperties.getProperty("Designation_Create_Success_Message");
	            DESIGNATION_DUPLICATION_MESSAGE = baseProperties.getProperty("Designation_Duplicate_Message");
	            DESIGNATION_UPDATE_MESSAGE = baseProperties.getProperty("Designation_Updated_Message");
	            RoleSucessfullyCreatedMessage=baseProperties.getProperty("Role_sucess_created_Message");
	            ROlE_DUPLICATE_MESSAGE=baseProperties.getProperty("Role_Duplicate_Message");
	            ROLE_AUTHORIZE_SUCCESS_MESSAGE = baseProperties.getProperty("Role_Authorise_Success_Message");
	            ROLE_UPDATE_SUCCESS_MESSAGE = baseProperties.getProperty("Role_Update_Success_Message");
	            ROLE_INACTIVE_SUCCESS_MESSAGE = baseProperties.getProperty("Role_Inactivate_Success_Message");
	            ROLE_REACTIVE_SUCCESS_MESSAGE = baseProperties.getProperty("Role_ReActivate_Success_Message");
	            SYSTEM_PARAMETER_ADD_SUCCESS_MESSAGE = baseProperties.getProperty("System_Parameter_Add_Success_Message");
	            SYSTEM_PARAMETER_DUPLICATE_MESSAGE = baseProperties.getProperty("System_Parameter_Duplicate_Message");
	            ROLE_PERMISSION_AUTHORIZE_SUCCESS_MSG = baseProperties.getProperty("Role_Authorize_Success_Message");
	            BANK_CREATE_SUCCESS_MSG = baseProperties.getProperty("Bank_Created_Success_Message");
	            BANK_CODE_DUPLICATED_MSG = baseProperties.getProperty("Bank_Code_Duplicated");
	            BANK_UPDATE_SUCCESS_MSG = baseProperties.getProperty("Bank_Update_Success");
	            BRANCH_CREATE_SUCCESS_MSG = baseProperties.getProperty("Branch_Created_Success_Message");
	            BRANCH_CODE_DUPLICATED_MSG = baseProperties.getProperty("Branch_Code_Duplicated");
	            BRANCH_CODE_UPDATED_MSG = baseProperties.getProperty("Brach_Update_Success");
	            USER_AUTHORIZED_SUCESS_MESSAGE = baseProperties.getProperty("User_Authorized_Sucess_Message");
	            USER_SUCESSFULLY_UPDATED_MESSAGE = baseProperties.getProperty("User_Succesfully_Edit_Message");
	            USER_INACTIVE_MESSAGE = baseProperties.getProperty("User_Inactive_Message");
	            USER_REACTIVE_MESSAGE=baseProperties.getProperty("User_Reactive_Message");
	            USER_PASSWORD_RESET_MESSAGE=baseProperties.getProperty("User_Password_Reset_Message");
	            USER_ROLE_SAVED_USER_MAINTAINCE=baseProperties.getProperty("User_Role_saved_User_Maintaince");
	            USER_LOCK_SUCESSFULLY_MESSAGE = baseProperties.getProperty("User_Locked_Sucessfully_Message");
	            USER_UNLOCK_SUCESSFULLY_MESSAGE = baseProperties.getProperty("User_UnLocked_Sucessfully_Message");
	            USER_ENTITY_ACTIVATION_MESSAGE = baseProperties.getProperty("User_Entity_Activation_Sucessfully_Message");
	            ROLE_PERMISSION_SET_SUCCESS_MESSAGE = baseProperties.getProperty("Role_Permission_Set_Success");
	            ROLE_PERMISSION_AUTHORIZE_SUCCESS_MSG = baseProperties.getProperty("Role_Permission_Authorize_Success");
	            USER_UNABLE_LOG_MORE_TIMES = baseProperties.getProperty("User_Unable_To_Log_Two_Times_Message");
	            USER_LOGGED_OUT_FROM_GRID_SUCCESS_MESSAGE = baseProperties.getProperty("User_Logged_Out_From_Grid");
	            EXCHANGE_COMPANY_DUPLICATE_MESSAGE = baseProperties.getProperty("Exchange_Company_Duplicate_Message");
	            EXCHANGE_COMPANY_SUCCESS_MESSAGE = baseProperties.getProperty("Exchange_Company_Success_Message");
	            EXCHANGE_COMPANY_AUTHORIZE_SUCCESS_MESSAGE = baseProperties.getProperty("Exchange_Company_Authorize_Success_Message");
	            EXCHANGE_COMPANY_EDIT_SUCCESS_MESSAGE = baseProperties.getProperty("Exchange_Company_Edit_Success_Message");
	            EXCHANGE_COMPANY_INACTIVE_SUCCESS_MESSAGE = baseProperties.getProperty("Exchange_Company_Inactive_Success_Message");
	            EXCHANGE_COMPANY_REACTIVE_SUCCESS_MESSAGE = baseProperties.getProperty("Exchange_Company_Reactive_Success_Message");
	            EXCHANGE_COMPANY_ACCREATE_SUCCESS_MESSAGE = baseProperties.getProperty("Exchange_Company_ACCreate_Success_Message");
	            EXCHANGE_COMPANY_ACCREATE_AUTHORIZE_SUCCESS_MESSAGE = baseProperties.getProperty("Exchange_Company_ACCreateAuthorize_Success_Message");
	            EXCHANGE_COMPANY_ACEDIT_SUCCESS_MESSAGE = baseProperties.getProperty("Exchange_Company_ACEdit_Success_Message");
	            EXCHANGE_COMPANY_ACINACTIVATE_SUCCESS_MESSAGE = baseProperties.getProperty("Exchange_Company_ACInactivate_Success_Message");
	            EXCHANGE_COMPANY_ACREACTIVATE_SUCCESS_MESSAGE = baseProperties.getProperty("Exchange_Company_ACReactivate_Success_Message");
	            PARTNER_CREATE_SUCCESS_MESSAGE = baseProperties.getProperty("Partner_Create_Success_Message");
	            PARTNER_AUTHORIZE_SUCCESS_MESSAGE = baseProperties.getProperty("Partner_Authorize_Success_Message");
	            PARTNER_EDIT_SUCCESS_MESSAGE = baseProperties.getProperty("Partner_Edit_Success_Message");
	            PARTNER_INACTIVATE_SUCCESS_MESSAGE = baseProperties.getProperty("Partner_Inactive_Success_Message");
	            PARTNER_REACTIVATE_SUCCESS_MESSAGE = baseProperties.getProperty("Partner_Reactive_Success_Message");
	            
	       } catch (IOException e) {
	            System.exit(0);
	       }
	    }

	    @AfterSuite
	    public void afterSuite() throws Exception {
	       //driver.quit();
	    }
	    
	    protected WebDriver getWebDriver() throws Exception {

	        if (BROWSER_TYPE == null) {
	            driver = new HtmlUnitDriver();
	        } else if (BROWSER_TYPE.equalsIgnoreCase("Firefox")) {
	            driver = new FirefoxDriver();
	        } else if (BROWSER_TYPE.equalsIgnoreCase("Chrome")) {
	        	System.setProperty("webdriver.chrome.driver",".\\resourses\\chromedriver.exe");
	            driver = new ChromeDriver();
	        } else if (BROWSER_TYPE.equalsIgnoreCase("IE")) {
	        	if(IE_BIT_VERSION.equalsIgnoreCase("64")){
	        		System.setProperty("webdriver.ie.driver",".\\resourses\\IEDriverServer_64.exe");
	        	}else{
	        		System.setProperty("webdriver.ie.driver",".\\resourses\\IEDriverServer_32.exe");
	        	}        
	        	driver = new InternetExplorerDriver();
	        } else if (BROWSER_TYPE.equalsIgnoreCase("HtmlUnit")) {
	            driver = new HtmlUnitDriver();
	        } else {
	            driver = new HtmlUnitDriver();
	        }
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);

	        return driver;
	    }
}
