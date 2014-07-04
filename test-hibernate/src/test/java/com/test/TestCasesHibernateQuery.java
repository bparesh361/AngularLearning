package com.test;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.TestCasesHibernateQueryDao;
import com.test.entity.Addresses;
import com.test.entity.Foo;
import com.test.entity.MstModule;
import com.test.entity.MstRole;
import com.test.entity.MstUser;
import com.test.entity.UserDetails;
import com.test.service.FooService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestHibernateConfig.class)
public class TestCasesHibernateQuery {

	@Autowired
	private TestCasesHibernateQueryDao queryDao;

	@Autowired
	private FooService fooService;

	// Inserting data into database.
	@Test
	public void testCreateFoo() {
		Foo foo = new Foo();
		foo.setName("neha2");
		foo.setSalary(new Double(50000));
		queryDao.createFoo(foo);

	}

	// get the foo.
	@Test
	public void testgetFoo() {
		Foo foo1 = queryDao.getFoo(2);
		System.out.println(foo1.toString());
		Assert.assertEquals("foo salary : ", 50000d, foo1.getSalary()
				.doubleValue());
	}

	// Update the foo
	@Test
	public void testUpdateFoo() {
		Foo foo1 = queryDao.getFoo(2);

		Assert.assertEquals("foo salary : ", 50000d, foo1.getSalary()
				.doubleValue());

		foo1.setName("Krishna");
		queryDao.updateFoo(foo1);

		foo1 = queryDao.getFoo(2);
		System.out.println(foo1.toString());
	}

	// Delete the foo
	@Test
	public void testDeleteFoo() {
		Foo foo1 = queryDao.getFoo(2);
		System.out.println(foo1.toString());
		queryDao.deleteFoo(foo1);

	}

	@Test
	public void testGetUserByidWithRoleAndModuleList() {
		MstRole role = new MstRole();

		role.setRoleDesc("AdminRole");
		role.setRoleName("Admin");

		MstModule module1 = new MstModule();
		module1.setModuleName("promotion initiation");

		MstModule module2 = new MstModule();
		module2.setModuleName("promotion approval");

		role.getModules().add(module1);
		role.getModules().add(module2);
		fooService.createRole(role);

		MstUser mstUser1 = new MstUser();
		mstUser1.setUserName("admin7");
		mstUser1.setPassword("123456");
		mstUser1.setRole(role);
		mstUser1.setCreatedOn(new Date());
		fooService.createUser(mstUser1);

		MstUser mstUser = fooService.getUSerById(1);

		Assert.assertEquals("Role Name : ", "Admin", mstUser.getRole()
				.getRoleName());
		Assert.assertEquals("First Module Name : ", "promotion initiation",
				mstUser.getRole().getModules().get(0).getModuleName());
		Assert.assertEquals("Second Module Name : ", "promotion approval",
				mstUser.getRole().getModules().get(1).getModuleName());

	}

	@Test
	public void createEmbendedUserDetails() {
		UserDetails user = new UserDetails(); // create first user

		user.setUserName("Dinesh Rajput");

		Addresses homeAddress = new Addresses(); // create an value type object
													// of address class for home
													// address
		homeAddress.setStreet("Block House No");
		homeAddress.setCity("MangolaPuri");
		homeAddress.setState("New Delhi");
		homeAddress.setPincode("110089");
		user.setHomeAddress(homeAddress); // set the home address

		Addresses address1 = new Addresses();// create another value type object
												// for the permanent address
		address1.setStreet("Film City");
		address1.setCity("Noida");
		address1.setState("UP");
		address1.setPincode("201301");
		user.setPermanentAddress(address1);// set the permanent address

		user.setDob(new Date());
		user.setPhone("+91-9953423462");

		queryDao.createUSerDetails(user);

	}
	//Delete Role and Module
	@Test
	public void testDeleteRoleModule(){
		MstRole role = fooService.getRoleById(5);
		
		queryDao.deleteUser(role.getUserList());		
		queryDao.deleteRoleModule(role);
	}

}
