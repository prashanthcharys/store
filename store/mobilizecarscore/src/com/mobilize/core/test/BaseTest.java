package com.mobilize.core.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class BaseTest {
	//private static final String URL_STRING = "http://localhost:8080/mobilizecarsweb/webservice";
	private static final String URL_STRING = "http://54.245.108.98:8080/mobilizecarsweb/webservice";

	public static String executeHTTPService(String JSONString, String serviceName) {
		StringBuffer buffer = new StringBuffer();
        try {
            URL                 url;
            URLConnection   urlConn;
            DataOutputStream    printout;
            DataInputStream     input;

            //Make the actual connection
            url = new URL (URL_STRING+"/"+serviceName);
            urlConn = url.openConnection();
            urlConn.setDoInput (true);
            urlConn.setDoOutput (true);
            urlConn.setUseCaches (false);
            urlConn.setRequestProperty("Content-Type", "application/json");

            //Send the JSON data
            printout = new DataOutputStream (urlConn.getOutputStream ());
            printout.writeBytes (JSONString);
            printout.flush ();
            printout.close ();

            // Get response
            input = new DataInputStream (urlConn.getInputStream ());
            String str;
            while (null != ((str = input.readLine()))) {
               try {
                   //System.out.println(str);
                   buffer.append(str);
               } catch (Exception e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
            }
            input.close ();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
        return buffer.toString();
	}
}
