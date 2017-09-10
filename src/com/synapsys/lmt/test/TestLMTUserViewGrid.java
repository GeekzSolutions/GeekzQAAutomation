package com.synapsys.lmt.test;

import org.testng.annotations.Test;
import com.synapsys.lmt.pages.LMTUserViewGrid;
import com.synapsys.lmt.util.LMTCommonTerms;
import com.synapsys.lmt.util.TestBase;

public class TestLMTUserViewGrid extends TestBase{
	
/*	private String checkUserNameInGrid="kushan1";
	private String firstName ="CHAT";
	private String lastName ="RAN";
	private String email="mwkchathuranga1@gmail.com";
	private String status="Active";*/
	
	private String checkUserNameInGrid="JOHN";
	private String firstName ="JOHN";
	private String lastName ="LAKSHANA";
	private String email="JOHN@GMAIL.COM";
	private String status="Active";
	
	/*private String checkUserNameInGrid="Sameera";
	private String firstName ="SAMEERAA";
	private String lastName ="LAKSHAN";
	private String email="fgb@gmail.com";
	private String status="New";
*/

	public static LMTUserViewGrid lmtUserViewGrid;
	public static LMTCommonTerms lMTCommonTerms = new LMTCommonTerms(); 
	
	@Test
	public void test_User_View_Grid_Details() throws Exception{
		lmtUserViewGrid = new LMTUserViewGrid();
		lmtUserViewGrid.click_Basic();
		//lmtUserViewGrid.Calc_Label_Of_Value();
		//lmtUserViewGrid.Get_Values_According_To_User_Name(checkUserNameInGrid);
		lmtUserViewGrid.Search_Grid_for_User_Name(checkUserNameInGrid, firstName, lastName, email, status);
		//lmtUserViewGrid.Verify_User_View_in_Grid(checkUserNameInGrid, firstName, lastName, email, status);
	}
		
	
}
