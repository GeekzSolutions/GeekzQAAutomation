package com.synapsys.lmt.test;

import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;

import org.junit.validator.PublicClassValidator;
import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTUserSession;
import com.synapsys.lmt.pages.LmtLogout;

public class TestLMTUserSession extends TestBase{
	
	//private String username = "";
	///private String fullName = "";
	private String branch = "BANK OF COLOMBO";
	private String logoutStatus = "NO";
	private String businessEntity = "LMT";
	private String loginStatus = "All";
	private String nameInGrid = "CHATHURANGA KUCHAN";
	
	public static LMTUserSession LMTUserSession;
	public static LMTLoginPage LMTLoginPage;
	public static LmtLogout LmtLogout;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms();
	
	@Test
	public void test_user_session_output() throws Exception{
		LMTUserSession = new LMTUserSession();
		LMTLoginPage = new LMTLoginPage(); 
		LmtLogout = new LmtLogout();
		LMTUserSession.closeBrowser();
		LMTUserSession.logged_using_same_user(USER_NAME, PASSWORD);
		LMTUserSession.same_user_unable_logged_message(USER_UNABLE_LOG_MORE_TIMES);
		LMTLoginPage.Login_With_Valid_Credentials(ADMIN_USER_NAME, ADMIN_PASSWORD);
		LMTUserSession.click_Basic();
		LMTUserSession.enter_details_for_user_session(businessEntity, branch, loginStatus, USER_NAME);
		LMTUserSession.Search_Grid_for_User_Name(USER_NAME, nameInGrid, branch, logoutStatus);		
		LMTUserSession.User_Logout_Sucess_Message(USER_LOGGED_OUT_FROM_GRID_SUCCESS_MESSAGE);
		LmtLogout.Logout_User();
		LMTLoginPage.Login_With_Valid_Credentials(USER_NAME, PASSWORD);
		
	}
}
