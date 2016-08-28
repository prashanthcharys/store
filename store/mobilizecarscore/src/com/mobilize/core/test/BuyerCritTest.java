package com.mobilize.core.test;

import java.util.HashMap;

import org.json.JSONObject;

import com.mobilize.core.domain.value.BuyerCriteriaVO;

public class BuyerCritTest extends BaseTest {
	
	public static void main(String args[]){
		
		 //addBuyerCriteriaServiceRequest();
		 //updateBuyerCriteriaServiceRequest();
		// getBuyerCriteriaByIdServiceRequest();
		 //getBuyerCriteriaByCritIdServiceRequest();
		 //deleteBuyerCriteriaByCritIdServiceRequest();
		 deleteBuyerCriteriaByIdServiceRequest();
		
	}

	
	public static void getBuyerCriteriaByIdServiceRequest() {
		String JSONString = getJSONString("UID3",1);
		String output = executeHTTPService(JSONString, "userCriteria/getUserCriteriaById");
		System.out.println(output);
	}

	public static void getBuyerCriteriaByCritIdServiceRequest() {
		String JSONString = getJSONString("UID3",1);
		String output = executeHTTPService(JSONString, "userCriteria/getUserCriteriaByCritId");
		System.out.println(output);
	}

	public static void addBuyerCriteriaServiceRequest() {
		BuyerCriteriaVO userdet= getBuyerCriteriaVO();
		String JSONString = getJSONString(userdet);
		String output = executeHTTPService(JSONString, "userCriteria/addUserCriteria");
		System.out.println(output);
	}
	
	public static void updateBuyerCriteriaServiceRequest() {
		BuyerCriteriaVO userdet= getBuyerCriteriaVO();
		userdet.setModel("Carola");
		String JSONString = getJSONString(userdet);
		String output = executeHTTPService(JSONString, "userCriteria/updateUserCriteria");
		System.out.println(output);
	}

	public static void deleteBuyerCriteriaByIdServiceRequest() {
		String JSONString = getJSONString("UID3",1);
		String output = executeHTTPService(JSONString, "userCriteria/deleteUserCriteriaById");
		System.out.println(output);
	}

	public static void deleteBuyerCriteriaByCritIdServiceRequest() {
		String JSONString = getJSONString("UID3",1);
		String output = executeHTTPService(JSONString, "userCriteria/deleteUserCriteriaByCritId");
		System.out.println(output);
	}

	public static String getJSONString(String uid, int critId) {
        HashMap<String,String> testObj = new HashMap<String,String>();
        testObj.put("uid", uid);
        testObj.put("critId", ""+critId);
        
        JSONObject jsonObj = new JSONObject(testObj);
        System.out.println("add:"+jsonObj.toString());
        return jsonObj.toString();
	}
	
	public static String getJSONString(BuyerCriteriaVO buyerCriteriaVO) {
        HashMap<String,String> testObj = new HashMap<String,String>();
        testObj.put("uid", buyerCriteriaVO.getUid());
        testObj.put("critId", ""+buyerCriteriaVO.getId());
        testObj.put("yearFrom", buyerCriteriaVO.getYearFrom());
        testObj.put("yearTo", buyerCriteriaVO.getYearTo());
        
        testObj.put("make", buyerCriteriaVO.getMake());
        testObj.put("model", buyerCriteriaVO.getModel());
        testObj.put("color", buyerCriteriaVO.getColor());
        testObj.put("priceFrom", ""+buyerCriteriaVO.getPriceFrom());
        
        testObj.put("priceTo", ""+buyerCriteriaVO.getPriceTo());
        testObj.put("mileage", ""+buyerCriteriaVO.getMileage());
        testObj.put("radius", ""+buyerCriteriaVO.getRadius());
        
        testObj.put("yearPref", ""+buyerCriteriaVO.getYearPref());
        testObj.put("makePref", ""+buyerCriteriaVO.getMakePref());
        testObj.put("modelPref", ""+buyerCriteriaVO.getModelPref());

        testObj.put("colorPref", ""+buyerCriteriaVO.getColorPref());
        testObj.put("pricePref", ""+buyerCriteriaVO.getPricePref());
        testObj.put("mileagePref", ""+buyerCriteriaVO.getMileagePref());
        testObj.put("radiusPref", ""+buyerCriteriaVO.getRadiusPref());

        JSONObject jsonObj = new JSONObject(testObj);
        System.out.println("add:"+jsonObj.toString());
        return jsonObj.toString();
	}

	public static BuyerCriteriaVO getBuyerCriteriaVO() {
		BuyerCriteriaVO buyerCriteriaVO = new BuyerCriteriaVO();
		buyerCriteriaVO.setUid("UID3");
		buyerCriteriaVO.setId(1+"");
		buyerCriteriaVO.setYearFrom("2005");
		buyerCriteriaVO.setYearTo("2012");
		buyerCriteriaVO.setMake("Toyota");
		buyerCriteriaVO.setModel("Camry");
		buyerCriteriaVO.setColor("Black");
		buyerCriteriaVO.setPriceFrom(10000);
		buyerCriteriaVO.setPriceTo(12000);
		buyerCriteriaVO.setMileage(10000);
		buyerCriteriaVO.setRadius(50);
		buyerCriteriaVO.setYearPref(1);
		buyerCriteriaVO.setMakePref(2);
		buyerCriteriaVO.setModelPref(3);
		buyerCriteriaVO.setColorPref(4);
		buyerCriteriaVO.setPricePref(5);
		buyerCriteriaVO.setMileagePref(6);
		buyerCriteriaVO.setRadiusPref(7);
        return buyerCriteriaVO;
	}
}
