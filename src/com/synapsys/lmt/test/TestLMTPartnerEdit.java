package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTPartnerEdit;
import com.synapsys.lmt.util.TestBase;

public class TestLMTPartnerEdit extends TestBase
{
	private String createdDate = "10-Feb-2016";
	private String PCode = "LK003";
	private String PName = "SoftGravita";
	private String status = "Active";
	private String country = "Sri Lanka";
	private String newCity = "Colombo";
	
	public static LMTPartnerEdit lmtPartnerEdit;
	
	@Test
	public void testExchangeCompanyEdit()throws Exception
	{
		lmtPartnerEdit.initailize();
		lmtPartnerEdit.Search_Grid_for_ECCode(createdDate, PCode, PName, country, status);
		lmtPartnerEdit.editCompany(newCity);
		lmtPartnerEdit.validateEdit(PARTNER_EDIT_SUCCESS_MESSAGE);
	}
}
