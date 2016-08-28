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

public class SearchCriteriaServiceTest {

	private static Logger logger = Logger.getLogger( PaymentDetailsServiceTest.class );
	private static String SERVICE_URL;

	String 				service = "searchCriteria";
	HashMap<String,String> 			insertSearchCriteria = null;
	URLConnection   	urlConn;
	private DataInputStream     responseStream;
	String insertCriteria;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SERVICE_URL = AllTests.SERVICE_URL_PREFIX+"/searchCriteria";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		HashMap<String,String>  insertSearchCriteriaObject = new HashMap<String,String> ();
		insertSearchCriteriaObject.put("uid", "UID1");
		insertSearchCriteriaObject.put("criteriaId", "1");
		insertSearchCriteriaObject.put("criteria", "SELECT * FROM CRITERIA_ID");

		//insertPaymentObject.put("transactionDate", "11/11/2012");
		JSONObject jsonInsertObject = new JSONObject( insertSearchCriteriaObject );
		logger.info("Initial Criteria Object:"+ jsonInsertObject.toString() );
		insertCriteria = jsonInsertObject.toString();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testInsertSearchCriteria() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "addSearchCriteria");

			//Send the JSON request data
			AllTests.sendRequest( insertCriteria);
			logger.info("Search Criteria Insert called. "  );

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("User Criteria data is inserted", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of records inserted : " + str );
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
		// calling in order.
		testGetSearchCriteriaByUid();
		testUpdateSearchCriteriaById();
		testGetSearchCriteriaByCriteriaId();
		testDeleteSearchCriteriaById();
	}
	
	public final void testGetSearchCriteriaByUid() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "getSearchCriteriaByUid/UID1");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			logger.info("select by Search criteria called. "  );

			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is selected", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Selected search criteria:" + str );
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


	public final void testUpdateSearchCriteriaById() {
		try {
			HashMap<String,String>  insertSearchCriteriaObject = new HashMap<String,String> ();
			insertSearchCriteriaObject.put("uid", "UID1");
			insertSearchCriteriaObject.put("criteriaId", "1");
			insertSearchCriteriaObject.put("criteria", "SELECT * FROM CRITERIA_ID_update");

			//insertPaymentObject.put("transactionDate", "11/11/2012");
			JSONObject jsonInsertObject = new JSONObject( insertSearchCriteriaObject );
			logger.info("Initial Criteria Object:"+ jsonInsertObject.toString() );
			insertCriteria = jsonInsertObject.toString();

			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "updateSearchCriteria");
			logger.info("update called. "  );

			//Send the JSON request data
			AllTests.sendRequest( insertCriteria);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is updated", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Number of Search Criterias updated : " + str );
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

	public final void testGetSearchCriteriaByCriteriaId() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "getSearchCriteriaByCriteriaId/1");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			logger.info("select by Search criteria By criteria id called. "  );

			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is selected", Integer.valueOf(1), Integer.valueOf(str) );
					logger.info("Selected search criteria:" + str );
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

	public final void testDeleteSearchCriteriaById() {
		try {
			//get web service connection
			urlConn = AllTests.getServiceConnection(service, "deleteSearchCriteria/UID1");

			//Send the JSON request data
			//AllTests.sendRequest( insertCars);

			// Get response
			responseStream = new DataInputStream (urlConn.getInputStream ());
			logger.info("Delete by search criteria called. "  );

			String str;
			while ((str = responseStream.readLine()) != null ) {
				try {
					//Assert.assertEquals("Car data is selected", Integer.valueOf(1), Integer.valueOf(str) );
					//logger.info("delete search criteria done" );
					logger.info("Number of records deleted : " + str );
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
