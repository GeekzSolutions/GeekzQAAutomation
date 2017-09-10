package com.synapsys.lmt.test;

import javax.management.loading.PrivateClassLoader;

import org.testng.annotations.Test;
import com.synapsys.lmt.util.TestBase;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.pages.LMTUserViewAfterGrid;

public class TestLMTUserViewAfterGrid extends TestBase {
	
/*	private String checkUserNameInGrid = "lmt1";
	private String firstName = "TEST";
	private String LastName = "001";
	private String initials = "T";
	private String EmpNo ="0020";
	private String identification = "752135679V";
	private String Nationality = "Sri Lanka";
	private String Entity = "LMT";
	private String Branch = "BANK OF COLOMBO";
	private String Address = "Colombo";
	private String Email = "test1@gmail.com";
	private String ContactNo = "0741454678";
	private String Mobile = "0754648542";
	private String PassportNo = "N84564548484";
	private String Designation = "Officer";*/
	
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
	
	public static LMTUserViewAfterGrid LmtUserViewAfterGrid;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms(); 

	@Test
	public void test_User_Details_After_Grid() throws Exception{
		LmtUserViewAfterGrid = new LMTUserViewAfterGrid();
		LmtUserViewAfterGrid.click_Basic();
		//LmtUserViewAfterGrid.Calc_Label_Of_Value();
		LmtUserViewAfterGrid.Search_Grid_for_User_Name(checkUserNameInGrid);
		//LmtUserViewAfterGrid.Get_User_View_According_To_User_Name(checkUserNameInGrid);
		LmtUserViewAfterGrid.User_View_After_Grid(checkUserNameInGrid, firstName, LastName, initials, EmpNo, identification, Nationality, Entity, Branch, Address, Email, ContactNo, Mobile, PassportNo, Designation);
		
		
	}
}
