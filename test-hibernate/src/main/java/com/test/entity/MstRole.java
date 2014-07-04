package com.test.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "mst_role")
public class MstRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;
	@Column(name="role_name")
	private String roleName;
	@Column(name="role_desc")
	private String roleDesc;
	@OneToMany(mappedBy="role",fetch=FetchType.EAGER)
	private List<MstUser> userList;
	
	@ManyToMany
	@Cascade(value=CascadeType.SAVE_UPDATE)
	@JoinTable(name="role_module",joinColumns=@JoinColumn(name="role_id"),inverseJoinColumns=@JoinColumn(name="module_id"))
	private List<MstModule> modules = new ArrayList<MstModule>();

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public List<MstUser> getUserList() {
		return userList;
	}

	public void setUserList(List<MstUser> userList) {
		this.userList = userList;
	}

	public List<MstModule> getModules() {
		return modules;
	}

	public void setModules(List<MstModule> modules) {
		this.modules = modules;
	}
	
}
