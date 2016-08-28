package com.mobilize.core.service;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PaymentDetailsServiceTest {

	private static Logger logger = Logger.getLogger( PaymentDetailsServiceTest.class );
	private static String SERVICE_URL;

	String 				service = "payment";
	HashMap<String,String> 			insertPaymentObject = null;
	URLConnection   	urlConn;
	private DataInputStream     responseStream;
	String insertPaymetPayload;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SERVICE_URL = AllTests.SERVICE_URL_PREFIX+"/payment";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		HashMap<String,String>  insertPaymentObject = new HashMap<String,String> ();
		insertPaymentObject.put("uid", "UID1");
		insertPaymentObject.put("cardNumber", "6362727888999");
		insertPaymentObject.put("carId", "001");
		insertPaymentObject.put("tranDateString", "11/11/2012");
		insertPaymentObject.put("amount", "25.25");
		//insertPaymentObject.put("transactionDate", "11/11/2012");
		JSONObject jsonInsertObject = new JSONObject( insertPaymentObject );
		logger.info( jsonInsertObject.toString() );
		insertPaymetPayload = jsonInsertObject.toString();
	}

	@After
	public void tearDown() throws Exception {
	}

	public final void testGetPaymentDetailsById() {

		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "getPayment/UID1");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			logger.info("select by car id called. "  );

			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is selected", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of Payment records selected ====================================: " + str );
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
	public final void testInsertPaymentDetails() {
		// delete before inserting
		testDeletePaymentDetailsById();
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "addPayment");

			//Send the JSON request data
			AllTests.sendRequest( insertPaymetPayload);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Payment data is inserted", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of Payment records inserted ===========================: " + str );
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
		//test all
		testGetPaymentDetailsById();
		testUpdatePaymentDetailsById();
		testGetPaymentDetailsById();
		testDeletePaymentDetailsById();
	}


	public final void testDeletePaymentDetailsById() {
		try {
			HashMap<String,String>  deletePaymentObject = new HashMap<String,String> ();
			deletePaymentObject.put("uid", "UID1");
			deletePaymentObject.put("cardNumber", "6362727888999");
			deletePaymentObject.put("carId", "001");
			deletePaymentObject.put("tranDateString", "11/11/2012");
			deletePaymentObject.put("amount", "45.25");
			//insertPaymentObject.put("transactionDate", "11/11/2012");
			JSONObject jsonInsertObject = new JSONObject( deletePaymentObject );
			logger.info( jsonInsertObject.toString() );
			String deletePaymetPayload = jsonInsertObject.toString();

			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "deletePayment");
			logger.info("delete called. "  );

			//Send the JSON request data
			AllTests.sendRequest( deletePaymetPayload);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is updated", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of payment records deleted =====================================: " + str );
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


	public final void testUpdatePaymentDetailsById() {
		try {
			HashMap<String,String>  updatePaymentObject = new HashMap<String,String> ();
			updatePaymentObject.put("uid", "UID1");
			updatePaymentObject.put("cardNumber", "6362727888999");
			updatePaymentObject.put("carId", "001");
			updatePaymentObject.put("tranDateString", "11/11/2012");
			updatePaymentObject.put("amount", "45.25");
			//insertPaymentObject.put("transactionDate", "11/11/2012");
			JSONObject jsonInsertObject = new JSONObject( updatePaymentObject );
			logger.info( jsonInsertObject.toString() );
			String updatePaymetPayload = jsonInsertObject.toString();

			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "updatePayment");
			logger.info("update called. "  );

			//Send the JSON request data
			AllTests.sendRequest( updatePaymetPayload);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is updated", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of payment records updated =====================================: " + str );
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
