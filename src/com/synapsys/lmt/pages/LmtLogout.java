package com.synapsys.lmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.synapsys.lmt.lib.SeleniumBase;

public class LmtLogout extends SeleniumBase{


public static By btnLogout = By.xpath(".//*[@id='LinkButtonLogout']");
	
	public static LMTLoginPage LmtLoginPage;
	public static String baseurl ;
	
	public LMTLoginPage Logout_User(){
		click(btnLogout);
		return new LMTLoginPage();
	}
	
	public LMTLoginPage Logout_User(WebDriver driverName)
	{
		click(btnLogout, driverName);
		return new LMTLoginPage();
	}
//	

	
}
