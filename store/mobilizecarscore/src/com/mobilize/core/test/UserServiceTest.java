package com.mobilize.core.test;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mobilize.core.domain.value.UserDetailsVO;

public class UserServiceTest extends BaseTest{
	
	//private static final String URL_STRING = "http://localhost:8080/mobilizecarsweb/webservice/user";
	public static void main(String args[]){
		
		locationServiceRequest();
		
		//loginServiceRequest();
		//addUserServiceRequest();
		//updateUserServiceRequest();
		//deleteUserServiceRequest();
		
		//getUserDetailsServiceRequest();
		//addUserDetailsServiceRequest();
		//updateUserDetailsServiceRequest();
		//deleteUserDetailsServiceRequest();
	}

	public static String getJSONString(String uid, String userType, double lat, double lon) {
        HashMap<String,String> testObj = new HashMap<String,String>();
        testObj.put("userId", uid);
        testObj.put("userType", userType);
        testObj.put("latitude", lat+"");
        testObj.put("longitude", lon+"");        
        JSONObject jsonObj = new JSONObject(testObj);
        System.out.println("location:"+jsonObj.toString());
        return jsonObj.toString();
	}
	
	public static void locationServiceRequest() {
		//String JSONString = getJSONString(null,"guru","guru", "B");
		String JSONString = getJSONString("UID3","B",40.714224, -73.961452);
		String output = executeHTTPService(JSONString, "location/findCars");
		System.out.println(output);
		try {
	       // JSONObject jsonObj = new JSONObject(output);
	        
	        JSONArray jArray = new JSONArray(output);
	        for (int i=0; i<jArray.length();i++) {
	        	JSONObject obj = jArray.getJSONObject(i);
	        	System.out.println(obj.getString("uid"));
	        }
	        	        
	        /*
	        JSONArray jarray = jsonObj.getJSONArray("");
	        List list = new ArrayList();
	        
	        for (int i=0; i<jarray.length(); i++) {
	        	JSONObject obj = (JSONObject) jarray.get(i);
	        	String pcode = obj.getString("uid");
	        	list.add(pcode);
	        	//list.add(obj.getString("postalCode"));
	        	System.out.println("Postal Codes: "+pcode);
	        }
	        */
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void loginServiceRequest() {
		String JSONString = getJSONString(null,"guru","guru", "B");
		String output = executeHTTPService(JSONString, "user/login");
		System.out.println(output);
	}
	
	public static void addUserServiceRequest() {
		String JSONString = getJSONString(null,"guru1","guru1", "B");
		String output = executeHTTPService(JSONString, "user/addUser");
		System.out.println(output);
	}
	
	public static void updateUserServiceRequest() {
		String JSONString = getJSONString("UID4","guru1","guru2", "S");
		String output = executeHTTPService(JSONString, "user/updateUser");
		System.out.println(output);
	}

	public static void deleteUserServiceRequest() {
		String JSONString = getJSONString("UID4","guru1","guru2", "S");
		String output = executeHTTPService(JSONString, "user/deleteUser");
		System.out.println(output);
	}
	
	public static void getUserDetailsServiceRequest() {
		String JSONString = getJSONString("UID3","guru","guru", "B");
		String output = executeHTTPService(JSONString, "user/getUserDetails");
		System.out.println(output);
	}
	
	public static void addUserDetailsServiceRequest() {
		UserDetailsVO userdet= getUserDetailsVO();
		String JSONString = getJSONString(userdet);
		String output = executeHTTPService(JSONString, "user/addUserDetails");
		System.out.println(output);
	}
	
	public static void updateUserDetailsServiceRequest() {
		UserDetailsVO userdet= getUserDetailsVO();
		userdet.setUid("UID8");
		String JSONString = getJSONString(userdet);
		String output = executeHTTPService(JSONString, "user/updateUserDetails");
		System.out.println(output);
	}

	public static void deleteUserDetailsServiceRequest() {
		String JSONString = getJSONString("UID7","guru","guru", "B");
		String output = executeHTTPService(JSONString, "user/deleteUserDetails");
		System.out.println(output);
	}

	public static String getJSONString(String uid, String userId, String password, String userType) {
        HashMap<String,String> testObj = new HashMap<String,String>();
        testObj.put("uid", uid);
        testObj.put("userId", userId);
        testObj.put("password", password);
        testObj.put("status", "ACTIVE");
        testObj.put("userType", userType);
        
        JSONObject jsonObj = new JSONObject(testObj);
        System.out.println("add:"+jsonObj.toString());
        return jsonObj.toString();
	}
	
	public static String getJSONString(UserDetailsVO userDetailVO) {
        HashMap<String,String> testObj = new HashMap<String,String>();
        testObj.put("uid", userDetailVO.getUid());
        testObj.put("userId", userDetailVO.getUserId());
        testObj.put("password", userDetailVO.getPassword());
        testObj.put("userType", userDetailVO.getUserType());
        
        testObj.put("firstName", userDetailVO.getFirstName());
        testObj.put("lastName", userDetailVO.getLastName());
        testObj.put("addressLine1", userDetailVO.getAddressLine1());
        testObj.put("addressLine2", userDetailVO.getAddressLine2());
        
        testObj.put("city", userDetailVO.getCity());
        testObj.put("state", userDetailVO.getState());
        testObj.put("zip", userDetailVO.getZip());
        testObj.put("country", userDetailVO.getCountry());
        
        testObj.put("homePhone", userDetailVO.getHomePhone());
        testObj.put("mobilePhone", userDetailVO.getMobilePhone());
        testObj.put("emailId", userDetailVO.getEmailId());

        JSONObject jsonObj = new JSONObject(testObj);
        System.out.println("add:"+jsonObj.toString());
        return jsonObj.toString();
	}

	public static UserDetailsVO getUserDetailsVO() {
		UserDetailsVO userDetailVO = new UserDetailsVO();
		userDetailVO.setUserId("Guru2");
		userDetailVO.setPassword("Guru2");
		userDetailVO.setUserType("B");
		userDetailVO.setFirstName("Guru");
		userDetailVO.setLastName("Teegala");
		
		userDetailVO.setAddressLine1("5 Virginia Street");
		userDetailVO.setCity("New City");
		userDetailVO.setState("NY");
		userDetailVO.setZip("10956");
		
		userDetailVO.setAddressLine1("5 Virginia Street");
		userDetailVO.setCity("New City");
		userDetailVO.setState("NY");
		userDetailVO.setCountry("USA");

		userDetailVO.setHomePhone("8457087060");
		userDetailVO.setMobilePhone("20128354470");
		userDetailVO.setEmailId("gteegala@yahoo.com");

        return userDetailVO;
	}

}