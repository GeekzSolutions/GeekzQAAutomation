package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.lib.SeleniumBase;
import com.synapsys.lmt.pages.LMTDashBoardPage;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTRoleEditAuthorize;
import com.synapsys.lmt.pages.LmtLogout;

public class TestLMTRoleEditAuthorize extends SeleniumBase 
{
	private String checkRoleName = "Customer Officer 52UP";
	private String status = "Modified";
	private String bussinessEntity = "LMT";
	
	public static LMTRoleEditAuthorize lMTRoleEditAuthorize;
	public static LmtLogout lMTLogout;
	public static LMTLoginPage lMTLoginPage;
	public static LMTDashBoardPage lMTDashBoardPage;
	
	
	@Test
	public void test_Role_Authorize() throws Exception
	{
		lMTLogout = new LmtLogout();
		lMTLoginPage = lMTLogout.Logout_User();
		lMTLoginPage.isSuccessfullyLogged_Out();
		
		//login with admin (other user)
		lMTLoginPage = new LMTLoginPage();
		lMTDashBoardPage = new LMTDashBoardPage();
		lMTDashBoardPage = lMTLoginPage.Login_With_Valid_Credentials(USER_NAME,PASSWORD);
		lMTDashBoardPage.isSuccessfullyLogged(FULL_NAME, BRANCH);
		
		lMTRoleEditAuthorize = new LMTRoleEditAuthorize();
		lMTRoleEditAuthorize.initailizeAuthorize();
		lMTRoleEditAuthorize.selectBusinessEntity(bussinessEntity);
		//lMTRoleEditAuthorize.Calc_Label_Of_Value();
		//lMTRoleEditAuthorize.Get_Values_According_To_Role_Name(checkRoleName, status);
		lMTRoleEditAuthorize.Search_Page_for_RoleName(checkRoleName, status);
		lMTRoleEditAuthorize.Verify_Role_Authorize(checkRoleName, ROLE_AUTHORIZE_SUCCESS_MESSAGE);
	}
}
