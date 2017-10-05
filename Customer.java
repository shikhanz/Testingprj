package com.customer;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unused")
@XmlRootElement(name = "customer")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String iname;
	private String jaddress;
	private int phone_number;
	
	public Customer(){}
	
	public Customer(String name, String address, int phone_number){
		
		this.iname= name;
		this.jaddress = address;
		this.phone_number = phone_number;
	}

	public String getName() {
		return iname;
	}

	public void setName(String name) {
		this.iname = name;
	}

	public String getAddress() {
		return jaddress;
	}

	public void setAddress(String address) {
		this.jaddress = address;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	
	

}
