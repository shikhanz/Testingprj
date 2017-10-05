package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/CustomerService")
public class CustomerService {
	
   CustomerDao CustomerDao = new CustomerDao();
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<result>failure</result>";


   @GET
   @Path("/customers")
   @Produces(MediaType.APPLICATION_XML)
   public List<Customer> getCustomers(){
      return CustomerDao.getAllCustomers();
   }

   @GET
   @Path("/customers/{name1}")
   @Produces(MediaType.APPLICATION_XML)
   public Customer getCustomer(@PathParam("name1") String name){
      return CustomerDao.getCustomer(name);
   }

   @PUT
   @Path("/customers")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String createCustomer(
      @FormParam("iname") String name,
      @FormParam("jaddress") String address,
      @FormParam("phone_number") int phonenumber,
      @Context HttpServletResponse servletResponse) throws IOException{
      Customer customer = new Customer(name, address, phonenumber);
      int result = CustomerDao.addCustomer(customer);
   //   servletResponse.sendRedirect("./users/");
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   @POST
   @Path("/customers")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String updateCustomer(@FormParam("iname") String iname,
      @FormParam("jaddress") String jaddress,
      @FormParam("phone_number") int phone_number,
      @Context HttpServletResponse servletResponse) throws IOException{
      Customer user = new Customer(iname,jaddress, phone_number);
      int result = CustomerDao.updateCustomer(user);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   @DELETE
   @Path("/customers/{name}")
   @Produces(MediaType.APPLICATION_XML)
   public String deleteCustomer(@PathParam("name") String name){
      int result = CustomerDao.deleteCustomer(name);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   @OPTIONS
   @Path("/customers")
   @Produces(MediaType.APPLICATION_XML)
   public String getSupportedOperations(){
      return "<operations>GET, PUT, POST, DELETE</operations>";
   }
}