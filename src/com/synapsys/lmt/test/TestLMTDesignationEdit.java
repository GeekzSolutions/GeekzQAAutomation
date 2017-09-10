package com.synapsys.lmt.test;

import com.synapsys.lmt.util.TestBase;

import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTDesignationEdit;

public class TestLMTDesignationEdit extends TestBase
{
	private String designationID = "55";
	private String designation = "AUX";
	private String description = "AUX";
	private String status = "Yes";
	private String newDesignation = "AASUI";
	private String newDescription = "SUI";
	
	public static LMTDesignationEdit lMTDesignationEdit;
	
	@Test
	public void test_Designation_Edited()throws Exception
	{
		lMTDesignationEdit = new LMTDesignationEdit();
		lMTDesignationEdit.clickBasic();
		lMTDesignationEdit.Search_Grid_for_Designation(designationID, designation, description, status, newDesignation, newDescription);
		lMTDesignationEdit.Is_Designation_Edited(DESIGNATION_UPDATE_MESSAGE);
	}

}
