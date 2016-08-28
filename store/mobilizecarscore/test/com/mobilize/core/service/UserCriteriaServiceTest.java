package com.mobilize.core.service;

import static org.junit.Assert.*;

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

public class UserCriteriaServiceTest {
	private static Logger logger = Logger.getLogger( PaymentDetailsServiceTest.class );
	private static String SERVICE_URL;

	String 				service = "userCriteria";
	HashMap<String,String> 			insertPaymentObject = null;
	URLConnection   	urlConn;
	private DataInputStream     responseStream;
	String insertUserCriteria;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SERVICE_URL = AllTests.SERVICE_URL_PREFIX+"/userCriteria";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		HashMap<String,String>  insertPaymentObject = new HashMap<String,String> ();
		insertPaymentObject.put("uid", "UID1");
		insertPaymentObject.put("yearFrom", "1994");
		insertPaymentObject.put("yearTo", "2012");
		insertPaymentObject.put("make", "BMW");
		insertPaymentObject.put("model", "X6");
		insertPaymentObject.put("color", "BLUE");
		insertPaymentObject.put("priceFrom", "45000");
		insertPaymentObject.put("priceTo", "90000");
		insertPaymentObject.put("mileage", "10");
		insertPaymentObject.put("radius", "60");
		//insertPaymentObject.put("timeStamp", "11/11/2012");

		//insertPaymentObject.put("transactionDate", "11/11/2012");
		JSONObject jsonInsertObject = new JSONObject( insertPaymentObject );
		logger.info("Initial User Criteria Object:"+ jsonInsertObject.toString() );
		insertUserCriteria = jsonInsertObject.toString();		
	}

	@After
	public void tearDown() throws Exception {
	}


	public final void testGetUserCriteria() {

		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "getUserCriteria/UID1");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			logger.info("select by user criteria called. "  );

			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is selected", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of records selected ====================:" + str );
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

	public final void testUpdateUserCriteriaById() {
		try {
			HashMap<String,String>  insertPaymentObject = new HashMap<String,String> ();
			insertPaymentObject.put("uid", "UID1");
			insertPaymentObject.put("yearFrom", "2007");
			insertPaymentObject.put("yearTo", "2012");
			insertPaymentObject.put("make", "BMW");
			insertPaymentObject.put("model", "X6");
			insertPaymentObject.put("color", "BLUE");
			insertPaymentObject.put("priceFrom", "45000");
			insertPaymentObject.put("priceTo", "90000");
			insertPaymentObject.put("mileage", "10");
			insertPaymentObject.put("radius", "90");
			//insertPaymentObject.put("timeStamp", "11/11/2012");
			//insertPaymentObject.put("transactionDate", "11/11/2012");
			JSONObject jsonInsertObject = new JSONObject( insertPaymentObject );
			logger.info("Initial User Criteria Object:"+ jsonInsertObject.toString() );
			insertUserCriteria = jsonInsertObject.toString();	

			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "updateUserCriteria");
			logger.info("User Criteria update called. "  );

			//Send the JSON request data
			AllTests.sendRequest( insertUserCriteria);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is updated", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of car records updated ====================:" + str );
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
	public final void testInsertUserCriteria() {
		//Deleted if existing
		testDeleteUserCriteriaById();
		testGetUserCriteria();

		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "addUserCriteria");

			//Send the JSON request data
			AllTests.sendRequest( insertUserCriteria);
			logger.info("User Criteria Insert called. "  );

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("User Criteria data is inserted", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of records inserted ====================:" + str );
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
		// testing all together.
		testGetUserCriteria();
		testUpdateUserCriteriaById();
		testGetUserCriteria();
		testDeleteUserCriteriaById();

	}

	public final void testDeleteUserCriteriaById() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "deleteUserCriteria/UID1");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			logger.info("Delete by user criteria called. "  );

			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is selected", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of User criteria records deleted ====================:" + str  );
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

}
