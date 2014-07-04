package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.CustomerDao;
import com.company.util.CommonUtil;
import com.company.vo.CustomerVO;

@Service
@Transactional
public class CommonService {
	
	@Autowired
	private CustomerDao customerDao;

	public void createCustomer(CustomerVO customerVO) throws Exception {
		customerDao.save(CommonUtil.getCustomerFromVO(customerVO));
		
	}

}
