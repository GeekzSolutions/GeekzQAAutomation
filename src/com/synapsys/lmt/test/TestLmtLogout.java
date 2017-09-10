package com.synapsys.lmt.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.synapsys.lmt.lib.SeleniumBase;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LmtLogout;
import com.synapsys.lmt.util.LMTCommonTerms;

public class TestLmtLogout extends SeleniumBase{
	public static LmtLogout lMTLogout;
	public static LMTLoginPage lMTLoginPage;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms() ; 
	public static WebDriver driver ;
	
	@Test
	public void testLogout_User(){	
		try{
			//
			lMTLogout = new LmtLogout();
			lMTLoginPage = lMTLogout.Logout_User();
			lMTLoginPage.isSuccessfullyLogged_Out();
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
}
	
	
	
}