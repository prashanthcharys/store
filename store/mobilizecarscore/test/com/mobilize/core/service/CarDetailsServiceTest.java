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

public class CarDetailsServiceTest {
	private static Logger logger = Logger.getLogger( PaymentDetailsServiceTest.class );
	private static String SERVICE_URL;

	String 				service = "car";
	HashMap<String,String> 			insertPaymentObject = null;
	URLConnection   	urlConn;
	private DataInputStream     responseStream;
	String insertCars;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SERVICE_URL = AllTests.SERVICE_URL_PREFIX+"/car";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		HashMap<String,String>  insertPaymentObject = new HashMap<String,String> ();
		insertPaymentObject.put("uid", "UID1");
		insertPaymentObject.put("carId", "CA1235");
		insertPaymentObject.put("year", "2012");
		insertPaymentObject.put("make", "TOYOTA");
		insertPaymentObject.put("model", "CAMRY");
		insertPaymentObject.put("color", "BLUE");
		insertPaymentObject.put("mileage", "20000");
		insertPaymentObject.put("price", "25000");
		insertPaymentObject.put("comments", "EXCELLENT");

		//insertPaymentObject.put("transactionDate", "11/11/2012");
		JSONObject jsonInsertObject = new JSONObject( insertPaymentObject );
		logger.info("Initial CarDetails Object:"+ jsonInsertObject.toString() );
		insertCars = jsonInsertObject.toString();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testInsertCarDetails() {
		try {
			//delete before inserting
			testDeleteUserDetailsById();
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "addAuto");

			//Send the JSON request data
			AllTests.sendRequest( insertCars);
			logger.info("Insert called. "  );

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is inserted", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of car records inserted ====================================: " + str );
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
		// call all for complete test
		testGetCarDetailsByCarId();
		testUpdateCarDetailsById();
		testGetCarDetailsByUid();
		testDeleteUserDetailsById();
	}


	public final void testGetCarDetailsByCarId() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "getAutoDetailsByCarId/CA1235");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			logger.info("select by car id called. "  );

			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is selected", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of car records selected ====================================: " + str );
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

	public final void testUpdateCarDetailsById() {

		try {
			HashMap<String,String>  insertPaymentObject = new HashMap<String,String> ();
			insertPaymentObject.put("uid", "UID1");
			insertPaymentObject.put("carId", "CA1235");
			insertPaymentObject.put("year", "2012");
			insertPaymentObject.put("make", "TOYOTA");
			insertPaymentObject.put("model", "CAMRY");
			insertPaymentObject.put("color", "BLUE");
			insertPaymentObject.put("mileage", "20000");
			insertPaymentObject.put("price", "29000");
			insertPaymentObject.put("comments", "GOOD");

			//insertPaymentObject.put("transactionDate", "11/11/2012");
			JSONObject jsonInsertObject = new JSONObject( insertPaymentObject );
			logger.info( jsonInsertObject.toString() );
			insertCars = jsonInsertObject.toString();

			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "updateAuto");
			logger.info("update called. "  );

			//Send the JSON request data
			AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is updated", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of car records updated =====================================: " + str );
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

	public final void testGetCarDetailsByUid() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "getAutoDetailsByUid/UID1");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			logger.info("select by UID called. "  );

			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data select by uid", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of car records selected ============================================: " + str );
					//System.out.println("Number of car records selected : " + str );

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


	public final void testDeleteUserDetailsById() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "deleteAuto/UID1");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is DELETED", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of car records deleted ========================================:" + str );
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
