package com.synapsys.lmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synapsys.lmt.lib.SeleniumBase;

public class LMTLoginPage extends SeleniumBase {

	public static By textUserName = By.xpath(".//*[@id='txtUserName']");
	public static By textPassword = By.xpath(".//*[@id='txtPassword']");
	public static By btnLoggin = By.xpath(".//*[@id='LoginImageButton']");
	
	public static LMTDashBoardPage lmtDashBoardPage;
	
	
	public LMTDashBoardPage Login_With_Valid_Credentials(String userName, String password)
	{
		try{						
			    openPage(BASEURL);
				Thread.sleep(1000);
				clearAndType(textUserName, userName);
				clearAndType(textPassword, password);
				click(btnLoggin);
				return new LMTDashBoardPage();	
			}
		
		catch(Exception ex){
            System.out.println(ex.getMessage());
            return null; 
		}
	}
	
	public LMTDashBoardPage Login_With_Valid_Credentials(String userName, String password, WebDriver driverName)
	{
		try{						
		    openPageNew(BASEURL, driverName);
			Thread.sleep(1000);
			clearAndType(textUserName, userName, driverName);
			clearAndType(textPassword, password, driverName);
			click(btnLoggin, driverName);
			return new LMTDashBoardPage();	
		}
	
	catch(Exception ex){
        System.out.println(ex.getMessage());
        return null; 
	}
	}
	
	public void isSuccessfullyLogged_Out()
	{
		isElementPresent(btnLoggin);
		
	}
	
	public void isSuccessfullyLogged_Out(WebDriver driverName)
	{
		isElementPresent(btnLoggin, driverName);
		
	}
	
	
}

