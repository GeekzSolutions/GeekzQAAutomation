package com.synapsys.lmt.test;

import com.synapsys.lmt.util.TestBase;
import com.synapsys.lmt.pages.LMTRoleInactive;

import org.testng.annotations.Test;

public class TestLMTRoleInactive extends TestBase
{
	private String checkRoleName = "Customer Officer 52UP";
	private String status = "Active";
	private String bussinessEntity = "LMT";
	
	public static LMTRoleInactive lMTRoleInactive;
	
	@Test
	public void test_Role_Inactive_Details() throws Exception
	{
		lMTRoleInactive = new LMTRoleInactive();
		lMTRoleInactive.clickBasic();
		lMTRoleInactive.selectBusinessEntity(bussinessEntity);
		lMTRoleInactive.searchGridforRoleName(checkRoleName, status);
		lMTRoleInactive.roleInactivate(checkRoleName);
		lMTRoleInactive.Verify_Role_Inactive_in_Grid(ROLE_INACTIVE_SUCCESS_MESSAGE);
	}

}