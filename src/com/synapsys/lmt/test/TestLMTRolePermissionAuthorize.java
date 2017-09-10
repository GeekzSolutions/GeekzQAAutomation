package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTDashBoardPage;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTRolePermissionAuthorize;
import com.synapsys.lmt.pages.LmtLogout;
import com.synapsys.lmt.util.TestBase;

public class TestLMTRolePermissionAuthorize extends TestBase
{
	private String role = "Customer Officer 52UP";
	public static LMTRolePermissionAuthorize lMTRolePermissionAuthorize;
	public static LmtLogout lMTLogout;
	public static LMTLoginPage lMTLoginPage;
	public static LMTDashBoardPage lMTDashBoardPage;
	
	@Test
	public void test_RolePermissionAuthorize()throws Exception
	{
		lMTLogout = new LmtLogout();
		lMTLoginPage = lMTLogout.Logout_User();
		lMTLoginPage.isSuccessfullyLogged_Out();
		
		
		//login with admin (other user)
		lMTLoginPage = new LMTLoginPage();
		lMTDashBoardPage = new LMTDashBoardPage();
		lMTDashBoardPage = lMTLoginPage.Login_With_Valid_Credentials(ADMIN_USER_NAME,ADMIN_PASSWORD);
		lMTDashBoardPage.isSuccessfullyLogged(ADMIN_FULLNAME, ADMIN_BRANCH);
		
		lMTRolePermissionAuthorize = new LMTRolePermissionAuthorize();
		lMTRolePermissionAuthorize.authorizeRoleP();
		lMTRolePermissionAuthorize.selectBusinessEntity(role);
		lMTRolePermissionAuthorize.isRoleAuthorized(ROLE_PERMISSION_AUTHORIZE_SUCCESS_MSG);
	}

}
