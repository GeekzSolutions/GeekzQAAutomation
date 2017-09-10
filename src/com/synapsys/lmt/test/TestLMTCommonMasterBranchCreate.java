package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTCommonMasterBranchCreate;
import com.synapsys.lmt.util.TestBase;

public class TestLMTCommonMasterBranchCreate extends TestBase
{
	private String bankCode = "7108";
	private String bankName = "Indian Bank";
	private String bankStatus = "Active";
	private String branchName = "Mawatagama";
	private String branchCode = "991";
	
	public static LMTCommonMasterBranchCreate lMTCommonMasterBranchCreate;
	
	@Test
	public void test_Branch_Creation()throws Exception
	{
		lMTCommonMasterBranchCreate = new LMTCommonMasterBranchCreate();
		lMTCommonMasterBranchCreate.initialize();
		lMTCommonMasterBranchCreate.Search_Grid_for_Bank_Code(bankCode, bankName, bankStatus, branchCode, branchName);
		lMTCommonMasterBranchCreate.Is_Branch_Created(BRANCH_CREATE_SUCCESS_MSG);
		
	}
	
	@Test
	public void test_New_Button()throws Exception
	{
		lMTCommonMasterBranchCreate = new LMTCommonMasterBranchCreate();
		lMTCommonMasterBranchCreate.initialize();
		lMTCommonMasterBranchCreate.Search_Grid_for_Bank_Code(bankCode, bankName, bankStatus, branchCode, branchName);
		lMTCommonMasterBranchCreate.Verify_New_Button();
		
	}

}
