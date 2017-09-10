package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTPartnerReactivate;
import com.synapsys.lmt.util.TestBase;

public class TestLMTPartnerReactivate extends TestBase
{
	private String createdDate = "10-Feb-2016";
	private String pCode = "LK003";
	private String pName = "SynapSys";
	private String status = "Inactive";
	private String country = "Sri Lanka";
	
	public static LMTPartnerReactivate lmtPartnerReactivate;
	
	@Test
	public void testExchangeCompanyReactive()throws Exception
	{
		lmtPartnerReactivate = new LMTPartnerReactivate();
		lmtPartnerReactivate.initailize();
		lmtPartnerReactivate.Search_Grid_for_ECCode(createdDate, pCode, pName, country, status);
		lmtPartnerReactivate.validateReactivate(PARTNER_REACTIVATE_SUCCESS_MESSAGE);
	}
}
