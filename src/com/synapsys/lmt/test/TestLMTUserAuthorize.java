package com.synapsys.lmt.test;

import com.synapsys.lmt.pages.LMTDashBoardPage;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTUserAuthorize;
import com.synapsys.lmt.pages.LMTUserViewAfterGrid;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;
import org.testng.annotations.Test;

public class TestLMTUserAuthorize extends TestBase {	

	private String checkUserNameInGrid = "JOHN";
	private String firstName = "JOHN";
	private String LastName = "LAKSHANA";
	private String status="New";
	private String initials = "S.M.K";
	private String EmpNo ="4092";
	private String identification = "780120086V";
	private String Nationality = "Ind";
	private String Entity = "LMT";
	private String Branch = "Ampara";
	private String Address = "No6, Ampara";
	private String Email = "JOHN@GMAIL.COM";
	private String ContactNo = "0119528263";
	private String Mobile = "0719821063";
	private String PassportNo = "4191MN";
	private String Designation = "SE";
	
	public static LMTUserAuthorize LmtUserAuthorize;
	public static LMTLoginPage lMTLoginPage;
	public static LMTDashBoardPage lMTDashBoardPage ;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms();
	
	@Test
	public void test_Authorized_User_By_Admin() throws Exception{
		
		LmtUserAuthorize = new LMTUserAuthorize();
		lMTLoginPage = new LMTLoginPage();
		lMTDashBoardPage = new LMTDashBoardPage();
		
		lMTLoginPage = LmtUserAuthorize.Logout_User();
		lMTDashBoardPage = LmtUserAuthorize.Login_With_Valid_Credentials(ADMIN_USER_NAME, ADMIN_PASSWORD);
		lMTDashBoardPage.isSuccessfullyLogged(ADMIN_FULLNAME, ADMIN_BRANCH);
		LmtUserAuthorize.click_Basic();
		//LmtUserAuthorize.Calc_Label_Of_Value();
		LmtUserAuthorize.Search_Grid_for_User_Name(checkUserNameInGrid, firstName, LastName, Email, status);
		//LmtUserAuthorize.Get_Values_According_To_User_Name(checkUserNameInGrid,firstName,LastName,Email,status);
		//LmtUserAuthorize.Verify_User_View_in_Grid(checkUserNameInGrid,firstName,LastName,Email,status);
		LmtUserAuthorize.User_View_After_Grid(checkUserNameInGrid, firstName, LastName, initials, EmpNo, identification, Nationality, Entity, Branch, Address, Email, ContactNo, Mobile, PassportNo, Designation);
		LmtUserAuthorize.User_Authorized_Sucess_Message(USER_AUTHORIZED_SUCESS_MESSAGE);
		lMTLoginPage = LmtUserAuthorize.Logout_User();
		lMTDashBoardPage = LmtUserAuthorize.Login_With_Valid_Credentials(USER_NAME, PASSWORD);
	}
}
