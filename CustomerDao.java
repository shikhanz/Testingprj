package com.customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
  // @SuppressWarnings("unchecked")
@SuppressWarnings("unchecked")
public List<Customer> getAllCustomers(){
      List<Customer> CustomerList = null;
      try {
         File file = new File("Customerapp2.dat");
         if (!file.exists()) {
            Customer customer = new Customer("Manish","123 Queen Street",021021456);
            CustomerList = new ArrayList<Customer>();
            CustomerList.add(customer);
            Customer Customer1 = new Customer("EmilyWalks","123 Custom Street",044356345);
            CustomerList.add(Customer1);
            saveCustomerList(CustomerList);		
         }
         else{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            CustomerList = (List<Customer>)(ois.readObject());
            ois.close();
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }		
      return CustomerList;
   }
public Customer getCustomer(String name){
    List<Customer> Customers = getAllCustomers();
     
    for(Customer customer: Customers){
    	//System.out.println(customer.getName()+"  ");
       if(customer.getName().equals(name))
          return customer;
       }
    
    return null;
 }

 public int addCustomer(Customer pCustomer){
    List<Customer> CustomerList = getAllCustomers();
    boolean CustomerExists = false;
    for(Customer customer: CustomerList){
       if(customer.getName() == pCustomer.getName()){
          CustomerExists = true;
          break;
       }
    }		
    if(!CustomerExists){
       CustomerList.add(pCustomer);
       saveCustomerList(CustomerList);
       return 1;
    }
    return 0;
 }

 public int updateCustomer(Customer pCustomer){
    List<Customer> CustomerList = getAllCustomers();

    for(Customer customer: CustomerList){
       if(customer.getName().equals(pCustomer.getName()))
       {
          int index = CustomerList.indexOf(customer);			
          CustomerList.set(index, pCustomer);
          saveCustomerList(CustomerList);
          return 1;
       }
    }
       return 0;
    }
    	
  
 

 public int deleteCustomer(String name){
    List<Customer> CustomerList = getAllCustomers();

    for(Customer customer: CustomerList){
       if(customer.getName().equals(name)){
          int index = CustomerList.indexOf(customer);			
          CustomerList.remove(index);
          saveCustomerList(CustomerList);
          return 1;   
       }
    }		
    return 0;
 }

 private void saveCustomerList(List<Customer> CustomerList){
    try {
       File file = new File("Customerapp2.dat");
       FileOutputStream fos;

       fos = new FileOutputStream(file);

       ObjectOutputStream oos = new ObjectOutputStream(fos);		
       oos.writeObject(CustomerList);
       oos.close();
    } catch (FileNotFoundException e) {
       e.printStackTrace();
    } catch (IOException e) {
       e.printStackTrace();
    }
 }
}