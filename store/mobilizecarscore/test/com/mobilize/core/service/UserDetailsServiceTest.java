package com.mobilize.core.service;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDetailsServiceTest {
	private static Logger logger = Logger.getLogger( PaymentDetailsServiceTest.class );
	private static String SERVICE_URL;

	String 				service = "user";
	HashMap<String,String> 			insertPaymentObject = null;
	URLConnection   	urlConn;
	private DataInputStream     responseStream;
	String insertUser;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SERVICE_URL = AllTests.SERVICE_URL_PREFIX+"/user";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		HashMap<String,String>  insertPaymentObject = new HashMap<String,String> ();
		insertPaymentObject.put("uid", "JID1");
		insertPaymentObject.put("userid", "junit");
		insertPaymentObject.put("password", "junit");
		insertPaymentObject.put("firstName", "JUMITFIR");
		insertPaymentObject.put("lastName", "JUNITLAST");
		insertPaymentObject.put("addressLine1", "ADD1");		
		insertPaymentObject.put("addressLine2", "ADD2");
		insertPaymentObject.put("city", "CITY");
		insertPaymentObject.put("state", "STATE");
		insertPaymentObject.put("zip", "00000");
		insertPaymentObject.put("country", "USA");
		insertPaymentObject.put("homePhone", "0000000000");
		insertPaymentObject.put("mobilePhone", "1111111111");
		insertPaymentObject.put("emailId", "ABC@GMAIL.COM");		

		//insertPaymentObject.put("transactionDate", "11/11/2012");
		JSONObject jsonInsertObject = new JSONObject( insertPaymentObject );
		logger.info("Initial CarDetails Object:"+ jsonInsertObject.toString() );
		insertUser = jsonInsertObject.toString();		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	public final void testGetUserById() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "getUser/UID3");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			logger.info("select by user id called. "  );

			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is selected", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of user records selected ====================================: " + str );
					//System.out.println("Number of records selected : " + str );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			responseStream.close ();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	@Test
	public final void testInsertUser() {
		testDeleteUser();
		 try {
	        	//get web service connection
	        	urlConn = AllTests.getServiceConnection(service, "addUser");

	        	//Send the JSON request data
	        	AllTests.sendRequest( insertUser);
				logger.info("Insert called. "  );

	          	// Get response
	        	responseStream = new DataInputStream (urlConn.getInputStream ());
	        	String str;
	        	while ((str = responseStream.readLine()) != null ) {
	        		try {
	        			Assert.assertEquals("user data is inserted", Integer.valueOf(1), Integer.valueOf(str) );
	        			logger.info("Number of user records inserted ===========================: " + str );
	        		} catch (Exception e) {
	        			e.printStackTrace();
	        		}
	        	}
	        	responseStream.close ();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        } catch (Exception e1) {
				e1.printStackTrace();
			}
		 testGetUserById();
		 //testUpdatePassWord();
	}
	
	public final void testUpdatePassWord() {

		try {
			HashMap<String,String>  insertuserObject = new HashMap<String,String> ();
			insertuserObject.put("uid", "JID1");
			insertuserObject.put("userid", "junit");
			insertuserObject.put("password", "junit");
			insertuserObject.put("firstName", "JUMITFIR1");
			insertuserObject.put("lastName", "JUNITLAST1");
			insertuserObject.put("addressLine1", "ADD1");		
			insertuserObject.put("addressLine2", "ADD2");
			insertuserObject.put("city", "CITY");
			insertuserObject.put("state", "STATE");
			insertuserObject.put("zip", "00000");
			insertuserObject.put("country", "USA");
			insertuserObject.put("homePhone", "0000000000");
			insertuserObject.put("mobilePhone", "1111111111");
			insertuserObject.put("emailId", "ABC@GMAIL.COM");	

			//insertPaymentObject.put("transactionDate", "11/11/2012");
			JSONObject jsonInsertObject = new JSONObject( insertuserObject );
			logger.info("Initial CarDetails Object:"+ jsonInsertObject.toString() );
			String insertUser1 = jsonInsertObject.toString();	

			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "updateUser");
			logger.info("update called. "  );

			//Send the JSON request data
			AllTests.sendRequest( insertUser1);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is updated", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of user records updated =====================================: " + str );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			responseStream.close ();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public final void testDeleteUser() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "deleteUser/UID1");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is DELETED", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of user records deleted ========================================:" + str );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			responseStream.close ();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
