package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.util.TestBase;
import com.synapsys.lmt.pages.LMTRoleReActive;

public class TestLMTRoleReActive extends TestBase 
{
	private String checkRoleName = "Customer Officer 52UP";
	private String status = "Inactive";
	private String bussinessEntity = "LMT";
	
	public static LMTRoleReActive lMTRoleReActive;
	
	@Test
	public void test_Role_Reactive_Details() throws Exception
	{
		lMTRoleReActive = new LMTRoleReActive();
		lMTRoleReActive.clickBasic();
		lMTRoleReActive.selectBusinessEntity(bussinessEntity);
		lMTRoleReActive.Search_Grid_for_Role_Name(checkRoleName, status);
		lMTRoleReActive.reactivateRole(checkRoleName);
		lMTRoleReActive.verifyReactivate(ROLE_REACTIVE_SUCCESS_MESSAGE);
	}
	
}
