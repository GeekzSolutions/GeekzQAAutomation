package com.synapsys.lmt.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.synapsys.lmt.pages.LMTChatRoom;
import com.synapsys.lmt.pages.LMTDashBoardPage;
import com.synapsys.lmt.pages.LMTLoginPage;
import com.synapsys.lmt.pages.LmtLogout;
import com.synapsys.lmt.util.TestBase;


public class TestLMTChatRoom extends TestBase
{
	private String chatMessage = "Hi";
	public static LMTChatRoom lmtChatroom;
	
	public static LMTLoginPage lMTLoginPage;
	public static LMTDashBoardPage lMTDashBoardPage;
	//public static LMTChatRoom lmtChatRoom;
	public static LmtLogout lMTLogout;
	public WebDriver driver2;
	
	@Test
	public void testChatRoom()throws Exception
	{
		lmtChatroom = new LMTChatRoom();
		lmtChatroom.clickBasic();
		lmtChatroom.sendChatMessage(chatMessage);
		Thread.sleep(3000);
		lmtChatroom.validateMessage();
		
		//open new window and login with a different user
		driver2 = new FirefoxDriver();
		driver2.get(BASEURL);
		
		lMTLoginPage = new LMTLoginPage();
		lMTDashBoardPage = lMTLoginPage.Login_With_Valid_Credentials(ADMIN_USER_NAME,ADMIN_PASSWORD, driver2);
		Thread.sleep(3000);
		lMTDashBoardPage.isSuccessfullyLogged(ADMIN_FULLNAME, ADMIN_BRANCH, driver2);
		
		Thread.sleep(3000);
		lmtChatroom.clickBasic(driver2);
		Thread.sleep(1000);
		lmtChatroom.sendChatMessage(chatMessage, driver2);
		
		lMTLogout = new LmtLogout();
		lMTLoginPage = lMTLogout.Logout_User(driver2);
		Thread.sleep(3000);
		lMTLoginPage.isSuccessfullyLogged_Out(driver2);
		
		driver2.close();
		//validate message receival
		
		lmtChatroom.validateRecieve();
	}

}
