package com.fks.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.fks.util.CassandraUtil;
import com.fks.vo.UserVO;

@Repository
public class UserDao {

	private static Logger logger = Logger.getLogger(UserDao.class);
	
	@Autowired
	private CassandraUtil cassandraUtil;
	
	public UserVO findUser(Long id){
		logger.info(" --- Fetching User By Id --- " + id);
		Session session = cassandraUtil.getSession();
		ResultSet rs = session.execute("select * from users where user_id="+id+";");
		for(Row row: rs){
			String firstName = row.getString("fname");
			String lastName = row.getString("lname");
//			String mobile = row.getString("mobile");
//			String email = row.getString("email");
			UserVO vo = new UserVO(id, firstName, lastName);
			return vo;
		}
		return null;		
	}	
}
