package com.quantum.helper;

public class ResultSet {
	
		private  boolean result;
		private String exceptionmsg;
		
		public ResultSet()	{
			result = false;
			exceptionmsg = "";
		}
		
		public boolean getResult(){
			return result;
		}
		
		public String getExceptionmsg(){
			return exceptionmsg;
		}
		
		public void SetResult(boolean result1){
			result = result1;
		}
		
		public void setExceptionmsg(String msg){
			exceptionmsg = msg;
		}
}
