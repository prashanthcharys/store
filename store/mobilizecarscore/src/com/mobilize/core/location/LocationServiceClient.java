package com.mobilize.core.location;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class LocationServiceClient {
	
	//private static final String ENDPOINT = "http://maps.googleapis.com/maps/api/geocode/json";
	
	private static final String ENDPOINT = "http://ws.geonames.org/findNearbyPostalCodesJSON";
	//http://ws.geonames.org/findNearbyPostalCodesJSON?formatted=true
	
	public static List getZipCodesByLatLng(double lat, double lng) {
		String zipCode = null;
		List list = null;
		try {
			String jsonString = executeHTTPRequest(lat, lng);
			
			System.out.println("JSON: "+jsonString);
	        JSONObject jsonObj = new JSONObject(jsonString);
	        JSONArray jarray = jsonObj.getJSONArray("postalCodes");
	        list = new ArrayList();
	        
	        for (int i=0; i<jarray.length(); i++) {
	        	JSONObject obj = (JSONObject) jarray.get(i);
	        	String pcode = obj.getString("postalCode");
	        	list.add(pcode);
	        	//list.add(obj.getString("postalCode"));
	        	System.out.println("Postal Codes: "+pcode);
	        }

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	
    public static String executeRequest() throws Exception {
        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json");
        URLConnection conn = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer buffer = new StringBuffer();
        while ((inputLine = in.readLine()) != null) buffer.append(inputLine);
        in.close();
        return buffer.toString();
    }
    
    public static String executeHTTPRequest(double lat, double lng) throws Exception {
    	 StringBuffer buffer = new StringBuffer();
	    String url = ENDPOINT;
	    String charset = "UTF-8";
	    String param1 = "lat="+lat;
	    String param2 = "&lng="+lng;
	    String formatted = "&formatted=true";
	   // formatted=true&lat=36&lng=-79.08
	   // http://ws.geonames.org/findNearbyPostalCodesJSON?formatted=true&lat=36&lng=-79.08
	
	    /*
	    String query = String.format("key=%s", URLEncoder.encode(param1, charset));
	    java.net.URLConnection connection = new URL(url + "?" + query + sensor).openConnection();
	    connection.setRequestProperty("Accept-Charset", charset);
	    */
	    URL url1 = new URL(url + "?" + param1 + param2 + formatted);
	    URLConnection connection = url1.openConnection();
	    
	    if (connection instanceof HttpURLConnection) {
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String inputLine;
	        while ((inputLine = in.readLine()) != null) {
	        	//System.out.println(inputLine);
	        	buffer.append(inputLine);
	        }
	        in.close();
	    } else {
	       System.err.println ("error!");
	    }
	    return buffer.toString();
    }
}
