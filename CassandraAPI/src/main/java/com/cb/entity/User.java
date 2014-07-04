package com.cb.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import me.prettyprint.hom.annotations.AnonymousPropertyHandling;
import me.prettyprint.hom.annotations.Column;

@Entity
@Table(name = "users")
@AnonymousPropertyHandling(adder="addAnonymousProp", getter="getAnonymousProps")
public class User {

	@Id
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "fname")
	private String fName;

	@Column(name = "lname")
	private String lName;

	public User() {

	}

	public User(Integer userId, String lName, String fName) {
		this.userId = userId;
		this.lName = lName;
		this.fName = fName;
	}

	private Map<String, byte[]> anonymousProps = new HashMap<String, byte[]>();

	public void addAnonymousProp(String name, byte[] value) {
		anonymousProps.put(name, value);
	}

	public Collection<Entry<String, byte[]>> getAnonymousProps() {
		return anonymousProps.entrySet();
	}

	public String getAnonymousProp(String name) {
		return new String(anonymousProps.get(name));
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
