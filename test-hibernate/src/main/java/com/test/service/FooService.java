package com.test.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.TestDao;
import com.test.entity.Address;
import com.test.entity.Foo;
import com.test.entity.MstRole;
import com.test.entity.MstUser;
import com.test.entity.Student;

@Service
@Transactional(readOnly = true)
public class FooService {

	@Autowired
	private TestDao testDao;

	@Transactional
	public void createFoo(Foo foo) {
		testDao.createFoo(foo);
	}

	public List<Foo> searchFooByName(String name) {
		return testDao.findFooByName(name);
	}

	public List<Foo> searchFooByNameAndSalary(String name, Double salary) {
		return testDao.findFooByNameAndSalary(name, salary);
	}

	public List<Foo> searchAllFooByPage(int pageno, int size) {
		return testDao.findAllFooByPage(pageno, size);
	}

	public List<MstUser> searchUserByName(String userName) {
		return testDao.findUserbyName(userName);
	}

	@Transactional
	public void createAddress(Address address) {
		testDao.createStudentAddress(address);

	}

	@Transactional
	public void createRole(MstRole role) {
		testDao.createRole(role);

	}

	@Transactional
	public void createStudent(Student s) {
		testDao.createStudent(s);
	}

	@Transactional
	public void createUser(MstUser user) {
		testDao.createUser(user);
	}

	public MstRole getRoleById(int id) {
		return testDao.getRoleById(id);
	}

	public MstUser getUSerById(int id) {
		MstUser mstUser = testDao.getUserById(id);
		MstRole role = testDao.getRoleById(mstUser.getRole().getRoleId());
		role.getModules().size();
		return mstUser;
	}

	public List<MstUser> searchUserByDate(String startDate, String endDate)
			throws Exception {
//		startDate = startDate + " 00:00:00";
//		endDate = endDate + " 23:59:59";
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date sDate = formatter.parse(startDate);
		Date eDate = formatter.parse(endDate);
		return testDao.searchUserByDate(sDate, eDate);
	}

}
