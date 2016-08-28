package com.mobilize.core.test;

import java.util.HashMap;

import org.json.JSONObject;

import com.mobilize.core.domain.value.UserDetailsVO;

public class UserHTTPClientAdapter extends HttpClientAdapter{

	//private static final String TAG = UserHTTPClientAdapter.class.getCanonicalName();
	private static String JSONString = null;
	public static void loginServiceRequest(String userId, String password) {
		JSONString = getJSONString(null,userId,password, "B");
		new Thread() {
			public void run() {
				//Log.d(TAG, "before json string call");
				//String JSONString = getJSONString(null,userId,password, "B");
				//Log.d(TAG, "after json string call");
				String output = executeHTTPService(JSONString, "user/login");
				System.out.println(output);
				//Log.d(TAG, "after http call: "+output);
			}
		}.start();
		//System.out.println(output);
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
	
	public static void main(String args[]) {
		loginServiceRequest("guru","guru");
	}
}
