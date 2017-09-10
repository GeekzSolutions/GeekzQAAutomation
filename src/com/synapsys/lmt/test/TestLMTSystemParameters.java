package com.synapsys.lmt.test;

import org.testng.annotations.Test;
import com.synapsys.lmt.util.TestBase;
import com.synapsys.lmt.pages.LMTSystemParameters;

public class TestLMTSystemParameters extends TestBase
{
	private String ParameterHeaderName = "Test1";
	private String ParameterDetail = "0123456789";
	private String HeaderNamewithSpecialCharacters = "Test@2";
	
	public static LMTSystemParameters lMTSystemParameter;
	
	//Create a System parameter
	@Test
	public void test_System_Paramater_Saved()throws Exception
	{
		lMTSystemParameter = new LMTSystemParameters();
		lMTSystemParameter.SystemParameter_Created(ParameterHeaderName, ParameterDetail);
		lMTSystemParameter.Is_Parameter_Created(SYSTEM_PARAMETER_ADD_SUCCESS_MESSAGE);
	}
	//create a duplicate system parameter
	@Test
	public void test_System_Parameter_Duplicated()throws Exception
	{
		lMTSystemParameter = new LMTSystemParameters();
		lMTSystemParameter.Duplicate_Parameter_Created(ParameterHeaderName, ParameterDetail);
		lMTSystemParameter.Is_Duplicate_Parameter_Created(SYSTEM_PARAMETER_DUPLICATE_MESSAGE);
	}
	//create a system parameter with special characters
	@Test
	public void test_System_Parameter_with_Special_Characters()
	{
		lMTSystemParameter = new LMTSystemParameters();
		lMTSystemParameter.Duplicate_Parameter_Created(HeaderNamewithSpecialCharacters, ParameterDetail);
		lMTSystemParameter.Is_Parameter_Creates_with_Special_Characters();
	}

}
