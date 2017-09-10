package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTExchangeCompanyCreate;
import com.synapsys.lmt.util.TestBase;


public class TestLMTExchangeCompanyAdd extends TestBase
{
	private String ECName = "SynapSys";
	private String Country = "Sri Lanka";
	private String CPName = "Chathuranga";
	private String CPCNo = "0713585414";
	private String WorkArea = "Kurunegala";
	private String Designation = "QA Engineer";
	private String Email = "schathurangajayaz@outlook.com";
	private String AddressL1 = "Sandun Sevana";
	private String AddressL2 = "Pussalla, Pussali Thanna";
	private String City = "Kurunegala";
	private String ContactType = "Mobile";
	private String ContactDetail = "0713585414";
	private String RegType = "Software Firm";
	private String RegNo = "LK002";
	private String LicenseExpire = "12/12/2020";
	private String PassportNo = "pass123456";
	private String UserName = "SChathuranga";
	private String FName = "Chathuranga";
	private String LName = "Jayasinghe";
	private String Initial = "RS";
	private String ID = "942591652V";
	private String Telephone = "0713585414";
	private String AdminEmail = "schathurangajayaz@outlook.com";
	private String Nationality = "Sinhalese";
	
	public static LMTExchangeCompanyCreate lmtExchangeCompanyCreate;
	
	@Test
	public void testExchangeCompanyCreate()throws Exception
	{
		lmtExchangeCompanyCreate = new LMTExchangeCompanyCreate();
		lmtExchangeCompanyCreate.clickBasic();
		lmtExchangeCompanyCreate.generalInfo(ECName, Country, CPName, CPCNo, WorkArea, Designation, Email);
		lmtExchangeCompanyCreate.contactDetails(AddressL1, AddressL2, City, ContactDetail, ContactType);
		lmtExchangeCompanyCreate.adminInfo(RegType, RegNo, LicenseExpire, PassportNo, UserName, FName, LName, Initial, ID, Telephone, AdminEmail, Nationality);
		lmtExchangeCompanyCreate.validateCreate(EXCHANGE_COMPANY_SUCCESS_MESSAGE);
	}

}
