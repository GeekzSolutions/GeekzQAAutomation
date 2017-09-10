package com.synapsys.lmt.test;

import java.text.Format;
import java.text.SimpleDateFormat;
//import java.util.Date;

import com.synapsys.lmt.lib.SeleniumBase;
import com.synapsys.lmt.pages.LMTExchangeCompanyView;

import org.testng.annotations.Test;

public class TestLMTExchangeCompanyView extends SeleniumBase
{
	Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
	//private String date = formatter.format(new Date());
	private String date = "27-Jan-2016";
	private String companyCode="LK001";
	private String companyName="Leon Corp";
	private String country="Sri Lanka";
	private String status="New";
	
	private String contactName="S Chathuranga Jayasinghe";
	private String contactDestination="CEO";
	private String contactNo="0788852747";
	private String email="schathurangajayaz@outlook.com";
	private String workarea="Kurunegala";
	private String addressl1="\"Sandun Sevana\"";
	private String addressl2="Pussalla, Pussali Thanna";
	private String city="Kurunegala";
	private String regType="Software Firm";
	private String regNo="SF001";
	private String expire="08-Jan-2021";
	private String lexpire="08/01/2021";
	private String userName="LK001Chathuranga";
	private String fname="CHATHURANGA";
	private String lname="JAYASINGHE";
	private String passport="PASS12345678";
	private String initial="RS";
	private String id="922591652V";
	private String telephone="0788852747";
	private String nationality="Sri Lankan";
	
	
	public static LMTExchangeCompanyView lMTExchangeCompanyView;
	
	@Test
	public void testExchangeComapnyView()throws Exception
	{
		lMTExchangeCompanyView = new LMTExchangeCompanyView();
		lMTExchangeCompanyView.clickBasic();
		lMTExchangeCompanyView.Search_Grid_for_BE_Code(date, companyCode, companyName, country, status);
		lMTExchangeCompanyView.validateCompanyInfo(companyCode, companyName, country, contactName, contactDestination, contactNo, email, workarea);
		lMTExchangeCompanyView.validateContactInfo(addressl1, addressl2, city);
		lMTExchangeCompanyView.validateRegistrationInfo(regType, regNo, expire, lexpire);
		lMTExchangeCompanyView.validateAdminInfo(userName, fname, lname, passport, initial, id, telephone, email, nationality);
	}

}
