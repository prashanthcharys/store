package com.mobilize.core.service;

import static org.junit.Assert.fail;

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

public class CardDetailsServiceTest {
	private static Logger logger = Logger.getLogger( PaymentDetailsServiceTest.class );
	private static String SERVICE_URL;
	
	String 				service = "card";
	HashMap<String,String> 			insertPaymentObject = null;
    URLConnection   	urlConn;
    private DataInputStream     responseStream;
    String insertCard;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	      HashMap<String,String> insertPaymentObject = new HashMap<String,String>();
	        insertPaymentObject.put("uid", "UID1");
	        insertPaymentObject.put("cardNumber", "1111222233334444");
	        insertPaymentObject.put("firstName", "ugandhar");
	        insertPaymentObject.put("lastName", "yarabham");
	        insertPaymentObject.put("expDate", "2012-12-11");
	        insertPaymentObject.put("type", "VISA");
	        insertPaymentObject.put("cvvCode", "111");
	        
			//insertPaymentObject.put("transactionDate", "11/11/2012");
			JSONObject jsonInsertObject = new JSONObject( insertPaymentObject );
			logger.info("Initial CarDetails Object:"+ jsonInsertObject.toString() );
			insertCard = jsonInsertObject.toString();
	}

	@After
	public void tearDown() throws Exception {
	}

	public final void testGetCardDetails() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "getCard/1111222233334444");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			logger.info("select by card id called. "  );

			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is selected", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of Card details records selected ===================:" + str );
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
		}	}

	@Test
	public final void testInsertCardDetails() {
		//delete before inserting
		testDeleteCardDetailsById();
		try {
			 	        	//get web service connection
	        	urlConn = AllTests.getServiceConnection(service, "addCard");

	        	//Send the JSON request data
	        	AllTests.sendRequest( insertCard);
				logger.info("Insert called. "  );

	          	// Get response
	        	responseStream = new DataInputStream (urlConn.getInputStream ());
	        	String str;
	        	while ((str = responseStream.readLine()) != null ) {
	        		try {
	        			//Assert.assertEquals("Card data is inserted", Integer.valueOf(1), Integer.valueOf(str) );
	        			logger.info("Number of Card details records inserted ===================:" + str );
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
		//testing all 
		 testGetCardDetails();
		 testUpdateCardDetailsById();
		 testGetCardDetails();
		 //testDeleteCardDetailsById();
	}

	
	public final void testDeleteCardDetailsById() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "deleteCard/1111222233334444");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Card data is DELETED", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of car records deleted : " + str );
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

	
	public final void testUpdateCardDetailsById() {
		try {
			HashMap<String,String> insertPaymentObject = new HashMap<String,String>();
	        insertPaymentObject.put("uid", "UID1");
	        insertPaymentObject.put("cardNumber", "1111222233334444");
	        insertPaymentObject.put("firstName", "ugandhar");
	        insertPaymentObject.put("lastName", "yarabham");
	        insertPaymentObject.put("expDate", "2012-12-12");
	        insertPaymentObject.put("type", "VISA");
	        insertPaymentObject.put("cvvCode", "111");
			JSONObject jsonInsertObject = new JSONObject( insertPaymentObject );
			logger.info( jsonInsertObject.toString() );
			insertCard = jsonInsertObject.toString();
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "updateCard");
			logger.info("update called. "  );

			//Send the JSON request data
			AllTests.sendRequest( insertCard);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is updated", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of Card details records updated ===================:" + str );
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
