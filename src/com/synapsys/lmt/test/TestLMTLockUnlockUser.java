package com.synapsys.lmt.test;

import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTLockUnlockUser;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTUserMaintainceViewUser;
import com.synapsys.lmt.pages.LmtLogout;

public class TestLMTLockUnlockUser extends TestBase {

	private String checkUserNameInGrid = "lmtadmin01";
	private String firstName= "LANKA";
	private String LastName="MONEY TRANSFER";
	private String remarks_Lock="User is locked";
	private String remarks_UnLock="User is Unlocked";
	
	public static LMTLockUnlockUser LMTLockUnlockUser;
	public static LmtLogout LmtLogout;
	public static LMTLoginPage LMTLoginPage;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms() ; 
	
	@Test
	public void test_Lock_in_user_maintaince() throws Exception{
		
		LMTLockUnlockUser = new LMTLockUnlockUser();
		LmtLogout = new LmtLogout();
		LMTLoginPage = new LMTLoginPage();
		LMTLockUnlockUser.click_Basic();
		LMTLockUnlockUser.Search_Grid_for_User_Name(checkUserNameInGrid, firstName, LastName);
		LMTLockUnlockUser.User_Lock_Sucess(checkUserNameInGrid, remarks_Lock);
		LMTLockUnlockUser.User_Locked_Sucess_Message(USER_LOCK_SUCESSFULLY_MESSAGE);
		
		
		}
	
	@Test
	public void test_Unlock_in_user_maintaince() throws Exception{
		//Unlock
				LmtLogout.Logout_User();
				LMTLoginPage.Login_With_Valid_Credentials(ADMIN_USER_NAME, ADMIN_PASSWORD);
				//LMTLoginPage.Login_With_Valid_Credentials(USER_NAME, PASSWORD);
				LMTLockUnlockUser.click_Basic();
				LMTLockUnlockUser.Search_Grid_for_User_Name(checkUserNameInGrid, firstName, LastName);
				LMTLockUnlockUser.User_Lock_Sucess(checkUserNameInGrid, remarks_UnLock);
				LMTLockUnlockUser.User_Locked_Sucess_Message(USER_UNLOCK_SUCESSFULLY_MESSAGE);
	}
}
