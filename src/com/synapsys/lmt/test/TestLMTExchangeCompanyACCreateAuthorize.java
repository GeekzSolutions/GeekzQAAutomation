package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTExchangeCompanyACCreateAuthorize;
import com.synapsys.lmt.util.TestBase;

public class TestLMTExchangeCompanyACCreateAuthorize extends TestBase
{
	private String businessEntityName = "SynapSys";
	private String acNo = "922591652001";
	private String acName = "SynapSys";
	private String type = "Saving";
	private String bookType = "DBU";
	private String currency = "Sri Lanka Rupee (LKR)";
	private String status = "New";
	
	public static LMTExchangeCompanyACCreateAuthorize lmtExchangeCompanyACCreateAuthorize;
	
	@Test
	public void test_ACCreate_Authorize()throws Exception
	{
		lmtExchangeCompanyACCreateAuthorize = new LMTExchangeCompanyACCreateAuthorize();
		lmtExchangeCompanyACCreateAuthorize.initailize();
		lmtExchangeCompanyACCreateAuthorize.Search_Grid_for_BEName(businessEntityName);
		lmtExchangeCompanyACCreateAuthorize.Search_Grid_for_ACNo(acNo, acName, type, bookType, currency, status);
		lmtExchangeCompanyACCreateAuthorize.validateAuthorize(EXCHANGE_COMPANY_ACCREATE_AUTHORIZE_SUCCESS_MESSAGE);
	}
}
