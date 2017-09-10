package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTPartnerCreate;
import com.synapsys.lmt.util.TestBase;

public class TestLMTPartnerCreate extends TestBase
{
	private String PBankName = "Bank of LMT";
	private String Country = "Sri Lanka";
	private String DVBBranch = "Kurunegala";
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
	
	public static LMTPartnerCreate lmtPartnerCreate;
	
	@Test
	public void testPartnerCreate()throws Exception
	{
		lmtPartnerCreate = new LMTPartnerCreate();
		lmtPartnerCreate.clickBasic();
		lmtPartnerCreate.generalInfo(PBankName, Country, DVBBranch, CPName, CPCNo, WorkArea, Designation, AdminEmail);
		lmtPartnerCreate.contactDetails(AddressL1, AddressL2, City, ContactDetail, ContactType);
		lmtPartnerCreate.adminInfo(RegType, RegNo, LicenseExpire, PassportNo, UserName, FName, LName, Initial, ID, Telephone, Email, Nationality);
		lmtPartnerCreate.validateCreate(PARTNER_CREATE_SUCCESS_MESSAGE);
		
	}
}
