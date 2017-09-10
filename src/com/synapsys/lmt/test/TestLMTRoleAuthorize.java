package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.lib.SeleniumBase;
import com.synapsys.lmt.pages.LMTDashBoardPage;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTRoleAuthorize;
import com.synapsys.lmt.pages.LmtLogout;

public class TestLMTRoleAuthorize extends SeleniumBase 
{
	private String checkRoleName = "Customer Officer 52";
	private String status = "New";
	private String bussinessEntity = "LMT";
	
	public static LMTRoleAuthorize lMTRoleAuthorize;
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
		lMTDashBoardPage = lMTLoginPage.Login_With_Valid_Credentials(ADMIN_USER_NAME,ADMIN_PASSWORD);
		lMTDashBoardPage.isSuccessfullyLogged(ADMIN_FULLNAME, ADMIN_BRANCH);
		
		lMTRoleAuthorize = new LMTRoleAuthorize();
		lMTRoleAuthorize.initailizeAuthorize();
		lMTRoleAuthorize.selectBusinessEntity(bussinessEntity);
		//lMTRoleAuthorize.Calc_Label_Of_Value();
		//lMTRoleAuthorize.Get_Values_According_To_Role_Name(checkRoleName, status);
		lMTRoleAuthorize.Search_Grid_for_RoleName(checkRoleName, status);
		lMTRoleAuthorize.Verify_Role_Authorize(checkRoleName, ROLE_AUTHORIZE_SUCCESS_MESSAGE);
	}
}
