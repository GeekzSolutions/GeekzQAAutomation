package com.synapsys.lmt.test;

import org.testng.annotations.Test;
import com.synapsys.lmt.pages.LMTDashBoardPage;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;


public class TestLMTLoginPage extends TestBase{

	public static LMTLoginPage lMTLoginPage;
	public static LMTDashBoardPage lMTDashBoardPage ;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms() ; 
	
	@Test
	public void testLogin_With_Valid_Credentials() throws Exception{	
		//try{
			lMTLoginPage = new LMTLoginPage();
			lMTDashBoardPage = lMTLoginPage.Login_With_Valid_Credentials(USER_NAME,PASSWORD);
			lMTDashBoardPage.isSuccessfullyLogged(FULL_NAME, BRANCH);
			
		//}catch(Exception ex){
			//System.out.println(ex.getMessage());
	//	}
		
	}
	
	
}
