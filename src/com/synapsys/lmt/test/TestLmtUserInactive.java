package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTUserAuthorizeInactive;
import com.synapsys.lmt.pages.LMTUserEdit;
import com.synapsys.lmt.pages.LmtUserInactive;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;

public class TestLmtUserInactive extends TestBase{
	
	private String checkUserNameInGrid="JOHN";
	private String firstName ="JOHN";
	private String lastName ="LAKSHANAA";
	private String email="JOHN@GMAIL.COM";
	private String status="Active";
	private String statusIanctive="Inactive";
	
	private String initials = "S.M.K";
	private String EmpNo ="4092";
	private String identification = "780120086V";
	private String Nationality = "SriLankan";
	private String Entity = "LMT";
	private String Branch = "Galle";
	private String Address = "Galle Fort, Galle";
	private String Email = "JOHN@GMAIL.COM";
	private String ContactNo = "0912255126";
	private String Mobile = "0716407114";
	private String PassportNo = "4191MN";
	private String Designation = "MD";
	
	public static LmtUserInactive LmtUserInactive;
	public static LMTUserAuthorizeInactive LMTUserAuthorizeInactive;
	public static LMTLoginPage LMTLoginPage;
	
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms();
	
	@Test
	public void test_User_Inactive() throws Exception{		
		LmtUserInactive = new LmtUserInactive();
		LMTUserAuthorizeInactive= new LMTUserAuthorizeInactive();
		LMTLoginPage = new LMTLoginPage();
		LmtUserInactive.click_Basic();
		//LmtUserInactive.Calc_Label_Of_Value();
		LmtUserInactive.Search_Grid_for_User_Name(checkUserNameInGrid, firstName, lastName, Email, status);
		//LmtUserInactive.Get_Values_According_To_User_Name(checkUserNameInGrid,firstName,lastName,email,status);	
		LmtUserInactive.User_View_After_Grid(checkUserNameInGrid, firstName, lastName, initials, EmpNo, identification, Nationality, Entity, Branch, Address, email, ContactNo, Mobile, PassportNo, Designation);
		LmtUserInactive.User_Inactive_Sucess_Message(USER_INACTIVE_MESSAGE);
		LMTUserAuthorizeInactive.Logout_User();
		LMTUserAuthorizeInactive.Login_With_Valid_Credentials(ADMIN_USER_NAME,ADMIN_PASSWORD);
		LMTUserAuthorizeInactive.click_Basic();
		//LMTUserAuthorizeInactive.Calc_Label_Of_Value();
		LMTUserAuthorizeInactive.Search_Grid_for_User_Name(checkUserNameInGrid, firstName, lastName, Email, statusIanctive);
		//LMTUserAuthorizeInactive.Get_Values_According_To_User_Name(checkUserNameInGrid,firstName,lastName,email,statusIanctive);
		LMTUserAuthorizeInactive.User_View_After_Grid(checkUserNameInGrid, firstName, lastName, initials, EmpNo, identification, Nationality, Entity, Branch, Address, Email, ContactNo, Mobile, PassportNo, Designation);
		LMTUserAuthorizeInactive.User_Authorized_Sucess_Message(USER_AUTHORIZED_SUCESS_MESSAGE);
		LMTUserAuthorizeInactive.Logout_User();
		LMTLoginPage.Login_With_Valid_Credentials(USER_NAME,PASSWORD);
		
}
	
}
