package com.customer;
import java.util.List;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


//import org.testng.Assert;

public class CustomerServiceTest  {

   private Client client;
   private String REST_SERVICE_URL = "http://localhost:8080/Customer_project/rest/CustomerService/customers";
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String PASS = "pass";
   private static final String FAIL = "fail";

   private void init(){
      this.client = ClientBuilder.newClient();
   }

   public static void main(String[] args){
	   CustomerServiceTest tester = new CustomerServiceTest();
      //initialize the tester
      tester.init();
      //test get all customers Web Service Method
     tester.testGetAllCustomers();
      //test get customer Web Service Method 
      tester.testGetCustomer();
      //test update customer Web Service Method
    // tester.testUpdateCustomer();
      //test add customer Web Service Method
      tester.testAddCustomer();
      //test delete customer Web Service Method
    tester.testDeleteCustomer();
   }
   //Test: Get list of all customers
   //Test: Check if list is not empty
   private void testGetAllCustomers(){
      GenericType<List<Customer>> list = new GenericType<List<Customer>>() {};
      List<Customer> users = client
         .target(REST_SERVICE_URL)
         .request(MediaType.APPLICATION_XML)
         .get(list);
      String result = PASS;
      if(users.isEmpty()){
         result = FAIL;
      }
      System.out.println("Test case name: testGetAllCustomers, Result: " + result );
      
   }
   //Test: Get customer of name Manish
   //Test: Check if customer is same as sample user
   private void testGetCustomer(){
      Customer sampleUser = new Customer();
         sampleUser.setName("Manish");
      Customer customer = client
    	         .target(REST_SERVICE_URL)
    	         .path("/{name1}")
    	         .resolveTemplate("name1","Manish")
    	         .request(MediaType.APPLICATION_XML)
    	         .get(Customer.class);
      String result = FAIL;
      if(sampleUser != null && sampleUser.getName().equals(customer.getName())){
         result = PASS;
      }
      
    	
      System.out.println("Test case name: testGetCustomer, Result: " + result );
 
     /* String result = FAIL;
      if(sampleUser != null && sampleUser.getName() == customer.getName()){
         result = PASS;
      }*/
      
   }
   //Test: Update customer of name Manish
   //Test: Check if result is success XML.
   private void testUpdateCustomer(){
      Form form = new Form();
      form.param("iname", "Manish");
      form.param("jaddress", "Mt.albert");
      form.param("phone_number","02212126545");

      String callResult = client
         .target(REST_SERVICE_URL)
         .request(MediaType.APPLICATION_XML)
         .post(Entity.entity(form,
            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
            String.class);
      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testUpdateCustomer, Result: " + result );
   }
   //Test: Add customer of name Ela
   //Test: Check if result is success XML.
   private void testAddCustomer(){
      Form form = new Form();
      form.param("iname", "Ela");
      form.param("jaddress", "Royal Oak");
      form.param("phone_number","0221456789");

      String callResult = client
         .target(REST_SERVICE_URL)
         .request(MediaType.APPLICATION_XML)
         .put(Entity.entity(form,
            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
            String.class);
   
      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testAddcustomer, Result: " + result );
   }
   //Test: Delete customer of name Ela
   //Test: Check if result is success XML.
   private void testDeleteCustomer(){
      String callResult = client
         .target(REST_SERVICE_URL)
         .path("/{name}")
         .resolveTemplate("name","Manish")
         .request(MediaType.APPLICATION_XML)
         .delete(String.class);

      String result = PASS;
      if(!SUCCESS_RESULT.equals(callResult)){
         result = FAIL;
      }

      System.out.println("Test case name: testDeleteUser, Result: " + result );
   }
}