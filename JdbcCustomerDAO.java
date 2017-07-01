package com.acad.spring4Assignment3.customer.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.acad.spring4Assignment3.customer.dao.CustomerDAO;
import com.acad.spring4Assignment3.customer.model.Customer;
import com.acad.spring4Assignment3.customer.model.CustomerRowMapper;

public class JdbcCustomerDAO extends JdbcDaoSupport implements CustomerDAO {
	
	
	//insert example
	public void insert(Customer customer)
	{
		
		String sql="INSERT into CUSTOMER "+ "(CUST_ID,NAME,AGE) VALUES (?,?,?)";
		getJdbcTemplate().update(sql, new Object[] {customer.getCustId(),customer.getName(),customer.getAge()});
	}
	
	//insert with named parameter
	public void insertNamedParameter(Customer customer)
	{
		//not supported
	}
	
	//insert batch example
	public void insertBatch(final List<Customer> customers)
	{
		String sql="INSERT INTO CUSTOMER " + "(CUST_ID, NAME ,AGE) VALUES (?,?,?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Customer customer=customers.get(arg1);
				arg0.setLong(1, customer.getCustId());
				arg0.setString(2, customer.getName());
				arg0.setInt(3, customer.getAge());
				
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return customers.size();
			}
		});

}

	@Override
	public void insertBatchNamedParameter(List<Customer> customer) {
		// TODO Auto-generated method stub
		//not supported
	}

	@Override
	public void insertBatchNamedParameter2(List<Customer> customer) {
		// TODO Auto-generated method stub
		//not supported
	}

	//insert batch example with SQL
	@Override
	public void insertBatchSQL(String sql) {
		// TODO Auto-generated method stub
		getJdbcTemplate().batchUpdate(new String[] { sql});
		
	}

	
	//quering single row with RowMapper
	@Override
	public Customer findByCustomerId(int custId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM CUSTOMER where CUST_ID = ?";
		return getJdbcTemplate().queryForObject(sql, new Object[] {custId}, new CustomerRowMapper());
	}

	//Quering single row with BeanPropertyRowMapper
	@Override
	public Customer findByCustomerId2(int custId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM CUSTOMER WHERE CUST_ID= ? ";
		return (Customer) getJdbcTemplate().queryForObject(sql, new Object[] {custId}, new BeanPropertyRowMapper(Customer.class));
	}

	//Quering multiple rows
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		/*String sql="SELECT * FROM CUSTOMER";
		List<Customer> customers=new ArrayList<Customer>();
		//List<Map> rows=getJdbcTemplate().queryForList(sql);
		for (Map row:getJdbcTemplate().queryForList(sql))
		{
			Customer customer=new Customer();
			customer.setCustId((Integer) row.get("CUST_ID"));
			customer.setName((String) row.get("NAME"));
			customer.setAge((Integer) row.get("AGE"));
			customers.add(customer);
		}
		
		return customers;*/
		
		String sql="SELECT * from CUSTOMER";
		List<Customer> customers=new ArrayList<Customer>();
		customers=getJdbcTemplate().query(sql, new CustomerRowMapper());
		return customers;
	}

	//Query multiple rows with BeanPropertyRowMapper
	@Override
	public List<Customer> findAll2() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM CUSTOMER";
		List<Customer> customers=new ArrayList<Customer>();
		customers=getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Customer.class));
		return customers;
		}

	@Override
	public String findCustomerNameById(int custId) {
		// TODO Auto-generated method stub
		String sql="SELECT name from customer where CUST_ID= ?";
		String name=getJdbcTemplate().queryForObject(sql, new Object[]{custId}, String.class);
		return name;
	}

	@Override
	public int findTotalCustomer() {
		// TODO Auto-generated method stub
		String sql="select count(*) from customer";
		return getJdbcTemplate().queryForObject(sql,  Integer.class);
	}
	
	
}
