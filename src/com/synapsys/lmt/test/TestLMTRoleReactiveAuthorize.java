package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.lib.SeleniumBase;
import com.synapsys.lmt.pages.LMTDashBoardPage;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTRoleReactiveAuthorize;
import com.synapsys.lmt.pages.LmtLogout;

public class TestLMTRoleReactiveAuthorize extends SeleniumBase 
{
	private String checkRoleName = "Customer Officer 52UP";
	private String status = "Re-Active";
	private String bussinessEntity = "LMT";
	
	public static LMTRoleReactiveAuthorize lMTRoleReactiveAuthorize;
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
		
		lMTRoleReactiveAuthorize = new LMTRoleReactiveAuthorize();
		lMTRoleReactiveAuthorize.initailizeAuthorize();
		lMTRoleReactiveAuthorize.selectBusinessEntity(bussinessEntity);
		//lMTRoleReactiveAuthorize.Calc_Label_Of_Value();
		//lMTRoleReactiveAuthorize.Get_Values_According_To_Role_Name(checkRoleName, status);
		lMTRoleReactiveAuthorize.Search_Page_for_RoleName(checkRoleName, status);
		lMTRoleReactiveAuthorize.Verify_Role_Authorize(checkRoleName, ROLE_AUTHORIZE_SUCCESS_MESSAGE);
	}
}
