package com.mobilize.core.common;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mobilize.core.domain.value.LocationVO;

public class JSONParser {
	public static ArrayList<LocationVO> getLocationObjects(String jsonString, String code) {
		ArrayList<LocationVO> list = new ArrayList<LocationVO>();
		try {
			System.out.println("JSON: "+jsonString);
			
			JSONObject jsonObj = new JSONObject(jsonString);
			JSONArray array = jsonObj.getJSONArray("results");
			
			JSONObject object1 = array.getJSONObject(0);
			JSONObject object2 = object1.getJSONObject("geometry");
			JSONObject object3 = object2.getJSONObject("location");
			System.out.println(object3.toString());
	        
			double lat = object3.getDouble("lat");
			double longi = object3.getDouble("lng");

	        System.out.println("Latitude: "+lat);
	        System.out.println("Longitude: "+longi);
	        
	        LocationVO loc = new LocationVO();
	        loc.setLatitude(lat);
	        loc.setLongitude(longi);
	        list.add(loc);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
