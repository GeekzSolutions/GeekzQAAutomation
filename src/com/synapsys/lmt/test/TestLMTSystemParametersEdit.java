package com.synapsys.lmt.test;

import org.testng.annotations.Test;

import com.synapsys.lmt.util.TestBase;
import com.synapsys.lmt.pages.LMTSystemParameterEdit;

public class TestLMTSystemParametersEdit extends TestBase
{
	private String ParameterID = "2017";
	private String ParameterHeaderName = "Test@2";
	private String ParameterDetail = "0123456789";
	private String NewHeaderDetail = "abcdefg";
	
	public static LMTSystemParameterEdit lMTSystemParameterEdit;
	
	@Test
	public void test_System_Parameter_Edit() throws Exception
	{
		lMTSystemParameterEdit = new LMTSystemParameterEdit();
		lMTSystemParameterEdit.clickBasic();
		lMTSystemParameterEdit.Search_Grid_for_Parameter_Name(ParameterID, ParameterHeaderName, ParameterDetail);
		lMTSystemParameterEdit.Verify_Parameter_Edit_in_Grid(ParameterHeaderName, NewHeaderDetail);
		lMTSystemParameterEdit.Is_Parameter_Edited(SYSTEM_PARAMETER_ADD_SUCCESS_MESSAGE);
	}

}
