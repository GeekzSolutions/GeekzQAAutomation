package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LmtLogout;
import com.synapsys.lmt.pages.LMTUserMaintainceAssignRolles;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;

public class TestLMTUserMaintainceAssignRolles extends TestBase {

	private String businessEntity="LMT";
	private String userName="Anuja";
	private String firstName="ANUJA";
	private String lastName="LAKSHAN";	
	
	public static LMTUserMaintainceAssignRolles LMTUserMaintainceAssignRolles;
	
//	public static LmtLogout LmtLogout;
	//public static LMTLoginPage LMTLoginPage;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms() ; 
	
	@Test
	public void test_assign_rolls_from_user_maintaince() throws Exception{
		LMTUserMaintainceAssignRolles = new LMTUserMaintainceAssignRolles();
		//LmtLogout = new LmtLogout();
		//LMTLoginPage = new LMTLoginPage();
		LMTUserMaintainceAssignRolles.click_Basic();
		LMTUserMaintainceAssignRolles.Search_Grid_for_User_Name(userName, firstName, lastName);		
		LMTUserMaintainceAssignRolles.User_View_After_Grid(businessEntity, userName);
		LMTUserMaintainceAssignRolles.User_AssignRole_Sucess_Message(USER_ROLE_SAVED_USER_MAINTAINCE);
		//LmtLogout.Logout_User();
		//LMTLoginPage.Login_With_Valid_Credentials(username, password);
		//LmtLogout.Logout_User();
		//LMTLoginPage.Login_With_Valid_Credentials(USER_NAME, PASSWORD);
		
	}
}
