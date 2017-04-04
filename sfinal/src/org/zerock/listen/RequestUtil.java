package org.zerock.listen;

public class RequestUtil {
	
	//원래대로가면 함수로 만들지만 예제를 위해 
	public int getInt(String value, int defaultValue){
		
		try{
			
			return Integer.parseInt(value);
			
		}catch(Exception e){
			
			return defaultValue;
			
		}
		
	}
	
}
