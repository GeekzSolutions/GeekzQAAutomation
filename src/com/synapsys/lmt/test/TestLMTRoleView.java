package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTRoleView;
import com.synapsys.lmt.util.TestBase;

public class TestLMTRoleView extends TestBase
{
	private String checkRoleName = "Customer Officer 52";
	private String status = "Active";
	private String bussinessEntity = "LMT";
	public static LMTRoleView lmtRoleView;
	
	@Test
	public void test_Role_View_Grid_Details() throws Exception
	{
		lmtRoleView = new LMTRoleView();
		lmtRoleView.clickBasic();
		lmtRoleView.selectBusinessEntity(bussinessEntity);
		//lmtRoleView.Calc_Label_Of_Value();
		//lmtRoleView.Get_Values_According_To_Role_Name(checkRoleName, status);
		lmtRoleView.Search_Grid_for_Parameter_Name(checkRoleName, status);
		lmtRoleView.Verify_Role_View_in_Grid(checkRoleName);
	}

}
