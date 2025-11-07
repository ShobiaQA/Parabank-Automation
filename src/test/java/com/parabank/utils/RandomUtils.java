package com.parabank.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomUtils {
	 public static Map<String, String> generateRandomUserData(){
		 Map<String, String> userData = new HashMap<>();
		 
		 Random random = new Random();
		 int uniqueId = random.nextInt(10000);
		 userData.put("firstName", randomFirstName());
		 userData.put("lastName", randomLastName());
		 userData.put("address", randomAddress());
		 userData.put("city", "Kansas");
		 userData.put("state", "Missouri");
		 userData.put("zipCode", String.valueOf(64000 + random.nextInt(999)));
		 userData.put("phoneNumber", "555" + (1000000 + random.nextInt(8999999)));
		 userData.put("ssn", String.format("%03d-%02d-%04d", random.nextInt(900), random.nextInt(100), random.nextInt(10000)));
         userData.put("username", "user" + uniqueId);
         userData.put("password", "Pass@" + uniqueId);
         
         return userData;
		 
	 }
	 
	 public static String randomFirstName() {
		 String[] firstNames = {"Dean", "Sam", "Rachel", "Monica" ,"Sheldon","Chandler","Leonard","Ross","Joey"};
		 return firstNames[new Random().nextInt(firstNames.length)];
	 }
	 
		public static String randomLastName() {
			String[] lastNames = { "Winchester","john","Green", "Geller", "Cooper", "Bing","Davis","Brown", "Tribbiani" };
			return lastNames[new Random().nextInt(lastNames.length)];
		}

		public static String randomAddress() {
		String[] streets = { "Main St", "Oak St", "Pine St", "Maple Ave", "Cedar Ln", "Elm St", "Birch Rd" };
		return new Random().nextInt(9999) + " " + streets[new Random().nextInt(streets.length)];	
		}
					
	

}
