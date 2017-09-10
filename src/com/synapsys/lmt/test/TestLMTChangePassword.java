package com.synapsys.lmt.test;

import org.testng.annotations.Test;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;
import com.synapsys.lmt.pages.LMTChangePassword;


public class TestLMTChangePassword extends TestBase{
	
	private String OldPassword = "Amila12345678@";
	private String NewPassword = "Amila123456789@";
	private String ConfirmPassword = "Amila123456789@";
	

	public static LMTChangePassword LmtChangePassword;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms() ; 
	public static boolean userName_Availble;
	
	@Test
	public void change_Password_Sucess() throws Exception{
		
			LmtChangePassword = new LMTChangePassword();
			LmtChangePassword.UserName_Availble(USER_NAME);
			LmtChangePassword.Change_Password(OldPassword, NewPassword, ConfirmPassword);
			LmtChangePassword.changepassword_Message(PASSWORD_CHANGE_MESSAGE);
		}
		
	}


