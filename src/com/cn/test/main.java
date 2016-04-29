package com.cn.test;
import org.junit.After;
 import org.junit.Before;
 import org.junit.Test;
 import org.openqa.selenium.*;
 import org.openqa.selenium.remote.CapabilityType;
 import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
 import java.net.URL;
 import java.util.concurrent.TimeUnit;

public class main {
	private AppiumDriver driver;
	     
	     @Before
	     public void setUp() throws Exception {
	         DesiredCapabilities capabilities = new DesiredCapabilities();       
//	         capabilities.setCapability("automationName","Selendroid");             //自动化引擎
	         capabilities.setCapability("platformName","Android");                //手机os     
	         capabilities.setCapability("platformVersion", "5.0.2");        //真机的Android版本     
//	         capabilities.setCapability("udid","94122ad8");                //物理机ID 
//	         capabilities.setCapability(CapabilityType.PLATFORM, "Mac");        //使用的是mac平台
	         capabilities.setCapability("deviceName", "YHWWSOTSUKHMIJYD");               //要启动的手机<a href="http://www.it165.net/edu/ewl/" target="_blank" class="keylink">浏览器</a>
	         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);    
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    
	     }
	     
	     @After
	     public void tearDown() throws Exception {
	         driver.quit();
	     }
	     @Test
	     public void test_swipguidePage(){
	 		driver.findElementById("com.togo.apps:id/cover_image");
	 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 		WebElement go=null,slider=null;
	 		boolean found = false;
	     	int pageCount = 5; //Assume that there are totally 5 screens to be swiped.   	
	     	//Swipe all screens till get the expected control
	     	int currentPage = 0; 	
	     	while (found == false && currentPage < pageCount) {
	     		found = true;	
	     		currentPage += 1;
	     		 try {
	         		go =driver.findElementById("com.togo.apps:id/main_go_image");
	         	 }catch (NoSuchElementException e) {
	         		found = false;
	         		System.out.println(e);
	         	   }    		
	     		if (found == true)
	     			break;	
	     		slider=driver.findElementById("com.togo.apps:id/splashimage");
	     		int xAxisStartPoint = slider.getLocation().getX();
	     		
	     		int xAxisEndPoint = xAxisStartPoint + slider.getSize().getWidth();
	     		
	     		int yAxis = slider.getLocation().getY();
	     		
	     		driver.swipe(xAxisEndPoint-20,yAxis+20, xAxisStartPoint+10,yAxis+20, 10);
	     	   }  
	     	  go.click();
	 	}

}
