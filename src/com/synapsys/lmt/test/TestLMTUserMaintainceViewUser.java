package com.synapsys.lmt.test;

import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTUserMaintainceViewUser;

public class TestLMTUserMaintainceViewUser extends TestBase {

	private String checkUserNameInGrid = "lmt1";
	private String firstName = "TEST";
	private String LastName = "001";
	private String initials = "T";
	private String empNo ="0020";
	private String identification = "752135679V";
	private String nationality = "Sri Lanka";
	private String entity = "LMT";
	private String branch = "BANK OF COLOMBO";
	private String address = "Colombo";
	private String email = "test1@gmail.com";
	private String contactNo = "0741454678";
	private String mobile = "0754648542";
	private String passportNo = "N84564548484";
	private String designation = "Officer";
	
	public static LMTUserMaintainceViewUser LMTUserMaintainceViewUser;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms() ; 
	
	@Test
	public void test_user_view_in_user_maintaince() throws Exception{
		
		LMTUserMaintainceViewUser = new LMTUserMaintainceViewUser();
		LMTUserMaintainceViewUser.click_Basic();
		LMTUserMaintainceViewUser.Search_Grid_for_User_Name(checkUserNameInGrid, firstName, LastName);
		//LMTUserMaintainceViewUser.Verify_User_View_in_Grid(checkUserNameInGrid, firstName, LastName);
		LMTUserMaintainceViewUser.User_View_After_Grid(checkUserNameInGrid, firstName, LastName, initials, empNo, identification, nationality, entity, branch, address, email, contactNo, mobile, passportNo, designation);
	}
}
