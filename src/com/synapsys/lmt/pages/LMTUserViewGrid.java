package com.synapsys.lmt.pages;

import org.openqa.selenium.By;
import com.synapsys.lmt.lib.SeleniumBase;

public class LMTUserViewGrid extends SeleniumBase{
	
	//.//*[@id='ContentPlaceHolder1_gdvusers_imgPageNext']
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By lblof = By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers_lblTotalPage']");

	public static By btnUserView = By.xpath(".//*[@id='TreeScreent14']");	
	public static By btnNext = By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers_imgPageNext']");
	public static By grdUserName;
	public static By grdFirstName;
	public static By grdLastName;
	public static By grdEmail;
	public static By grdStatus;
	public static int Row_count;
	
	//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_headerpanel']/div/div[2]/div")).size(); 
	//int Col_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_headerpanel']/div/div[2]/div")).size();
	
	//.//*[@id='ContentPlaceHolder1_headerpanel']/div/div[2]/div
	//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr[2]/td[1]
	//String first_part = "//*[@id='post-body-6522850981930750493']/div[1]/table/tbody/tr["; 
	
	String first_part = "//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr["; 
	String second_part = "]/td["; 
	String third_part = "]";
	
	public static int count;
	public static int loop = 0;
	
	public void click_Basic(){
		click(btnAdministration);
		click(btnUserView);
		Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr")).size();
	}

	public void Calc_Label_Of_Value(){		
		
	 String lblOfValue = driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers_lblTotalPage']")).getText();
	 System.out.println("############### size " + lblOfValue + "##################" );
	 String[] splited = lblOfValue.split(" ");
	 String maxGridSize = splited[1];
	 System.out.println("############### size " + maxGridSize + "##################" );
	 count = Integer.parseInt(maxGridSize);
			
	}
	
	public void Search_Grid_for_User_Name(String username,String firstName,String lastName,String email, String status) throws Exception
	{
		if(Row_count<11)
		{
			SinglePageSearch(username, firstName, lastName, email, status);
		}
		else if(Row_count>10)
		{
			Calc_Label_Of_Value();
			Get_Values_According_To_User_Name(username, firstName, lastName, email, status);
		}
	}		
	
public void SinglePageSearch(String username,String firstName,String lastName,String email, String status) throws Exception{		
		
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr")).size(); 
				System.out.println("################ Row count : " + Row_count + "#######################");					
				
				boolean user_name_find = false;
				
				for (int i=2; i<=Row_count; i++){
					for(int j=1; j<=1; j++){
						
						//Thread.sleep(1000);
						String xpath_for_User_name = first_part+i+second_part+1+third_part; 
						
						System.out.println("####################  username  xpath:" + xpath_for_User_name + " #####################");
						String Table_data = driver.findElement(By.xpath(xpath_for_User_name)).getText();
						System.out.println("#################### table data :  " + Table_data + " #####################");
						
						if(Table_data.equals(username)){
							
							System.out.println(" ################### username equals  #################");
							grdUserName = By.xpath(xpath_for_User_name);
							
							String Xpath_for_First_name = first_part+i+second_part+2+third_part;
							grdFirstName =By.xpath(Xpath_for_First_name);
							
							String Xpath_for_Last_name = first_part+i+second_part+3+third_part;
							grdLastName=By.xpath(Xpath_for_Last_name);
							
							String Xpath_for_Email = first_part+i+second_part+4+third_part;
							grdEmail=By.xpath(Xpath_for_Email);
							
							String Xpath_for_Status = first_part+i+second_part+5+third_part;
							grdStatus=By.xpath(Xpath_for_Status);
							
							this.Verify_User_View_in_Grid(username, firstName, lastName, email, status);
																					
							user_name_find = true;											
							return;
						}
										
					}
					
				}
		}
		
	
	public void Get_Values_According_To_User_Name(String username,String firstName,String lastName,String email, String status) throws Exception{		
		
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_headerpanel']/div/div[2]/div")).size(); 
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_gdvusers']/tbody/tr")).size(); 
		System.out.println("################ Row count : " + Row_count + "#######################");
		//Col_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_headerpanel']/div/div[2]/div")).size();
		//Row_count = 10;		
		
		boolean user_name_find = false;
		
		for (int i=2; i<=Row_count; i++){
			for(int j=1; j<=1; j++){
				
				//Thread.sleep(1000);
				String xpath_for_User_name = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_User_name + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_User_name)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(username)){
					
					System.out.println(" ################### username equals  #################");
					grdUserName = By.xpath(xpath_for_User_name);
					
					String Xpath_for_First_name = first_part+i+second_part+2+third_part;
					grdFirstName =By.xpath(Xpath_for_First_name);
					
					String Xpath_for_Last_name = first_part+i+second_part+3+third_part;
					grdLastName=By.xpath(Xpath_for_Last_name);
					
					String Xpath_for_Email = first_part+i+second_part+4+third_part;
					grdEmail=By.xpath(Xpath_for_Email);
					
					String Xpath_for_Status = first_part+i+second_part+5+third_part;
					grdStatus=By.xpath(Xpath_for_Status);
					
					this.Verify_User_View_in_Grid(username, firstName, lastName, email, status);
					
					user_name_find = true;											
					return;
				}
				
				//Get_Values_According_To_User_Name(username);	
			}
			//Get_Values_According_To_User_Name(username);
		}
		
		if((!user_name_find)&&(loop < count)){
			click(btnNext);
			loop++;
			//Thread.sleep(1000);
			System.out.println("#### Move to next Grid ######");
			Get_Values_According_To_User_Name(username,firstName,lastName,email,status);
		}
		//Get_Values_According_To_User_Name(username);	
	}
		
	public void Verify_User_View_in_Grid(String userName,String firstName, String lastName, String email, String status) throws Exception{
		if(readAndCompare(grdUserName, userName) && readAndCompare(grdFirstName,firstName) && readAndCompare(grdLastName,lastName) && readAndCompare(grdEmail,email) && readAndCompare(grdStatus,status))
			return;
		else
			throw new Exception();
			
		/*readAndCompare(grdUserName, userName);
		readAndCompare(grdUserName,firstName);
		readAndCompare(grdUserName,lastName);
		readAndCompare(grdUserName,email);
		readAndCompare(grdUserName,status);*/
	}
}
