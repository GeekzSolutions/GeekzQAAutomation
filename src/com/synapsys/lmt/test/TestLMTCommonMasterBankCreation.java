package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTCommonMasterBankCreation;
import com.synapsys.lmt.util.TestBase;

public class TestLMTCommonMasterBankCreation extends TestBase
{
	private String code = "9999";
	private String name = "Bank Mawathagama";
	private String address = "Kandy Road, Mawathagama";
	private String contactNo = "0123456789";
	private String specialName = "Bank &@#";
	
	public static LMTCommonMasterBankCreation lMTCommonMasterBankCreation;
	
	@Test
	public void test_Bank_Creation()throws Exception
	{
		lMTCommonMasterBankCreation = new LMTCommonMasterBankCreation();
		lMTCommonMasterBankCreation.createBank(code, name, address, contactNo);
		lMTCommonMasterBankCreation.isBankCreated(BANK_CREATE_SUCCESS_MSG);
		
	}
	
	@Test
	public void test_Bank_Duplication()throws Exception
	{
		lMTCommonMasterBankCreation = new LMTCommonMasterBankCreation();
		lMTCommonMasterBankCreation.duplicateBankCodeCreated(code, name, address, contactNo);
		lMTCommonMasterBankCreation.isBankCodeDuplicated(BANK_CODE_DUPLICATED_MSG);
	}
	
	@Test
	public void test_Bank_Creation_with_Special_Characters()throws Exception
	{
		lMTCommonMasterBankCreation = new LMTCommonMasterBankCreation();
		lMTCommonMasterBankCreation.duplicateBankCodeCreated(code, specialName, address, contactNo);
		lMTCommonMasterBankCreation.isBankCreatewithSpecialCharacters();
	}

}
