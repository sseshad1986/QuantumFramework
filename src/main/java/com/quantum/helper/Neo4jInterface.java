package com.quantum.helper;

import org.json.JSONArray;
//import org.json.JSONObject;
//import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import com.google.gson.Gson;

public class Neo4jInterface{
	
	
	//retrieve the data based on the query which contains particular attributes and its data
	public JSONArray retrieve(String astr_query) throws Exception{
		JSONArray js_result = new JSONArray();
	    try {
	    	StatementResult lst_result = executeQuery(astr_query);
	    	while (lst_result.hasNext()) {
		       Record record = lst_result.next();
		       js_result.put(new Gson().toJson(record.asMap()).toString());
		    }
		} catch (Exception e) {
			System.out.println("Result parsing exception");
			e.printStackTrace();
			return null;
		}
		return js_result;
	}
	
	//Execute the cypher query to retrieve 
	public StatementResult executeQuery(String astr_query) throws Exception{
		Neo4jManager lneo4j=Neo4jManager.getInstance();
		Session lses_session=lneo4j.getSessionByDriver();
		StatementResult lst_result = null;
		
		try {
	    	lst_result = lses_session.run(astr_query);
	    } catch (Exception e) {
			System.out.println("Query Execution exception");
			e.printStackTrace();
			return null;
		} finally {
			lses_session.close();
		}
		
		return lst_result;
	}
	
	//insert or update the nodes values 
	public Integer update(String astr_query){
		int lint_return = -1;
		
		try {
			StatementResult lst_result = executeQuery(astr_query);
			
	    	while (lst_result.hasNext()) {
		       Record record = lst_result.next();
		       lint_return = Integer.parseInt(record.get("COUNT(*)").toString());
		    }
			lint_return = 0;
		} catch (Exception e) {
			System.out.println("Result parsing exception");
			e.printStackTrace();
			return null;
		}
		
		return lint_return;
	}
	
	//retrieve all the attributes of nodes based on the cypher query passed
	public JSONArray retrieveNode(String astr_query) throws Exception{
		JSONArray js_result = new JSONArray();
		StatementResult lst_result = executeQuery(astr_query);
	    
	    try {
	    	while (lst_result.hasNext()) {
	 	       Record record = lst_result.next();
	 	       js_result.put(new Gson().toJson(record.get(0).asMap()));
	 	    }
	    }catch (Exception e) {
			System.out.println("Result parsing exception");
			e.printStackTrace();
			return null;
		}
	    
	    if(js_result.length() > 0) {
	    	for(int lint_ = 0; lint_ < js_result.length(); lint_++) {
	    		System.out.println(js_result.get(lint_).toString());
	    	}
	    }
	    System.out.println(js_result);
	   
	    return js_result;
	}
	
	//retrieve the relationships between nodes 
	public JSONArray retrieveRelationships(String astr_query) throws Exception{
		JSONArray js_result = new JSONArray();
		StatementResult lst_result = executeQuery(astr_query);
	    
	    try {
	    	while (lst_result.hasNext()) {
	 	       Record record = lst_result.next();
	 	       js_result.put(new Gson().toJson(record.get(0).asMap()));
	 	    }
	    }catch (Exception e) {
			System.out.println("Result parsing exception");
			e.printStackTrace();
			return null;
		}
	    
		return js_result;
	}
	

	
}
