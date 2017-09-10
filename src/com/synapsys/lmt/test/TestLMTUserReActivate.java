package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTUserAuthorizeReActive;
import com.synapsys.lmt.pages.LMTUserReActive;
import com.synapsys.lmt.pages.LmtUserInactive;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;

public class TestLMTUserReActivate extends TestBase{

	private String checkUserNameInGrid="JOHN";
	private String firstName ="JOHN";
	private String lastName ="LAKSHANAA";
	private String email="JOHN@GMAIL.COM";
	private String status="Inactive";
	private String statusActive="ReActive";
	
	private String initials = "S.M.K";
	private String EmpNo ="4092";
	private String identification = "780120086V";
	private String Nationality = "SriLankan";
	private String Entity = "LMT";
	private String Branch = "Galle";
	private String Address = "Galle Fort, Galle";
	//private String Email = "malith@gmail.com";
	private String ContactNo = "0912255126";
	private String Mobile = "0716407114";
	private String PassportNo = "4191MN";
	private String Designation = "MD";
	
	
	public static LMTUserReActive LMTUserReActive;
	public static LMTUserAuthorizeReActive LMTUserAuthorizeReActive;
	public static LMTLoginPage LMTLoginPage;
	
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms();
	
	@Test
	public void test_User_Reactive() throws Exception{		
		LMTUserReActive = new LMTUserReActive();
		LMTUserAuthorizeReActive= new LMTUserAuthorizeReActive();
		LMTLoginPage = new LMTLoginPage();
		LMTUserReActive.click_Basic();
		LMTUserReActive.Search_Grid_for_User_Name(checkUserNameInGrid,firstName,lastName,email,status);
		//LMTUserReActive.Get_Values_According_To_User_Name(checkUserNameInGrid,firstName,lastName,email,status);	
		LMTUserReActive.User_View_After_Grid(checkUserNameInGrid, firstName, lastName, initials, EmpNo, identification, Nationality, Entity, Branch, Address, email, ContactNo, Mobile, PassportNo, Designation);
		LMTUserReActive.User_Inactive_Sucess_Message(USER_INACTIVE_MESSAGE);
		LMTUserAuthorizeReActive.Logout_User();
		LMTUserAuthorizeReActive.Login_With_Valid_Credentials(ADMIN_USER_NAME,ADMIN_PASSWORD);
		LMTUserAuthorizeReActive.click_Basic();
		//LmtUserAuthorize.Calc_Label_Of_Value();
		LMTUserAuthorizeReActive.Search_Grid_for_User_Name(checkUserNameInGrid,firstName,lastName,email,statusActive);
		LMTUserAuthorizeReActive.User_View_After_Grid(checkUserNameInGrid, firstName, lastName, initials, EmpNo, identification, Nationality, Entity, Branch, Address, email, ContactNo, Mobile, PassportNo, Designation);
		LMTUserAuthorizeReActive.User_Authorized_Sucess_Message(USER_AUTHORIZED_SUCESS_MESSAGE);
		LMTUserAuthorizeReActive.Logout_User();
		LMTLoginPage.Login_With_Valid_Credentials(USER_NAME,PASSWORD);
		
}
}
