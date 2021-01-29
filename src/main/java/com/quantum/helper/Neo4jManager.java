package com.quantum.helper;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.Driver;



public class Neo4jManager 
{
	//Connection Settings
	public static Driver idrv_driver;
	public Session ises_session;
	private static Neo4jManager instance = null;
	
	
	public static Neo4jManager getInstance() throws Exception 
	{
		if(instance == null) 
		{
			instance = new Neo4jManager();
		}
		return instance;
	}
	
	private Neo4jManager() throws Exception{
		try 
		{			
			Driver neo4j_driver;
			
			String dbHostName=BaseClass.getdataFromProperty("qa_environment", "db.hostname");
			String dbUserName=BaseClass.getdataFromProperty("qa_environment", "db.username");
			String dbPassword=BaseClass.getdataFromProperty("qa_environment", "db.password");
			
			System.out.println( " BaseClass : " + dbHostName + " : " + dbUserName + " : " + dbPassword);
			neo4j_driver = GraphDatabase.driver(dbHostName, AuthTokens.basic(dbUserName,dbPassword));
			
			Neo4jManager.idrv_driver = neo4j_driver; 
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public Session getSessionByDriver() {
		return idrv_driver.session();
	}
}
