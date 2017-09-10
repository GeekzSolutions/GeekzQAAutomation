package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTRolePermissionView;
import com.synapsys.lmt.util.TestBase;

public class TestLMTRolePermissionView extends TestBase
{
	private String role = "Customer Officer 52UP";
	
	public static LMTRolePermissionView lMTRolePermissionView;
	
	@Test
	public void testPermissionView()throws Exception
	{
		lMTRolePermissionView = new LMTRolePermissionView();
		lMTRolePermissionView.click_Basic();
		lMTRolePermissionView.selectRole(role);
		lMTRolePermissionView.validatePermissions();
	}

}
