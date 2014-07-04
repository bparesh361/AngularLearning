package com.test.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.Foo;
import com.test.entity.MstRole;
import com.test.entity.MstUser;
import com.test.entity.UserDetails;

@Repository
@Transactional
public class TestCasesHibernateQueryDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void createFoo(Foo foo) {
		getSession().save(foo);
	}

	public Foo getFoo(int id) {
		return (Foo) getSession().get(Foo.class, id);
	}

	public void updateFoo(Foo foo1) {
		getSession().update(foo1);
	}

	public void deleteFoo(Foo foo1) {
		getSession().delete(foo1);
	}

	public void createUSerDetails(UserDetails user) {
		getSession().save(user);
		
	}

	public void deleteRoleModule(MstRole role) {
		getSession().delete(role);
		
	}

	public void deleteUser(List<MstUser> list) {
		 for(MstUser mstUser : list){
			 getSession().delete(mstUser);
		 }
		
		
	}
}
