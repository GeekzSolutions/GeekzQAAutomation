package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTExchangeCompanyACSettingsView;
import com.synapsys.lmt.util.TestBase;

public class TestLMTExchangeCompanyACSettingsView extends TestBase
{
	private String businessEntityName = "SynapSys";
	private String acNo = "922591652001";
	private String acName = "SynapSys";
	private String type = "Saving";
	private String bookType = "DBU";
	private String currency = "Sri Lanka Rupee (LKR)";
	private String status = "Active";
	
	public static LMTExchangeCompanyACSettingsView lmtECACSettingsView;
	
	@Test
	public void testACSettingsView()throws Exception
	{
		lmtECACSettingsView = new LMTExchangeCompanyACSettingsView();
		lmtECACSettingsView.initailize();
		lmtECACSettingsView.Search_Grid_for_BEName(businessEntityName);
		lmtECACSettingsView.Search_Grid_for_ACNo(acNo, acName, type, bookType, currency, status);
	}
}
