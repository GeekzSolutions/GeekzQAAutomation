package com.synapsys.lmt.util;

public class LMTCommonTerms {

	private static boolean isLoggin = false;
	
	public enum BrowserType{
		INDIVIDUAL,
		CORPORATE,
		MISCELLANEOUS
	}
	
    public enum CustomerCatagory{
		INDIVIDUAL,
		CORPORATE,
		MISCELLANEOUS
	}
	
	public enum CustomerCatagoryType{
		NORMAL,
		NOMINEE,
	    MINOR,
		OPERATORS
	}
	
	public boolean getIsLoggin(){
		return isLoggin;
	}
	
	public void setIsLoggin(boolean loginResult){
		isLoggin = loginResult ;
	}

	//---------------------------//Text to be appeared ----------------------------------------------------
	
	public final String customerIsExist(){
		return "Stakeholder Info" ; 
	}
	
	//----------------------------//Success messages	---------------------------------------------------
	
	public final String LogginSuccess(String testMethod){
		return "There is issue in loggin, please check " +testMethod+ "";
	}
	
	public final String scucessMessageForCreateRecord(){	
		return "CO.ESB.00003-Record successfully saved";
	}
	
	
	//----------------------------//Error messages	---------------------------------------------------
	 
	public final String UnexpectedLogginIssue(String testMethod){
		return "Some thing Worng when login to the system @ method " +testMethod+ "";
	}
	
	public final String LogginFunctionIssue(String testMethod){
		return "Successfully Loggin to the system " +testMethod+ "";
	}
	
	public final String IssueWhenExecutingTheTestCase(String testMethod){
		return "Unexpected issue occuerred when executing " +testMethod+ "";
	}
	
	
}
