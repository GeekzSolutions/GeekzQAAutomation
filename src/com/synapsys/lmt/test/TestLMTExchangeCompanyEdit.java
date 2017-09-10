package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTExchangeCompanyEdit;
import com.synapsys.lmt.util.TestBase;


public class TestLMTExchangeCompanyEdit extends TestBase
{
	public static LMTExchangeCompanyEdit lmtExchangeCompanyEdit;
	private String createdDate = "10-Feb-2016";
	private String ECCode = "LK003";
	private String ECName = "SoftGravita";
	private String status = "Active";
	private String country = "Sri Lanka";
	private String newCity = "Colombo";
	
	
	@Test
	public void testExchangeCompanyEdit()throws Exception
	{
		lmtExchangeCompanyEdit = new LMTExchangeCompanyEdit();
		lmtExchangeCompanyEdit.initailize();
		lmtExchangeCompanyEdit.Search_Grid_for_ECCode(createdDate, ECCode, ECName, country, status);
		lmtExchangeCompanyEdit.editCompany(newCity);
		lmtExchangeCompanyEdit.validateEdit(EXCHANGE_COMPANY_EDIT_SUCCESS_MESSAGE);
	}
}
