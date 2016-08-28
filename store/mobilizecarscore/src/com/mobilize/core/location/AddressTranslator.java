package com.mobilize.core.location;

import java.util.ArrayList;
import java.util.List;

import com.mobilize.core.common.JSONParser;
import com.mobilize.core.domain.value.Address;
import com.mobilize.core.domain.value.HomeAddressVO;
import com.mobilize.core.domain.value.LocationVO;
import com.mobilize.core.domain.value.NameValueVO;

public class AddressTranslator {
	
	//http://maps.googleapis.com/maps/api/geocode/json?address=5+Virginia+street,+New+City,+NY&sensor=true
	//http://maps.googleapis.com/maps/api/geocode/json?address=5+Virginia+street,+New+City,+NY&sensor=true
	private static final String ADDR_LOC_URL = "http://maps.googleapis.com/maps/api/geocode/json";
	//private static final String SENSOR = "sensor=true";	
	
	public static void main(String[] args) {
		try {
			Address addr = new HomeAddressVO();
			addr.setStreet1("5+Virginia");
			addr.setCity("New+City");
			addr.setState("NY");
			getLatLongOnAddress(addr);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static ArrayList<LocationVO> getLatLongOnAddress(Address address) throws Exception {
		String resultString = null;
		List<NameValueVO> parameters = new ArrayList<NameValueVO>();
		NameValueVO param1 = new NameValueVO();
		param1.setName("address");
		param1.setValue(getAddressString(address));
		parameters.add(param1);
		NameValueVO param2 = new NameValueVO();
		param2.setName("sensor");
		param2.setValue("true");
		parameters.add(param2);
		resultString = HTTPServiceClient.executeHTTPRequest(ADDR_LOC_URL, parameters);
		
		ArrayList<LocationVO> list = JSONParser.getLocationObjects(resultString, "location");
		return list;
	}

	public static String getAddressString(Address address) {
		StringBuffer buffer = new StringBuffer();
		String street1 = address.getStreet1();
		String street2 = address.getStreet2();
		String city = address.getCity();
		String state = address.getState();
		
		if (street1 != null) {
			/*
			for (int i=0;i<street1.length(); i++) {
				char ch = street1.charAt(i);
				if (ch == ' ') {
					street1.
				}
			}
			*/
			
			street1 = street1.replace(" ", "+");
		}
		
		if (street2 != null && street2.trim().length() > 0) {
			street2 = street2.replace(" ", "+");
		} else {
			street2 = null;
		}

		if (city != null) {
			city = city.replace(" ", "+");
		}

		buffer.append(street1);
		buffer.append(",");
		if (street2 != null) {
			buffer.append(street2);
			buffer.append(",");
		}
		buffer.append(city);
		buffer.append(",");
		buffer.append(state);
		
		return buffer.toString();
	}
}
