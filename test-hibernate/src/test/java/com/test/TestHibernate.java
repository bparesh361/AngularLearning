package com.test;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.entity.Address;
import com.test.entity.Foo;
import com.test.entity.MstModule;
import com.test.entity.MstRole;
import com.test.entity.MstUser;
import com.test.entity.Student;
import com.test.service.FooService;

//futurebranch
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestHibernateConfig.class)
public class TestHibernate {

	@Autowired
	private FooService fooService;

	@Test
	public void failIfRequiredObjectsAreNull() {
		Assert.assertNotNull(fooService);
	}

	@Test
	public void testFooCreateAndRetrieveByName() {
		Foo foo = new Foo();
		foo.setName("paresh");
		fooService.createFoo(foo);
		List<Foo> list = fooService.searchFooByName(foo.getName());
		Assert.assertNotNull(list);
		// Assert.assertSame("foo list size", 1, list.size());
	}

	@Test
	public void testFooCreateAndRetrieveByNameAndSalary() {
		Foo foo = new Foo();
		foo.setName("chirag");
		foo.setSalary(new Double(50000));
		fooService.createFoo(foo);
		List<Foo> list = fooService.searchFooByNameAndSalary(foo.getName(),
				foo.getSalary());
		Assert.assertEquals("foo salary : ", 50000d, list.get(0).getSalary()
				.doubleValue());
	}

	@Test
	public void testFooPagination() {
		for (int x = 0; x < 100; x++) {
			Foo foo = new Foo();
			foo.setName("chirag:" + x);
			foo.setSalary(new Double(50000 + x));
			fooService.createFoo(foo);
		}
		List<Foo> list = fooService.searchAllFooByPage(1, 10);
		Assert.assertSame("foo list size", 10, list.size());
	}

	@Test
	public void testCreateStudentOnetoOne() {
		Student s = new Student();
		s.setfName("Ravi");
		s.setlName("Shah");
		Address address = new Address();
		address.setCityName("Ahmedabad");
		s.setAddress(address);
		address.setStudent(s);
		fooService.createStudent(s);
	}

	@Test
	public void testCreateAddressOnetoOne() {
		Student s = new Student();
		s.setfName("Jignesh");
		s.setlName("Patel");
		Address address = new Address();
		address.setCityName("Baroda");
		s.setAddress(address);
		address.setStudent(s);
		fooService.createAddress(address);
	}

	@Test
	public void testcreateUserRoleOnetoMany() {

		MstRole role = new MstRole();

		role.setRoleDesc("AdminRole");
		role.setRoleName("Admin");

		fooService.createRole(role);

		MstUser mstUser1 = new MstUser();
		mstUser1.setUserName("admin5");
		mstUser1.setPassword("123456");
		mstUser1.setRole(role);
		mstUser1.setCreatedOn(new Date());
		fooService.createUser(mstUser1);

		MstUser mstUser2 = new MstUser();
		mstUser2.setUserName("admin6");
		mstUser2.setPassword("123456");
		mstUser2.setRole(role);
		mstUser2.setCreatedOn(new Date());
		fooService.createUser(mstUser2);

		MstRole roleFromDB = fooService.getRoleById(1);
		System.out.println(roleFromDB);
		Assert.assertNotNull(roleFromDB);
		System.out.println(roleFromDB.getUserList().size());

	}

	@Test
	public void testRoleModule() {

		MstRole role = new MstRole();
		role.setRoleName("store");
		role.setRoleDesc("store user");

		MstModule module1 = new MstModule();
		module1.setModuleName("promotion initiation");

		MstModule module2 = new MstModule();
		module2.setModuleName("promotion approval");

		role.getModules().add(module1);
		role.getModules().add(module2);

		fooService.createRole(role);

	}

	@Test
	public void testGetUserByidWithRoleAndModuleList() {
		MstRole role = new MstRole();

		role.setRoleDesc("AdminRole1");
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

	/**
	 * Search the user by date using criteria query.
	 */
	@Test
	public void testSearchUserByDate() {
		String startDate = "25-06-2014";
		String endDate = "25-06-2014";

		try {
			List<MstUser> mstUserList = fooService.searchUserByDate(startDate,
					endDate);
			System.out.println("MstUSer size : " + mstUserList.size());
			// System.out.println(mstUserList.get(0).getRole().getRoleName()+
			// "---");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
