package com.synapsys.lmt.pages;

import org.openqa.selenium.By;

import com.synapsys.lmt.lib.SeleniumBase;


public class LMTCommonMasterBranchEdit extends SeleniumBase
{
	public static By btnAdministration = By.xpath(".//*[@id='NavigationMenu']/ul/li[3]/a/span[2]/span");
	public static By btnBank_Branches = By.xpath(".//*[@id='TreeScreent25']");
	public static By btnNextPage = By.xpath(".//*[@id='ContentPlaceHolder1_grdBank_imgPageNext']");
	public static By lblPageOf = By.xpath(".//*[@id='ContentPlaceHolder1_grdBank_lblTotalPage']");
	public static By grdbankCode;
	public static By grdbanName;
	public static By grdstatus;
	public static By btnBranch;
	
	
	public static By txtbranchCodeS = By.xpath(".//*[@id='ContentPlaceHolder1_txtCodeSearch']");////*[@id='ContentPlaceHolder1_txtCode']
	public static By txtbranchNameS = By.xpath(".//*[@id='ContentPlaceHolder1_txtNameSearch']");
	public static By btnBranchSearch = By.xpath(".//*[@id='ContentPlaceHolder1_btnSearch']");
	public static By btnBranchNextPage = By.xpath(".//*[@id='ContentPlaceHolder1_grdBank_imgPageNext']");
	public static By lblPages = By.xpath(".//*[@id='ContentPlaceHolder1_grdBarnches_lblTotalPage']");
	public static By grdbranchID;
	public static By grdbranchCode;
	public static By grdbranchName;
	public static By grdbranchstatus;
	public static By btnBranchEdit;
	
	public static By txtbranchCode = By.xpath(".//*[@id='ContentPlaceHolder1_txtCode']");////*[@id='ContentPlaceHolder1_txtCode']
	public static By txtbranchName = By.xpath(".//*[@id='ContentPlaceHolder1_txtName']");
	public static By btnBranchSave = By.xpath(".//*[@id='ContentPlaceHolder1_btnSave']");
	public static By lblBranchUpdateSuccess = By.xpath(".//*[@id='ContentPlaceHolder1_Notification1_lblsuccess']");
	
	String first_part = ".//*[@id='ContentPlaceHolder1_grdBank']/tbody/tr[";
	String second_part = "]/td[";
	String third_part = "]";
	
	String branchPart1 = ".//*[@id='ContentPlaceHolder1_grdBank_lbnBranch_";      
	String branchPart2 = "']";
	
	String branchfirst_part = ".//*[@id='ContentPlaceHolder1_grdBarnches']/tbody/tr[";
	String branchsecond_part = "]/td[";
	String branchthird_part = "]";
	
	String editPart1 = ".//*[@id='ContentPlaceHolder1_grdBarnches_lbnEdit_";      
	String editPart2 = "']";
	
	public static int count;
	public static int loop = 0;
	public static int Row_count;
	
	public static int bloop = 0;
	public static int branchRow_count;
	
	public void initialize()throws Exception
	{
		click(btnAdministration);
		click(btnBank_Branches);
		Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_grdBank']/tbody/tr")).size();
	}
	
	public void Calc_Label_Of_Value(By pages)
	{
		 String lblOfValue = driver.findElement(pages).getText();
		 System.out.println("############### size " + lblOfValue + "##################" );
		 String[] splited = lblOfValue.split(" ");
		 String maxGridSize = splited[1];
		 System.out.println("############### size " + maxGridSize + "##################" );
		 count = Integer.parseInt(maxGridSize);	
	}
	
