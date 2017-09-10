package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTCommonMasterBranchEdit;
import com.synapsys.lmt.util.TestBase;

public class TestLMTCommonMasterBranchEdit extends TestBase
{
	private String bankCode = "7056";
	private String bankName = "Commercial Bank PLC";
	private String bankStatus = "Active";
	private String branchID="545";
	private String branchName="Kandy";
	private String branchCode="004";
	private String branchStatus="Active";
	private String newBranchName="Kandy";
	private String newBranchCode="666";
	
	public static LMTCommonMasterBranchEdit lMTCommonMasterBranchEdit;
	
	@Test
	public void test_Branch_Search()throws Exception
	{
		lMTCommonMasterBranchEdit = new LMTCommonMasterBranchEdit();
		lMTCommonMasterBranchEdit.initialize();
		lMTCommonMasterBranchEdit.Search_Grid_for_Bank_Code(bankCode, bankName, bankStatus);
		lMTCommonMasterBranchEdit.searchBranch(branchCode, branchName);
	}
	
	@Test
	public void test_Branch_Edit()throws Exception
	{
		lMTCommonMasterBranchEdit = new LMTCommonMasterBranchEdit();
		lMTCommonMasterBranchEdit.initialize();
		lMTCommonMasterBranchEdit.Search_Grid_for_Bank_Code(bankCode, bankName, bankStatus);
		lMTCommonMasterBranchEdit.Search_Grid_for_Branch_Code(branchID, branchCode, branchName, branchStatus, newBranchCode, newBranchName);
		lMTCommonMasterBranchEdit.editBranch(BRANCH_CODE_UPDATED_MSG);
	}

}
