package com.synapsys.lmt.lib;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.synapsys.lmt.util.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;



public class SeleniumBase extends TestBase{


	protected boolean acceptNextAlert = true;
    protected static StringBuffer verificationErrors = new StringBuffer();

    protected  void openPage(String URL) {
    	driver.get(URL);
	}
    
    protected  void openPageNew(String URL, WebDriver driverName) {
    	driverName.get(URL);
	}
    
    protected void clearAndType(By by, String text){
        WebElement field = driver.findElement(by);
        try {
            field.clear();
            field.sendKeys(text);
        } catch (InvalidElementStateException e) {
            System.out.println(e.getMessage());
        }
    }
    
    protected void clearAndType(By by, String text, WebDriver driverName){
        WebElement field = driverName.findElement(by);
        try {
            field.clear();
            field.sendKeys(text);
        } catch (InvalidElementStateException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void type(By by, String text) throws Exception {
        WebElement field = driver.findElement(by);
        try {
            field.sendKeys(text);
        } catch (InvalidElementStateException e) {
        	System.out.println(e.getMessage());
        }
    }

    protected void click(By by){       	
    	try {
    		driver.findElement(by).click();
        } catch (InvalidElementStateException e) {
        	System.out.println(e.getMessage());
        }
    }
    
    protected void click(By by, WebDriver driverName){       	
    	try {
    		driverName.findElement(by).click();
        } catch (InvalidElementStateException e) {
        	System.out.println(e.getMessage());
        }
    }

    protected void select(By by, String text) throws Exception {
    	try{
    		new Select(driver.findElement(by)).selectByVisibleText(text);
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
        
    }

    protected void readAndCompareAndGetResult(By by, String text){
        try{
        	WebElement field = driver.findElement(by);
            if (!field.getText().equals(text)) {
                verificationErrors.append("\nElement: ");
                verificationErrors.append(by.toString());
                verificationErrors.append("\nExpected Text: ");
                verificationErrors.append(text);
                verificationErrors.append("\nActual Text: ");
                verificationErrors.append(field.getAttribute("value"));
            }
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
    }

    protected boolean readAndCompare(By by, String text){
        try{
            WebElement field = driver.findElement(by);
 
            System.out.println("############# text ################## :" + field.getText());
            if (!field.getText().equals(text)) {
            	System.out.println("############# Fail ##################");
                verificationErrors.append("\nElement: ");
                verificationErrors.append(by.toString());
                verificationErrors.append("\nExpected Text: ");
                verificationErrors.append(text);
                verificationErrors.append("\nActual Text: ");
                verificationErrors.append(field.getAttribute("value"));
                return false;
            }else{
            	return true;
            }
        } catch (Exception e){
          System.out.println(e.getMessage()); 
          return false;
        }
    }
    
    protected boolean readAndCompare(By by, String text, WebDriver driverName){
        try{
            WebElement field = driverName.findElement(by);
 
            System.out.println("############# text ################## :" + field.getText());
            if (!field.getText().equals(text)) {
            	System.out.println("############# Fail ##################");
                verificationErrors.append("\nElement: ");
                verificationErrors.append(by.toString());
                verificationErrors.append("\nExpected Text: ");
                verificationErrors.append(text);
                verificationErrors.append("\nActual Text: ");
                verificationErrors.append(field.getAttribute("value"));
                return false;
            }else{
            	return true;
            }
        } catch (Exception e){
          System.out.println(e.getMessage()); 
          return false;
        }
    }
    
    protected boolean readAndCompareByValue(By by, String text){
        try{
            String field = driver.findElement(by).getAttribute("value");
        	
            System.out.println("############# text ################## : " + field);
            if (!field.equals(text)) {
            	System.out.println("############# Fail ##################");
                verificationErrors.append("\nElement: ");
                verificationErrors.append(by.toString());
                verificationErrors.append("\nExpected Text: ");
                verificationErrors.append(text);
                verificationErrors.append("\nActual Text: ");
                //verificationErrors.append(field.getAttribute("value"));
                return false;
            }else{
            	return true;
            }
        } catch (Exception e){
          System.out.println(e.getMessage()); 
          return false;
        }
    }
    
   
    protected boolean readAndCompareByClass(By by, String text){
        try{
            String field = driver.findElement(by).getAttribute("class");
        	
            System.out.println("############# text ################## : " + field);
            if (!field.equals(text)) {
            	System.out.println("############# Fail ##################");
                verificationErrors.append("\nElement: ");
                verificationErrors.append(by.toString());
                verificationErrors.append("\nExpected Text: ");
                verificationErrors.append(text);
                verificationErrors.append("\nActual Text: ");
                //verificationErrors.append(field.getAttribute("value"));
                return false;
            }else{
            	return true;
            }
        } catch (Exception e){
          System.out.println(e.getMessage()); 
          return false;
        }
    }
    
    

    protected void isElementPresent(By by){
        try{
            driver.findElement(by);
        }catch (NoSuchElementException e){
            verificationErrors.append("\nNo such element found as");
            verificationErrors.append(by.toString());
        }
    }
    
    protected void isElementPresent(By by, WebDriver driverName){
        try{
        	driverName.findElement(by);
        }catch (NoSuchElementException e){
            verificationErrors.append("\nNo such element found as");
            verificationErrors.append(by.toString());
        }
    }
    
    protected boolean isElementPresentBool(By by)
    {
    	try
    	{
    		driver.findElement(by);
    		return true;
    	}
    	catch(NoSuchElementException e)
    	{
    		System.out.println(e.getMessage());
    		return false;
    	}
    }
    
    protected void isElementPresentForLogin(String baseURL, By by){
        try{
        	driver.get(baseURL);
            driver.findElement(by);
        }catch (NoSuchElementException e){
            verificationErrors.append("\nNo such element found as");
            verificationErrors.append(by.toString());
        }
    }

    protected void captureScreenShot(String fileName) throws IOException{
        try{
        	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            FileUtils.copyFile(file, new File("screenshots/" + fileName + timeStamp + ".jpg"));
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
    }

    protected void pageRefresh(WebDriver driver){
        try{
        	driver.navigate().refresh();
        }catch(Exception e){
        	e.getMessage();
        }
    }

    protected void waitUntilTextPresent(By by, String expectedText){
        try{
        	WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(by, expectedText));
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
    }

    protected void getText(By by){
       try{
    	   driver.findElement(by).getText(); 
       }catch(Exception e){
    	   System.out.println(e.getMessage());
       }
    }

    protected void check(By by){
    	try{
    		if (!driver.findElement(by).isSelected()) {
                driver.findElement(by).click();
            };
    	}catch(Exception e){
    		System.out.println(e.getMessage()); ;
    	}
    }

    protected boolean isTextPresent(String textToBeVerified) {
        try {
              driver.findElement(By.xpath("//*[contains('" + textToBeVerified + "')]"));
              return true;
            }
        catch (Exception e) {
        	System.out.println(e.getMessage());
        	return false;
        }
    }

    protected void waitForElement(int time_out,ExpectedCondition <WebElement> expectedCondition)
	{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver,time_out);	
    		wait.until(expectedCondition);	
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}		
	}

    public void switchToWindow(String pageTitle) {
    	try{
    		for(String winHandle :driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
                if(driver.getTitle().equals(pageTitle)){
                    System.out.println("You are in required window");
                    break;
                } else{
                    System.out.println("Title of the page after - switchingTo: " + driver.getTitle());
                }
            }
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
        
    }

}
