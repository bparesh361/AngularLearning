package com.company.util;


import com.company.mongo.entity.Customer;
import com.company.vo.CustomerVO;


public class CommonUtil {

	public static Customer getCustomerFromVO(CustomerVO vo) throws Exception {
		
		if (vo.getId() == null || vo.getId().isEmpty()) {
			return new Customer(vo.getFname(), vo.getLname());
		} else {
			return new Customer(vo.getId(), vo.getFname(),vo.getLname());
		}
	}
}