	public void Get_Values_According_To_Bank_Code(String code, String name, String status) throws InterruptedException
	{	
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
		System.out.println("################ Row count : " + Row_count + "#######################");
		
		boolean role_name_find = false;
		
		for (int i=2; i<=Row_count; i++)
		{
			for(int j=1; j<=1; j++)
			{
				//Thread.sleep(1000);
				String xpath_for_Bank_Code = first_part+i+second_part+1+third_part; 
				
				System.out.println("####################  username  xpath:" + xpath_for_Bank_Code + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_Bank_Code)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(code)){
					
					System.out.println(" ################### username equals  #################");
					grdbankCode = By.xpath(xpath_for_Bank_Code);
					
					String Xpath_for_Bank_Name = first_part+i+second_part+2+third_part;
					grdbanName =By.xpath(Xpath_for_Bank_Name);
					
					String Xpath_for_Status = first_part+i+second_part+3+third_part;
					grdstatus =By.xpath(Xpath_for_Status);
					
					String xpath_for_Edit_Button = branchPart1+(i-2)+branchPart2;
					
					if(readAndCompare(grdbankCode, code) && readAndCompare(grdbanName, name) && readAndCompare(grdstatus, status))
					{	
						btnBranch = By.xpath(xpath_for_Edit_Button);
						click(btnBranch);
						branchRow_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_grdBarnches']/tbody/tr")).size();
					}
					
					role_name_find = true;											
					return;
				}	
			}
		}
				
