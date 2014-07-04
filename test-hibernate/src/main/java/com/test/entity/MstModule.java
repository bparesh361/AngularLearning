package com.test.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="mst_module")
public class MstModule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="module_id")
	private int moduleId;
	
	@Column(name="module_name")
	private String moduleName;
	
	@ManyToMany
	@JoinTable(name="role_module",joinColumns=@JoinColumn(name="module_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<MstRole> roles = new ArrayList<MstRole>();

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<MstRole> getRoles() {
		return roles;
	}

	public void setRoles(List<MstRole> roles) {
		this.roles = roles;
	}
	
	
	
	
	
}
