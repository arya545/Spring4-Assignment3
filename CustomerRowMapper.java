package com.acad.spring4Assignment3.customer.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		customer.setCustId(rs.getInt("CUST_ID"));
		customer.setName(rs.getString("NAME"));
		customer.setAge(rs.getInt("AGE"));
		return customer;
	}
	
	

}
