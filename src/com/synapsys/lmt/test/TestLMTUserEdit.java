package com.synapsys.lmt.test;

import com.synapsys.lmt.pages.LMTDashBoardPage;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LMTUserAuthorizeEdit;
import com.synapsys.lmt.pages.LMTUserEdit;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;
import org.testng.annotations.Test;
import com.synapsys.lmt.pages.LMTUserEdit;

public class TestLMTUserEdit extends TestBase{
	
	private String checkUserNameInGrid="JOHN";
	private String firstName ="JOHN";
	private String lastName ="LAKSHANA";
	private String email="JOHN@GMAIL.COM";
	private String status="Active";
	private String statusAfter="Modified";
	
	private String upd_firstName="JOHN";
	private String upd_lastName="LAKSHANAA";
	private String upd_initials="S.M.K";
	private String upd_empNo="4092";
	private String upd_identification="780120086V";
	private String upd_nationality="SriLankan";
	private String upd_entity="LMT";
	private String upd_branch="Galle";
	private String upd_address="Galle Fort, Galle";
	private String upd_email="JOHN@GMAIL.COM";
	private String upd_conNo="0912255126";
	private String upd_mobile="0716407114";
	private String upd_passport="4191MN";
	private String upd_designation="MD";

	public static LMTUserEdit lmtUserEdit;	
	public static LMTUserAuthorizeEdit LMTUserAuthorizeEdit;
	public static LMTLoginPage lMTLoginPage;
	public static LMTDashBoardPage lMTDashBoardPage ;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms();
	
	@Test
	public void test_User_Edit() throws Exception{		
	lmtUserEdit = new LMTUserEdit();
	lMTLoginPage = new LMTLoginPage();
	LMTUserAuthorizeEdit = new LMTUserAuthorizeEdit();
	lmtUserEdit.click_Basic();
	//lmtUserEdit.Calc_Label_Of_Value();
	lmtUserEdit.Search_Grid_for_User_Name(checkUserNameInGrid, firstName, lastName, email, status);
	//lmtUserEdit.Get_Values_According_To_User_Name(checkUserNameInGrid,firstName,lastName,email,status);	
	lmtUserEdit.UpdateLMTUser(upd_firstName,upd_lastName,upd_initials,upd_empNo,upd_identification,upd_nationality,upd_entity,upd_branch,upd_address,upd_email,upd_conNo,upd_mobile,upd_passport,upd_designation);
	lmtUserEdit.User_Authorized_Sucess_Message(USER_SUCESSFULLY_UPDATED_MESSAGE);
	
	lMTLoginPage = LMTUserAuthorizeEdit.Logout_User();
	lMTDashBoardPage = LMTUserAuthorizeEdit.Login_With_Valid_Credentials(ADMIN_USER_NAME, ADMIN_PASSWORD);
	lMTDashBoardPage.isSuccessfullyLogged(ADMIN_FULLNAME, ADMIN_BRANCH);
	LMTUserAuthorizeEdit.click_Basic();
	//LMTUserAuthorizeEdit.Calc_Label_Of_Value();
	LMTUserAuthorizeEdit.Search_Grid_for_User_Name(checkUserNameInGrid, upd_firstName, upd_lastName, upd_email, statusAfter);
	//LMTUserAuthorizeEdit.Get_Values_According_To_User_Name(checkUserNameInGrid,upd_firstName,upd_lastName,upd_email,statusAfter);
	//LmtUserAuthorize.Verify_User_View_in_Grid(checkUserNameInGrid,firstName,LastName,Email,status);
	LMTUserAuthorizeEdit.User_View_After_Grid(checkUserNameInGrid, upd_firstName,upd_lastName,upd_initials,upd_empNo,upd_identification,upd_nationality,upd_entity,upd_branch,upd_address,upd_email,upd_conNo,upd_mobile,upd_passport,upd_designation);
	LMTUserAuthorizeEdit.User_Authorized_Sucess_Message(USER_AUTHORIZED_SUCESS_MESSAGE);
	lMTLoginPage = LMTUserAuthorizeEdit.Logout_User();
	lMTDashBoardPage = LMTUserAuthorizeEdit.Login_With_Valid_Credentials(USER_NAME, PASSWORD);
}
	
}
