package com.mobilize.core.location;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.mobilize.core.domain.value.NameValueVO;

public class HTTPServiceClient {
		
	public static String executeHTTPRequest(String url, List<NameValueVO> parameters) throws Exception {
    	StringBuffer responsebuffer = new StringBuffer();
    	StringBuffer requestbuffer = new StringBuffer();
    	requestbuffer.append(url);
    	requestbuffer.append("?");
    	int size = parameters.size();
    	int size1 = size - 1;
    	for (int i=0; i<size; i++) {
    		NameValueVO nv = parameters.get(i);
    		requestbuffer.append(nv.getName());
    		requestbuffer.append("=");
    		requestbuffer.append(nv.getValue());
    		if (i < size1) {
    			requestbuffer.append("&");
    		}
    	}
    	System.out.println(requestbuffer.toString());
	    URL url1 = new URL(requestbuffer.toString());
	    URLConnection connection = url1.openConnection();
	    
	    if (connection instanceof HttpURLConnection) {
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String inputLine;
	        while ((inputLine = in.readLine()) != null) {
	        	//System.out.println(inputLine);
	        	responsebuffer.append(inputLine);
	        }
	        in.close();
	    } else {
	       System.err.println ("error!");
	    }
	    return responsebuffer.toString();
    }
}