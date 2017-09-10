package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTExchangeCompanyReactivate;
import com.synapsys.lmt.util.TestBase;

public class TestLMTExchangeCompanyReactive extends TestBase
{
	private String createdDate = "10-Feb-2016";
	private String ECCode = "LK003";
	private String ECName = "SynapSys";
	private String status = "Inactive";
	private String country = "Sri Lanka";
	
	public static LMTExchangeCompanyReactivate lmtExchangeCompanyReactive;
	
	@Test
	public void testExchangeCompanyReactive()throws Exception
	{
		lmtExchangeCompanyReactive = new LMTExchangeCompanyReactivate();
		lmtExchangeCompanyReactive.initailize();
		lmtExchangeCompanyReactive.Search_Grid_for_ECCode(createdDate, ECCode, ECName, country, status);
		lmtExchangeCompanyReactive.validateInactivate(EXCHANGE_COMPANY_REACTIVE_SUCCESS_MESSAGE);
	}
}
