package com.ninza.crm.generic.baseutility;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	@BeforeSuite
	public void configBS() {
		System.out.println("");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("==launch Browser==");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("==Close Browser==");
	}
	
	@BeforeMethod
	public void configBm() {
		System.out.println("==Login==");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("==Logout==");
	}
	
}
