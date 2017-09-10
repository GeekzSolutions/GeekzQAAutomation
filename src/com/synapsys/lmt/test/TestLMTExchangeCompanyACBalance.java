package com.synapsys.lmt.test;

import com.synapsys.lmt.pages.LMTExchangeCompanyACBalance;
import com.synapsys.lmt.util.TestBase;

public class TestLMTExchangeCompanyACBalance extends TestBase
{
	private String BEName = "SynapSys";
	private String AccNo = "922591652001";
	private String AccName = "SynapSys";
	private String Type = "Saving";
	private String BookType = "DBU";
	private String Currency = "Sri Lanka Rupee (LKR)";
	private String AvailableBalance = "0.00";
	
	public static LMTExchangeCompanyACBalance lmtExchangeCompanyACBalance;
	
	public void testACBalanceView()
	{
		lmtExchangeCompanyACBalance = new LMTExchangeCompanyACBalance();
		lmtExchangeCompanyACBalance.initailizeAuthorize();
		lmtExchangeCompanyACBalance.Single_Page_Search(BEName);
		lmtExchangeCompanyACBalance.Single_Page_SearchAcc(AccNo, AccName, Type, BookType, Currency, AvailableBalance);
		lmtExchangeCompanyACBalance.viewAcc();
	}

}
