package com.synapsys.lmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTDashBoardPage extends SeleniumBase {

	public static By btnLoggin = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By pnlAdministration = By.xpath(".//*[@id='Form1']/div[5]/div[3]/div[1]");
	
	public static By btnUserCreation = By.xpath(".//*[@id='TreeScreent15']");
	
	public static By lblFullName = By.xpath(".//*[@id='lblUserName']"); 
	public static By lblBranch = By.xpath(".//*[@id='lblBranch']"); 	
	

/*	public void isSuccessfullyLogged(String fullName, String branch){		
		boolean result1 = isTextPresent(fullName);	
		boolean result2 = isTextPresent(branch);
		
		if(result1)			
			System.out.println(" #################### goda  full name ########################");
		else if(result2)
			System.out.println("#################### goda Branch #########################");
		
		else
			System.out.println("Mada");
			
	}*/
		
	public void isSuccessfullyLogged(String fullName, String branch) throws Exception {		
		if(readAndCompare(lblFullName, fullName)){
			if(readAndCompare(lblBranch, branch)){
				return;
			}
		}
		throw new Exception();
	}
	
	public void isSuccessfullyLogged(String fullName, String branch, WebDriver driverName) throws Exception {		
		if(readAndCompare(lblFullName, fullName, driverName)){
			if(readAndCompare(lblBranch, branch, driverName)){
				return;
			}
		}
		throw new Exception();
	}
	
	public void isAdminPanelAvailble()	{
		try{
		click(btnLoggin);
		isElementPresent(pnlAdministration);
	
		}
		catch(Exception ex){
			throw ex;
		}
	
}
	
	
}	
	
