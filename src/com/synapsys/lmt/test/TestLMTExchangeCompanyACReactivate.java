package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTExchangeCompanyACReactivate;
import com.synapsys.lmt.util.TestBase;

public class TestLMTExchangeCompanyACReactivate extends TestBase
{
	private String businessEntityName = "SynapSys";
	private String acNo = "922591652001";
	private String acName = "SynapSys";
	private String type = "Saving";
	private String bookType = "DBU";
	private String currency = "Sri Lanka Rupee (LKR)";
	private String status = "Inactive";
	
	public static LMTExchangeCompanyACReactivate lmtExchangeCompanyACReactivate;
	
	@Test
	public void test_AccReactivate()throws Exception
	{
		lmtExchangeCompanyACReactivate = new LMTExchangeCompanyACReactivate();
		lmtExchangeCompanyACReactivate.initailize();
		lmtExchangeCompanyACReactivate.Search_Grid_for_BEName(businessEntityName);
		lmtExchangeCompanyACReactivate.Search_Grid_for_ACNo(acNo, acName, type, bookType, currency, status);
		lmtExchangeCompanyACReactivate.validateInactivate(EXCHANGE_COMPANY_ACREACTIVATE_SUCCESS_MESSAGE);
	}
}
