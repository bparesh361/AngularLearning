package com.test.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TABLE")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;
	@Column(name="ADDRESSES")
    @Embedded
    @AttributeOverrides({
    @AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")),
    @AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
    @AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),
    @AttributeOverride(name="pincode", column=@Column(name="HOME_PIN_CODE"))})
    private Addresses homeAddress;
    
    @Embedded
    private Addresses permanentAddress;
    

	@Column(name = "USER_PHONE")
	private String phone;

	@Column(name = "DOB")
	private Date dob;

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public Addresses getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Addresses homeAddress2) {
		this.homeAddress = homeAddress2;
	}

	public Addresses getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Addresses permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getUserId() {
		return userId;
	}
	
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName
				+ ", homeAddress=" + homeAddress + ", permanentAddress="
				+ permanentAddress + ", phone=" + phone + ", dob=" + dob + "]";
	}

}