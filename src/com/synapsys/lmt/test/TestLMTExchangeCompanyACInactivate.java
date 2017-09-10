package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTExchangeCompanyACInactivate;
import com.synapsys.lmt.util.TestBase;

public class TestLMTExchangeCompanyACInactivate extends TestBase
{
	private String businessEntityName = "SynapSys";
	private String acNo = "922591652001";
	private String acName = "SynapSys";
	private String type = "Saving";
	private String bookType = "DBU";
	private String currency = "Sri Lanka Rupee (LKR)";
	private String status = "Active";
	
	public static LMTExchangeCompanyACInactivate lmtExchangeCompanyACInactivate;
	
	@Test
	public void test_AccInactivate()throws Exception
	{
		lmtExchangeCompanyACInactivate = new LMTExchangeCompanyACInactivate();
		lmtExchangeCompanyACInactivate.initailize();
		lmtExchangeCompanyACInactivate.Search_Grid_for_BEName(businessEntityName);
		lmtExchangeCompanyACInactivate.Search_Grid_for_ACNo(acNo, acName, type, bookType, currency, status);
		lmtExchangeCompanyACInactivate.validateInactivate(EXCHANGE_COMPANY_ACINACTIVATE_SUCCESS_MESSAGE);
	}
}
