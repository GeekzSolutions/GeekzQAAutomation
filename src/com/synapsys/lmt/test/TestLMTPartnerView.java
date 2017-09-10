package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTPartnerView;
import com.synapsys.lmt.util.TestBase;

public class TestLMTPartnerView extends TestBase
{
	private String date = "17-Feb-2016";
	private String partnerCode="LK001";
	private String partnerName="Sampath Bank PLC";
	private String country="Sri Lanka";
	private String status="New";
	
	private String contactName="RSC Jayasinghe";
	private String contactDesignation="CEO";
	private String contactNo="1234567890";
	private String email="schathurangajayaz@outlook.com";
	private String workarea="Kurunegala";
	
	private String addressl1="No 205";
	private String street="Kandy Road";
	private String city="Mawatagama";
	
	private String regType="Software Firm";
	private String regNo="LK005";
	private String expire="18-Jul-2030";
	private String lexpire="18/07/2030";
	
	private String userName="LK001ChathurJ";
	private String fname="CHATHURANGA";
	private String lname="JAYASINGHE";
	private String passport="PASS12345678";
	private String initial="RS";
	private String id="4805";
	private String telephone="9876543210";
	private String nationality="Sri Lankan";
	
	public static LMTPartnerView lmtPartnerView;
	
	@Test
	public void testPartnerView()throws Exception
	{
		lmtPartnerView = new LMTPartnerView();
		lmtPartnerView.clickBasic();
		lmtPartnerView.Search_Grid_for_Partner_Code(date, partnerCode, partnerName, country, status);
		lmtPartnerView.validatePartnerInfo(partnerCode, partnerName, country, contactName, contactDesignation, contactNo, email, workarea);
		lmtPartnerView.validateContactInfo(addressl1, street, city);
		lmtPartnerView.validateRegistrationInfo(regType, regNo, expire, lexpire);
		lmtPartnerView.validateAdminInfo(userName, fname, lname, passport, initial, id, telephone, email, nationality);
	}
}
