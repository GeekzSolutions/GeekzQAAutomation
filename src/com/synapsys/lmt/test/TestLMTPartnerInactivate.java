package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTPartnerInactivate;
import com.synapsys.lmt.util.TestBase;

public class TestLMTPartnerInactivate extends TestBase
{
	private String createdDate = "10-Feb-2016";
	private String pCode = "LK003";
	private String pName = "SynapSys";
	private String status = "Active";
	private String country = "Sri Lanka";
	
	public static LMTPartnerInactivate lmtPartnerInactivate;
	
	@Test
	public void testExchangeCompanyInactivate()throws Exception
	{
		lmtPartnerInactivate = new LMTPartnerInactivate();
		lmtPartnerInactivate.initailize();
		lmtPartnerInactivate.Search_Grid_for_ECCode(createdDate, pCode, pName, country, status);
		lmtPartnerInactivate.validateInactivate(PARTNER_INACTIVATE_SUCCESS_MESSAGE);
	}
}
