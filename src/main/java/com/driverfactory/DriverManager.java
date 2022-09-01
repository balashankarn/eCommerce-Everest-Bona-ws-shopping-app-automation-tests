package com.driverfactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class DriverManager {
	
	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

	
	private DriverManager() {}
	
	public static synchronized AppiumDriver<MobileElement> getDriver() {

		return driver.get();
	}
	
	public static void setDriver(AppiumDriver driver) {
		DriverManager.driver.set(driver);
	}
	
    public static void quit() {
    	DriverManager.driver.get().quit();
        driver.remove();
    }

}
