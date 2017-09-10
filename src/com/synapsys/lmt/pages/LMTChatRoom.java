package com.synapsys.lmt.pages;

import com.synapsys.lmt.lib.SeleniumBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LMTChatRoom extends SeleniumBase
{
	public static By btnBusinessEntity = By.xpath(".//*[@id='NavigationMenu']/ul/li[1]/a/span[2]/span");
	public static By btnChatRoom = By.xpath(".//*[@id='TreeScreent6']");
	public static By txtChatMessage = By.xpath(".//*[@id='ContentPlaceHolder1_txtMessage']");
	public static By btnSend = By.xpath(".//*[@id='ContentPlaceHolder1_btnSend']");
	public static int count;
	
	/*public static LMTLoginPage lMTLoginPage;
	public static LMTDashBoardPage lMTDashBoardPage;
	//public static LMTChatRoom lmtChatRoom;
	public static LmtLogout lMTLogout;
	*/
	
	public void clickBasic()
	{
		click(btnBusinessEntity);
		click(btnChatRoom);
		
		count = driver.findElements(By.xpath(".//*[@id='divMessages']/div")).size();
	}
	
	public void clickBasic(WebDriver driverName)
	{
		click(btnBusinessEntity, driverName);
		click(btnChatRoom, driverName);
		
		count = driverName.findElements(By.xpath(".//*[@id='divMessages']/div")).size();
	}
	
	public void sendChatMessage(String message)
	{
		clearAndType(txtChatMessage, message);
		click(btnSend);
	}
	
	public void sendChatMessage(String message, WebDriver driverName)
	{
		clearAndType(txtChatMessage, message, driverName);
		click(btnSend, driverName);
	}
	
	public void validateMessage()throws Exception
	{
		int newCount = driver.findElements(By.xpath(".//*[@id='divMessages']/div")).size();
		if(newCount == count + 1)
		{
			return;
		}
		else
			throw new Exception();
	}
	/*
	public void recieveChatMessage(String message)throws Exception
	{
		WebDriver driver2 = new FirefoxDriver();
		driver2.get(BASEURL);
		
		lMTLoginPage = new LMTLoginPage();
		lMTDashBoardPage = lMTLoginPage.Login_With_Valid_Credentials(ADMIN_USER_NAME,ADMIN_PASSWORD);
		lMTDashBoardPage.isSuccessfullyLogged(ADMIN_FULLNAME, ADMIN_BRANCH);
		LMTChatRoom lmtChatRoom = new LMTChatRoom();
		lmtChatRoom.clickBasic();
		lmtChatRoom.sendChatMessage(message);
		
		lMTLogout = new LmtLogout();
		lMTLoginPage = lMTLogout.Logout_User();
		lMTLoginPage.isSuccessfullyLogged_Out();
		
		driver.close();
	}
	*/
	public void validateRecieve()throws Exception
	{
		driver.navigate().refresh();
		Thread.sleep(3000);
		int newCount = driver.findElements(By.xpath(".//*[@id='divMessages']/div")).size();
		if(newCount == count + 2)
		{
			return;
		}
		else
			throw new Exception();
	}

}
