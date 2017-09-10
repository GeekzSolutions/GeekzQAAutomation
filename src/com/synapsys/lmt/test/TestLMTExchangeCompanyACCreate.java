package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTExchangeCompanyACCreate;
import com.synapsys.lmt.util.TestBase;

public class TestLMTExchangeCompanyACCreate extends TestBase
{
	private String accNo = "98765432155";
	private String accType = "Saving";
	private String accBookType = "DBU";
	private String currency = "US Dollar (USD)";
	private String businessEntityName = "Synapsys";
	
	public static LMTExchangeCompanyACCreate lmtExchangeCompanyACCreate;
	
	@Test
	public void test_ACCreate()throws Exception
	{
		lmtExchangeCompanyACCreate = new LMTExchangeCompanyACCreate();
		lmtExchangeCompanyACCreate.initailize();
		lmtExchangeCompanyACCreate.Search_Grid_for_BEName(businessEntityName);
		lmtExchangeCompanyACCreate.createAccount(accNo, accType, accBookType, currency);
		lmtExchangeCompanyACCreate.validateACCreate(EXCHANGE_COMPANY_ACCREATE_SUCCESS_MESSAGE);
	}
}
