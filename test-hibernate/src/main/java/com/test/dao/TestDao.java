package com.test.dao;

import java.util.Date;
import java.util.List;

import com.test.entity.Address;
import com.test.entity.Foo;
import com.test.entity.MstRole;
import com.test.entity.MstUser;
import com.test.entity.Student;

public interface TestDao {


	void createFoo(Foo foo);

	List<Foo> findFooByName(String name);

	List<Foo> findFooByNameAndSalary(String name, Double salary);

	List<Foo> findAllFooByPage(int pageno, int size);

	List<MstUser> findUserbyName(String userName);

	void createStudentAddress(Address address);

	void createRole(MstRole role);

	void createStudent(Student s);	
	
	void createUser(MstUser user);
	
	 MstRole getRoleById(int id);

	MstUser getUserById(int id);

	List<MstUser> searchUserByDate(Date startDate, Date endDate);

	

}
