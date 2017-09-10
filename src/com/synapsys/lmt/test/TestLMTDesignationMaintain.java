package com.synapsys.lmt.test;

import com.synapsys.lmt.util.TestBase;
import org.testng.annotations.Test;
import com.synapsys.lmt.pages.LMTSDesignationMaintain;


public class TestLMTDesignationMaintain extends TestBase
{
	private String designation = "AUX";
	private String description = "AUX";
	private String designationWithSpecial = "AUX@";
	
	public static LMTSDesignationMaintain lMTDesignationMaintain;
	
	@Test
	public void test_Designation_Saved()throws Exception
	{
		lMTDesignationMaintain = new LMTSDesignationMaintain();
		lMTDesignationMaintain.Designation_created(designation, description);
		lMTDesignationMaintain.Is_Designation_Created(DESIGNATION_CREATION_SUCCESS_MESSAGE);
	}
	
	@Test
	public void test_Designation_Duplicated()
	{
		lMTDesignationMaintain = new LMTSDesignationMaintain();
		lMTDesignationMaintain.Duplicate_Designation_created(designation, description);
		lMTDesignationMaintain.Is_Designation_Duplicated(DESIGNATION_DUPLICATION_MESSAGE);
	}
	
	@Test
	public void test_Designation_with_Sepcial_Characters()
	{
		lMTDesignationMaintain = new LMTSDesignationMaintain();
		lMTDesignationMaintain.Duplicate_Designation_created(designationWithSpecial, description);
		lMTDesignationMaintain.Is_Designation_Creates_With_Special_Characters();
	}
	
	@Test
	public void test_Designation_Clear()throws Exception
	{
		lMTDesignationMaintain = new LMTSDesignationMaintain();
		lMTDesignationMaintain.Validate_Clear_Button(designation, description);
		lMTDesignationMaintain.Is_Textboxes_Cleared();
	}
}
