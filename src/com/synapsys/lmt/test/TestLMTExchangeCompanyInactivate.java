package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTExchangeCompanyInactive;
import com.synapsys.lmt.util.TestBase;

public class TestLMTExchangeCompanyInactivate extends TestBase
{
	private String createdDate = "10-Feb-2016";
	private String ECCode = "LK003";
	private String ECName = "SynapSys";
	private String status = "Active";
	private String country = "Sri Lanka";
	
	public static LMTExchangeCompanyInactive lmtExchangeCompanyInactive;
	
	@Test
	public void testExchangeCompanyInactive()throws Exception
	{
		lmtExchangeCompanyInactive = new LMTExchangeCompanyInactive();
		lmtExchangeCompanyInactive.initailize();
		lmtExchangeCompanyInactive.Search_Grid_for_ECCode(createdDate, ECCode, ECName, country, status);
		lmtExchangeCompanyInactive.validateInactivate(EXCHANGE_COMPANY_INACTIVE_SUCCESS_MESSAGE);
	}

}
