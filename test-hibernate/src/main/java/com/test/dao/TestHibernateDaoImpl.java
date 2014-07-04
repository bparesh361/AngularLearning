package com.test.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.entity.Address;
import com.test.entity.Foo;
import com.test.entity.MstRole;
import com.test.entity.MstUser;
import com.test.entity.Student;

@Repository
public class TestHibernateDaoImpl implements TestDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void createFoo(Foo foo) {
		getSession().save(foo);
	}

	public List<Foo> findFooByName(String name) {
		Criteria cr = getSession().createCriteria(Foo.class);
		cr.add(Restrictions.eq("name", name));
		return cr.list();
	}

	public List<Foo> findAllFooByPage(int pageno, int size) {
		Criteria cr = getSession().createCriteria(Foo.class);
		cr.setFirstResult(pageno * size);
		cr.setMaxResults(size);
		return cr.list();
	}

	public List<Foo> findFooByNameAndSalary(String name, Double salary) {
		Criteria cr = getSession().createCriteria(Foo.class);
		Criterion cname = Restrictions.eq("name", name);
		Criterion csalary = Restrictions.ge("salary", salary);
		LogicalExpression expr = Restrictions.or(cname, csalary);
		cr.add(expr);
		return cr.list();
	}


	

	
	public List<MstUser> findUserbyName(String userName) {
		Criteria cr = getSession().createCriteria(MstUser.class);
		cr.add(Restrictions.eq("userName", userName));
		return cr.list();
	}

	public void createStudentAddress(Address address) {
		getSession().save(address);
		
	}


	public void createRole(MstRole role) {
		getSession().save(role);
		
	}

	public void createStudent(Student s) {
		getSession().save(s);
		
	}

	public void createUser(MstUser user) {
		getSession().save(user);
		
	}

	public MstRole getRoleById(int id) {
		return (MstRole)getSession().get(MstRole.class, id);
	}

	public MstUser getUserById(int id) {
		return (MstUser)getSession().get(MstUser.class, id);
	}

	public List<MstUser> searchUserByDate(Date startDate, Date endDate) {
		Criteria cr = getSession().createCriteria(MstUser.class);		
		cr.add(Restrictions.between("createdOn", startDate, endDate));
		
		return cr.list();
	}

	
	
	
	

	
	
}
