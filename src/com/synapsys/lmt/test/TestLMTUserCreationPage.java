package com.synapsys.lmt.test;

import org.testng.annotations.Test;
import com.synapsys.lmt.pages.LMTUserCreationPage;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;

public class TestLMTUserCreationPage extends TestBase {
	
	private String USER_NAME1="JOHN";
	private String FIRST_NAME1="JOHN";
	private String LAST_NAME1="LAKSHANA";
	private String INITILAS="S.M.K";
	private String EMP_NO="4092";
	private String IDENTIFICATION="780120086V";
	private String NATIONALITY="Ind";
	private String ENTITY="LMT";
	private String BRANCH2="Ampara";
	private String ADDRESS="No6, Ampara";
	private String EMAIL="JOHN@GMAIL.COM";
	private String CONTACT_NO="0119528263";
	private String MOBILE="0719821063";  
	private String PASSPORT="4191MN";
	private String DESIGNATION="SE";
	
	
	public static LMTUserCreationPage lMTUserCreationPage;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms() ; 

	@Test
	public void LMTUserCreation_sucess() throws Exception{			
			lMTUserCreationPage = new LMTUserCreationPage();
			lMTUserCreationPage.CreateLMTUser(USER_NAME1,FIRST_NAME1,LAST_NAME1,INITILAS,EMP_NO,IDENTIFICATION,NATIONALITY,ENTITY,BRANCH2,ADDRESS,EMAIL,CONTACT_NO,MOBILE,PASSPORT,DESIGNATION);
			lMTUserCreationPage.Is_User_Register_Sucees(USER_CREATION_SUCESS_MESSAGE);
	}
		
		}
		
	
	

