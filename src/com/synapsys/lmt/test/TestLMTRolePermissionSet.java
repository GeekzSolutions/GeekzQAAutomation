package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTRolePermissionSet;
import com.synapsys.lmt.util.TestBase;


public class TestLMTRolePermissionSet extends TestBase
{
	private String rolename= "Customer Officer 52UP";
	
	public static LMTRolePermissionSet lmtRolePermissionSet;
	
	@Test
	public void testPermissionSet()throws Exception
	{
		lmtRolePermissionSet = new LMTRolePermissionSet();
		lmtRolePermissionSet.click_Basic();
		lmtRolePermissionSet.selectRole(rolename);
		lmtRolePermissionSet.setPermissions();
		lmtRolePermissionSet.validatePermissionSet(ROLE_PERMISSION_SET_SUCCESS_MESSAGE);
	}

}
