package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LmtLogout;
import com.synapsys.lmt.pages.UserMaintainceResetPassword;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;

public class TestUserMaintainceResetPassword extends TestBase{

	private String username="Anuja";
	private String firstName="ANUJA";
	private String lastName="LAKSHAN";
	private String password="Test123456@";
	
	public static UserMaintainceResetPassword UserMaintainceResetPassword;
	public static LmtLogout LmtLogout;
	public static LMTLoginPage LMTLoginPage;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms() ; 
	
	@Test
	public void test_reset_password() throws Exception{
		UserMaintainceResetPassword = new UserMaintainceResetPassword();
		LmtLogout = new LmtLogout();
		LMTLoginPage = new LMTLoginPage();
		UserMaintainceResetPassword.click_Basic();
		UserMaintainceResetPassword.Search_Grid_for_User_Name(username, firstName, lastName);
		//UserMaintainceResetPassword.Verify_User_View_in_Grid(username, firstName, lastName);
		UserMaintainceResetPassword.User_View_After_Grid(username, password);
		UserMaintainceResetPassword.User_Inactive_Sucess_Message(USER_PASSWORD_RESET_MESSAGE);
		LmtLogout.Logout_User();
		LMTLoginPage.Login_With_Valid_Credentials(username, password);
		LmtLogout.Logout_User();
		LMTLoginPage.Login_With_Valid_Credentials(USER_NAME, PASSWORD);
		
	}
}
