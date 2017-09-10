package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTPartnerAuthorize;
import com.synapsys.lmt.util.TestBase;

public class TestLMTPartnerAuthorize extends TestBase
{
	private String createdDate = "09-Feb-2016";
	private String pCode = "LK002";
	private String pName = "SoftGravita";
	private String status = "New";
	private String country = "Sri Lanka";
	
	public static LMTPartnerAuthorize lmtPartnerAuthorize;
	
	
	@Test
	public void testExchangeCompanyAutorize()throws Exception
	{
		lmtPartnerAuthorize = new LMTPartnerAuthorize();
		lmtPartnerAuthorize.initailizeAuthorize();
		lmtPartnerAuthorize.Search_Grid_for_PCode(createdDate, pCode, pName, country, status);
		lmtPartnerAuthorize.validateAuthorize(PARTNER_AUTHORIZE_SUCCESS_MESSAGE);
	}
}
