package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTDashBoardPage;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTRollCreationPage;
import com.synapsys.lmt.pages.LmtLogout;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;

public class TestLmtRollCreationPage extends TestBase{

	public static LMTRollCreationPage lmtRollCreationPage;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms(); 
	public static LmtLogout lMTLogout;
	public static LMTLoginPage lMTLoginPage;
	public static LMTDashBoardPage lMTDashBoardPage;
	
	//
	private String BusinesEntity="LMT" ;
	private String RoleName="Customer Officer 52";
	private String RoleNameWithSpecialCharacters="Customer Officer-1!@#$%^&*()_+=";
	
	@Test
	public void Role_creation_sucess() throws Exception
	{		
		lmtRollCreationPage = new LMTRollCreationPage();
		lmtRollCreationPage.Role_created(BusinesEntity, RoleName);
		lmtRollCreationPage.Is_Role_Created(RoleSucessfullyCreatedMessage);
	}
	
	
	//Duplicate the roll creation
	@Test
	public void Role_Creation_Duplicate() throws Exception{
		lmtRollCreationPage = new LMTRollCreationPage();
		//lmtRollCreationPage.Duplicate_Role_created(BusinesEntity, RoleName);
		lmtRollCreationPage.Is_Role_Duplicated(ROlE_DUPLICATE_MESSAGE);
	}
	
	//Role created with special characters
	@Test
	public void Is_Role_Creates_With_Special_Characters()throws Exception{
		lmtRollCreationPage = new LMTRollCreationPage();
		lmtRollCreationPage.Duplicate_Role_created(BusinesEntity, RoleNameWithSpecialCharacters);
		lmtRollCreationPage.Is_Role_Creates_With_Special_Characters();
		
		lMTLogout = new LmtLogout();
		lMTLoginPage = lMTLogout.Logout_User();
		lMTLoginPage.isSuccessfullyLogged_Out();
		
		//login with admin (other user)
		lMTLoginPage = new LMTLoginPage();
		lMTDashBoardPage = new LMTDashBoardPage();
		lMTDashBoardPage = lMTLoginPage.Login_With_Valid_Credentials(ADMIN_USER_NAME,ADMIN_PASSWORD);
		lMTDashBoardPage.isSuccessfullyLogged(ADMIN_FULLNAME, ADMIN_BRANCH);
	}
	
	
}
