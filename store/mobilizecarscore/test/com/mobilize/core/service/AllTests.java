package com.mobilize.core.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.mobilize.core.service.CarDetailsServiceTest;
import com.mobilize.core.service.CardDetailsServiceTest;

//specify a runner class: Suite.class
@RunWith(Suite.class)

//specify an array of test classes
@Suite.SuiteClasses({
				CardDetailsServiceTest.class,
				CarDetailsServiceTest.class,
				LoginServiceTest.class,
				PaymentDetailsServiceTest.class,
				SearchCriteriaServiceTest.class,
				SearchLogServiceTest.class,
				UserDetailsServiceTest.class,
				UserPrefServiceTest.class,
				UserPref2ServiceTest.class})
public class AllTests {
	
	protected static final String HOST = "localhost";
	protected static final String PORT = "8080";
	protected static final String CONTEXT = "autoweb";
	
	protected static final String SERVICE_URL_PREFIX = "http://"+HOST+":"+PORT+"/"+CONTEXT+"/webservice";

	protected static URLConnection   	urlConn;
    private static DataOutputStream   	requestStream;


	protected static URLConnection getServiceConnection( String service, String serviceType ) throws Exception {
		//Make the actual connection
		URL url = new URL (SERVICE_URL_PREFIX +"/" + service + "/" + serviceType);
        urlConn = url.openConnection();
        urlConn.setDoInput (true);
        urlConn.setDoOutput (true);
        urlConn.setUseCaches (false);
        urlConn.setRequestProperty("Content-Type", "application/json");
        
        return urlConn;
	}
	
	protected static void sendRequest(String payload ) {
        try {
        	requestStream = new DataOutputStream (urlConn.getOutputStream ());
        	requestStream.writeBytes ( payload );
        	requestStream.flush ();
        	requestStream.close ();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected static Object receiveResponse() {
		return null;
	}
}
