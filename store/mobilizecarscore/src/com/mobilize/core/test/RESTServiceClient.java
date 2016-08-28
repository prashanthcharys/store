package com.mobilize.core.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.json.JSONObject;

public class RESTServiceClient {
	public static void main(String args[]){
		//paymentAdd();
		updatePayment();
		//getPayment("UID2");
		//user();
		//getUserDetails("UID3");
	}
    
    public static void paymentAdd(){
          HashMap<String,String> testObj = new HashMap<String,String>();
          testObj.put("uid", "UID4");
          testObj.put("cardNumber", "6362727888999");
          testObj.put("carId", "72727");
          testObj.put("tranDateString", "11/11/2012");
          testObj.put("amount", "00.75");
          //testObj.put("transactionDate", "11/11/2012");
          
          JSONObject jsonObj = new JSONObject(testObj);
          System.out.println("add:"+jsonObj.toString());
          try {
             URL                 url;
             URLConnection   urlConn;
             DataOutputStream    printout;
             DataInputStream     input;

             //Make the actual connection
             url = new URL ("http://localhost:8080/mobilizecarsweb/webservice/payment/addPayment");
             urlConn = url.openConnection();
             urlConn.setDoInput (true);
             urlConn.setDoOutput (true);
             urlConn.setUseCaches (false);
             urlConn.setRequestProperty("Content-Type", "application/json");

             //Send the JSON data
             printout = new DataOutputStream (urlConn.getOutputStream ());
             String content = jsonObj.toString();
             printout.writeBytes (content);
             printout.flush ();
             printout.close ();

             // Get response
             input = new DataInputStream (urlConn.getInputStream ());
             String str;
             while (null != ((str = input.readLine())))
             {
                try {
                    System.out.println(str);
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
       }
    public static void updatePayment(){
        try {
           URL                 url;
           URLConnection   urlConn;
           DataOutputStream    printout;
           DataInputStream     input;
           
           HashMap<String,String> testObj = new HashMap<String,String>();
           testObj.put("uid", "UID3");
           testObj.put("cardNumber", "6362727888999");
           testObj.put("carId", "72727");
           testObj.put("tranDateString", "11/11/2012");
           testObj.put("amount", "1111.00");           
           JSONObject jsonObj = new JSONObject(testObj);
           System.out.println("update:"+jsonObj.toString());
           //Make the actual connection
           url = new URL ("http://localhost:8080/mobilizecarsweb/webservice/payment/updatePayment");
           urlConn = url.openConnection();
           urlConn.setDoInput (true);
           urlConn.setDoOutput (true);
           urlConn.setUseCaches (false);
           urlConn.setRequestProperty("Content-Type", "application/json");

           //Send the JSON data
           printout = new DataOutputStream (urlConn.getOutputStream ());
           String content = jsonObj.toString();
           printout.writeBytes (content);
           printout.flush ();
           printout.close ();

           // Get response
           input = new DataInputStream (urlConn.getInputStream ());
           String str;
           while (null != ((str = input.readLine())))
           {
              try {
                  System.out.println(str);
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
     }
    public static void getPayment(String id){
        try {
           URL                 url;
           URLConnection   urlConn;
           DataInputStream     input;
           //Make the actual connection
           url = new URL ("http://localhost:8080/mobilizecarsweb/webservice/payment/getPayment/"+id);
           urlConn = url.openConnection();
           urlConn.setDoInput (true);
           urlConn.setDoOutput (true);
           urlConn.setUseCaches (false);
           // Get response
           input = new DataInputStream (urlConn.getInputStream ());
           String str;
           while (null != ((str = input.readLine()))) {
              try {
                  System.out.println(str);
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
     }    
    public static void user(){
          HashMap<String,String> testObj = new HashMap<String,String> ();
          testObj.put("uid", "UID3");
          testObj.put("firstName", "Guru");
          testObj.put("lastName", "Teegala");
          testObj.put("addressLine1", "10 Viriginia");
          testObj.put("addressLine2", "");
          testObj.put("city", "New City");
          testObj.put("state", "NY");
          testObj.put("zip", "10956");
          testObj.put("country", "USA");
          testObj.put("homePhone", "8457087060");
          testObj.put("mobilePhone", "2018354470");
          testObj.put("emailId", "gteegala@hotmail.com");
          JSONObject jsonObj = new JSONObject(testObj);
          System.out.println("input:"+jsonObj.toString());
          try {
             URL                 url;
             URLConnection   urlConn;
             DataOutputStream    printout;
             DataInputStream     input;

             //Make the actual connection
             url = new URL ("http://localhost:8080/mobilizecarsweb/webservice/user/updateUser");
             urlConn = url.openConnection();
             urlConn.setDoInput (true);
             urlConn.setDoOutput (true);
             urlConn.setUseCaches (false);
             urlConn.setRequestProperty("Content-Type", "application/json");

             //Send the JSON data
             printout = new DataOutputStream (urlConn.getOutputStream ());
             String content = jsonObj.toString();
             printout.writeBytes (content);
             printout.flush ();
             printout.close ();

             // Get response
             input = new DataInputStream (urlConn.getInputStream ());
             String str;
             while (null != ((str = input.readLine())))
             {
                try {
                    System.out.println("return:"+str);
                } catch (Exception e) {
                   e.printStackTrace();
                }
             }
             input.close ();
          } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
          }
       }
    public static void getUserDetails(String id){
        try {
           URL                 url;
           URLConnection   urlConn;
           DataInputStream     input;
           //Make the actual connection
           url = new URL ("http://localhost:8080/mobilizecarsweb/webservice/user/deleteUser/"+id);
           urlConn = url.openConnection();
           urlConn.setDoInput (true);
           urlConn.setDoOutput (true);
           urlConn.setUseCaches (false);
           // Get response
           input = new DataInputStream (urlConn.getInputStream ());
           String str;
           while (null != ((str = input.readLine()))) {
              try {
                  System.out.println(str);
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
     }

}
