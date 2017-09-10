package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTExchangeCompanyAuthorize;
import com.synapsys.lmt.util.TestBase;


public class TestLMTExchangeCompanyAuthorize extends TestBase
{
	public static LMTExchangeCompanyAuthorize lmtExchangeAuthorize;
	
	private String createdDate = "09-Feb-2016";
	private String ECCode = "LK002";
	private String ECName = "SoftGravita";
	private String status = "New";
	private String country = "Sri Lanka";
	
	@Test
	public void testExchangeCompanyAutorize()throws Exception
	{
		lmtExchangeAuthorize = new LMTExchangeCompanyAuthorize();
		lmtExchangeAuthorize.initailizeAuthorize();
		lmtExchangeAuthorize.Search_Grid_for_ECCode(createdDate, ECCode, ECName, country, status);
		lmtExchangeAuthorize.validateAuthorize(EXCHANGE_COMPANY_AUTHORIZE_SUCCESS_MESSAGE);
	}
}