		if((!role_name_find)&&(loop < count))
		{
			click(btnNextPage);
			loop++;
			System.out.println("#### Move to next Grid ######");
			Get_Values_According_To_Bank_Code(code, name, status);
		}	
	}
	
	public void SinglePageSearch(String code, String name, String status)
	{		
		for (int i=2; i<=Row_count; i++)
		{
				//Thread.sleep(1000);
			String xpath_for_Bank_Code = first_part+i+second_part+1+third_part; 
			
			System.out.println("####################  username  xpath:" + xpath_for_Bank_Code + " #####################");
			String Table_data = driver.findElement(By.xpath(xpath_for_Bank_Code)).getText();
			System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(code))
				{
					
					System.out.println(" ################### username equals  #################");
					grdbankCode = By.xpath(xpath_for_Bank_Code);
					
					String Xpath_for_Bank_Name = first_part+i+second_part+2+third_part;
					grdbanName =By.xpath(Xpath_for_Bank_Name);
					
					String Xpath_for_Status = first_part+i+second_part+3+third_part;
					grdstatus =By.xpath(Xpath_for_Status);
					
					String xpath_for_Edit_Button = branchPart1+(i-2)+branchPart2;
					
					if(readAndCompare(grdbankCode, code) && readAndCompare(grdbanName, name) && readAndCompare(grdstatus, status))
					{	
						btnBranch = By.xpath(xpath_for_Edit_Button);
						click(btnBranch);
						branchRow_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_grdBarnches']/tbody/tr")).size();
					}
				}	
		}
	}
	
	public void Search_Grid_for_Bank_Code(String code, String name, String status) throws InterruptedException
	{
		if(Row_count<11)
		{
			SinglePageSearch(code, name, status);
		}
		else if(Row_count>10)
		{
			Calc_Label_Of_Value(lblPageOf);
			Get_Values_According_To_Bank_Code(code, name, status);
		}
	}
	
	public void searchBranch(String code, String name)
	{
		clearAndType(txtbranchCodeS, code);
		clearAndType(txtbranchNameS, name);
		click(btnBranchSearch);
	}
	
	public void Get_Values_According_To_Branch_ID(String id, String code, String name, String status, String newCode, String newName) throws InterruptedException
	{	
		//int Row_count = driver.findElements(By.xpath(".//*[@id='ContentPlaceHolder1_dtgRoles']/tbody/tr")).size(); 
		System.out.println("################ Row count : " + branchRow_count + "#######################");
		
		boolean branch_id_find = false;
		
		for (int i=2; i<=branchRow_count; i++)
		{
			for(int j=1; j<=1; j++)
			{
				//Thread.sleep(1000);
				String xpath_for_Branch_ID = branchfirst_part+i+branchsecond_part+1+branchthird_part;
				
				System.out.println("####################  username  xpath:" + xpath_for_Branch_ID + " #####################");
				String Table_data = driver.findElement(By.xpath(xpath_for_Branch_ID)).getText();
				System.out.println("#################### table data :  " + Table_data + " #####################");
					
					if(Table_data.equals(id))
					{
						
						System.out.println(" ################### username equals  #################");
						grdbranchID = By.xpath(xpath_for_Branch_ID);
						
						String Xpath_for_Branch_Code = branchfirst_part+i+branchsecond_part+2+branchthird_part;
						grdbranchCode =By.xpath(Xpath_for_Branch_Code);
						
						String Xpath_for_Branch_Name = branchfirst_part+i+branchsecond_part+3+branchthird_part;
						grdbranchName =By.xpath(Xpath_for_Branch_Name);
						
						String Xpath_for_BranchStatus = branchfirst_part+i+branchsecond_part+4+branchthird_part;
						grdbranchstatus =By.xpath(Xpath_for_BranchStatus);
						
						String xpath_for_Branch_Edit_Button = editPart1+(i-2)+editPart2; //here
						
						if(readAndCompare(grdbranchID, id) && readAndCompare(grdbranchCode, code) && readAndCompare(grdbranchstatus, status) && readAndCompare(grdbranchName, name))
						{	
							btnBranchEdit = By.xpath(xpath_for_Branch_Edit_Button);
							click(btnBranchEdit);
							clearAndType(txtbranchCode, newCode);
							clearAndType(txtbranchName, newName);
							click(btnBranchSave);
						}
					
						branch_id_find = true;											
					return;
				}	
			}
		}
				
		if((!branch_id_find)&&(bloop < count))
		{
			click(btnBranchNextPage);
			bloop++;
			System.out.println("#### Move to next Grid ######");
			Get_Values_According_To_Branch_ID(id, code, name, status, newCode, newName);
		}	
	}
	
	public void BranchSinglePageSearch(String id, String code, String name, String status, String newCode, String newName)
	{		
		for (int i=2; i<=branchRow_count; i++)
		{
				//Thread.sleep(1000);
			String xpath_for_Branch_ID = branchfirst_part+i+branchsecond_part+1+branchthird_part;
			
			System.out.println("####################  username  xpath:" + xpath_for_Branch_ID + " #####################");
			String Table_data = driver.findElement(By.xpath(xpath_for_Branch_ID)).getText();
			System.out.println("#################### table data :  " + Table_data + " #####################");
				
				if(Table_data.equals(id))
				{
					
					System.out.println(" ################### username equals  #################");
					grdbranchID = By.xpath(xpath_for_Branch_ID);
					
					String Xpath_for_Branch_Code = branchfirst_part+i+branchsecond_part+2+branchthird_part;
					grdbranchCode =By.xpath(Xpath_for_Branch_Code);
					
					String Xpath_for_Branch_Name = branchfirst_part+i+branchsecond_part+3+branchthird_part;
					grdbranchName =By.xpath(Xpath_for_Branch_Name);
					
					String Xpath_for_BranchStatus = branchfirst_part+i+branchsecond_part+4+branchthird_part;
					grdbranchstatus =By.xpath(Xpath_for_BranchStatus);
					
					String xpath_for_Branch_Edit_Button = editPart1+(i-2)+editPart2; //here
					
					if(readAndCompare(grdbranchID, id) && readAndCompare(grdbranchCode, code) && readAndCompare(grdbranchstatus, status) && readAndCompare(grdbranchName, name))
					{	
						btnBranchEdit = By.xpath(xpath_for_Branch_Edit_Button);
						click(btnBranchEdit);
						clearAndType(txtbranchCode, newCode);
						clearAndType(txtbranchName, newName);
						click(btnBranchSave);
					}
				}	
		}
	}
	
	public void Search_Grid_for_Branch_Code(String id, String code, String name, String status, String newCode, String newName) throws InterruptedException
	{
		if(branchRow_count<11)
		{
			BranchSinglePageSearch(id, code, name, status, newCode, newName);
		}
		else if(branchRow_count>10)
		{
			Calc_Label_Of_Value(lblPages);
			Get_Values_According_To_Branch_ID(id, code, name, status, newCode, newName);
		}
	}
	
	public void editBranch(String updateSuccessMessage)throws Exception
	{
		if(readAndCompare(lblBranchUpdateSuccess, updateSuccessMessage))
			return;
		else
			throw new Exception();
	}

}
