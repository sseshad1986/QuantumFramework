package com.quantum.helper;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks 
{
	@BeforeSuite
	//@Before ("@EditEntityDefinition")
	public void startReport()
	{
		System.out.println("---------------------");
		System.out.println("----- Report Started -------");
	}
	
	@AfterSuite
	//@After ("@NflowsLogout")
	public void endReport()
	{		
		System.out.println("----- Report Ended -------");
		System.out.println("---------------------");
	}
}
