package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTCommonMasterBankEdit;
import com.synapsys.lmt.util.TestBase;

public class TestLMTCommonMasterBankEdit extends TestBase 
{
	private String code = "7010";
	private String name = "Bank of Ceylon";
	private String status = "Active";
	private String newCode = "8888";
	
	public static LMTCommonMasterBankEdit lMTCommonMasterBankEdit;
	
	@Test
	public void test_Bank_Edit()throws Exception
	{
		lMTCommonMasterBankEdit = new LMTCommonMasterBankEdit();
		lMTCommonMasterBankEdit.initialize(code, name);
		lMTCommonMasterBankEdit.Search_Grid_for_Bank_Code(code, name, status, newCode);
		lMTCommonMasterBankEdit.Is_Bank_Edited(BANK_UPDATE_SUCCESS_MSG);
	}

}
