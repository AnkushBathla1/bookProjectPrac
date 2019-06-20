package com.cg.bookstore.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ManyToAny;
@Entity
public class OrderInformation {
	

	int orderId;
	String CustName,custAddress,city,country;
	long custPhone,zipCode;
	
	@ManyToAny(metaColumn = @Column)
	Customer customer;
	public OrderInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderInformation(String custName, String custAddress, String city, String country, long custPhone,
			long zipCode) {
		super();
		CustName = custName;
		this.custAddress = custAddress;
		this.city = city;
		this.country = country;
		this.custPhone = custPhone;
		this.zipCode = zipCode;
	}

	public String getCustName() {
		return CustName;
	}

	public void setCustName(String custName) {
		CustName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(long custPhone) {
		this.custPhone = custPhone;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "OrderInformation [CustName=" + CustName + ", custAddress=" + custAddress + ", city=" + city
				+ ", country=" + country + ", custPhone=" + custPhone + ", zipCode=" + zipCode + "]";
	}
	
	
}