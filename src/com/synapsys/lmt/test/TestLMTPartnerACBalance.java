package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTPartnerACBalance;
import com.synapsys.lmt.util.TestBase;

public class TestLMTPartnerACBalance extends TestBase
{
	private String BEName = "SynapSys";
	private String AccNo = "922591652001";
	private String AccName = "SynapSys";
	private String Type = "Saving";
	private String BookType = "DBU";
	private String Currency = "Sri Lanka Rupee (LKR)";
	private String AvailableBalance = "0.00";
	
	public static LMTPartnerACBalance lmtPartnerACBalance;
	
	@Test
	public void testACBalanceView()
	{
		lmtPartnerACBalance = new LMTPartnerACBalance();
		lmtPartnerACBalance.initailizeAuthorize();
		lmtPartnerACBalance.Single_Page_Search(BEName);
		lmtPartnerACBalance.Single_Page_SearchAcc(AccNo, AccName, Type, BookType, Currency, AvailableBalance);
		lmtPartnerACBalance.viewAcc();
	}
	
	
}
