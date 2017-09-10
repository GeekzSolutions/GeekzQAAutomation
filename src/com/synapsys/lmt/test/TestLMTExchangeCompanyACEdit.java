package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTExchangeCompanyACEdit;
import com.synapsys.lmt.util.TestBase;

public class TestLMTExchangeCompanyACEdit extends TestBase
{
	private String businessEntityName = "SynapSys";
	private String acNo = "922591652001";
	private String acName = "SynapSys";
	private String type = "Saving";
	private String bookType = "DBU";
	private String currency = "Sri Lanka Rupee (LKR)";
	private String status = "Active";
	private String newBookType = "FCBU";
	
	public static LMTExchangeCompanyACEdit lmtExchangeCompanyACEdit;
	
	@Test
	public void test_ACEdit()throws Exception
	{
		lmtExchangeCompanyACEdit = new LMTExchangeCompanyACEdit();
		lmtExchangeCompanyACEdit.initailize();
		lmtExchangeCompanyACEdit.Search_Grid_for_BEName(businessEntityName);
		lmtExchangeCompanyACEdit.Search_Grid_for_ACNo(acNo, acName, type, bookType, currency, status);
		lmtExchangeCompanyACEdit.editAccount(newBookType);
		lmtExchangeCompanyACEdit.validateEdit(EXCHANGE_COMPANY_ACEDIT_SUCCESS_MESSAGE);
	}
	
}
