package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.util.TestBase;
import com.synapsys.lmt.pages.LMTDashBoardPage;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTRoleAuthorize;
import com.synapsys.lmt.pages.LMTRoleEdit;
import com.synapsys.lmt.pages.LmtLogout;



public class TestLMTRoleEdit extends TestBase{

	private String checkRoleName = "Customer Officer 52";
	private String status = "Active";
	private String bussinessEntity = "LMT";
	private String newRoleName = "Customer Officer 52UP";
	
	public static LMTRoleEdit lMTRoleEdit;
	public static LMTRoleAuthorize lMTRoleAuthorize;
	public static LmtLogout lMTLogout;
	public static LMTLoginPage lMTLoginPage;
	public static LMTDashBoardPage lMTDashBoardPage;
	
	@Test
	public void test_Role_Edit_Details() throws Exception
	{
		lMTRoleEdit = new LMTRoleEdit();
		lMTRoleEdit.clickBasic();
		lMTRoleEdit.selectBusinessEntity(bussinessEntity);
		//lMTRoleEdit.Calc_Label_Of_Value();
		//lMTRoleEdit.Get_Values_According_To_Role_Name(checkRoleName, status, newRoleName);
		lMTRoleEdit.Search_Grid_for_RoleName(checkRoleName, status, newRoleName);
		lMTRoleEdit.Is_Role_Creates_With_Special_Characters();
		lMTRoleEdit.Is_Role_Duplicated(ROlE_DUPLICATE_MESSAGE);
		lMTRoleEdit.Verify_Role_Edit(ROLE_UPDATE_SUCCESS_MESSAGE);
		
		
	}	
}
