package com.synapsys.lmt.test;

import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTActivateEntityUsers;
import com.synapsys.lmt.pages.LMTLockUnlockUser;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LmtLogout;

public class TestLMTActivateEntityUsers extends TestBase{
	
	private String checkUserNameInGrid="JP018lmtexcom";
	private String firstName="LMT";
	private String lastName="EXCOM";
	private String passportNo="N14256987553";
	private String email="nuwancha@gmail.com";
	private String intials="E";
	private String empNo="1835196982";
	private String ExchangeCompany="ICS Exchange Company1";
		
	public static LMTActivateEntityUsers LMTActivateEntityUsers;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms() ; 
	
	@Test
	public void test_Entity_Activation_Sucess() throws Exception{
		
		LMTActivateEntityUsers = new LMTActivateEntityUsers();
		LMTActivateEntityUsers.click_Basic();
		LMTActivateEntityUsers.Search_Grid_for_User_Name(checkUserNameInGrid, firstName, lastName, passportNo, email);
		LMTActivateEntityUsers.User_View_After_Grid(checkUserNameInGrid, firstName, lastName, intials, empNo, ExchangeCompany, email, passportNo);
		LMTActivateEntityUsers.Entity_Activated_Sucess_Message(USER_ENTITY_ACTIVATION_MESSAGE);
				
		}

}
