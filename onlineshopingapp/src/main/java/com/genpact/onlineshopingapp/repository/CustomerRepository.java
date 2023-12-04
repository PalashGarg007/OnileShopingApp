package com.genpact.onlineshopingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.genpact.onlineshopingapp.entity.Customer;

public class CustomerRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Customer> getAll() {
		return jdbcTemplate.query("select * from customer",new RowMapper<Customer>(){
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer=new Customer();  
		        customer.setId(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setDob(rs.getDate(3).toLocalDate());
				customer.setContact(rs.getString(4));
				customer.setEmail(rs.getString(5));
				customer.setAddress(rs.getString(6));
				customer.setUserName(rs.getString(7));
				customer.setPassword(rs.getString(8));

				return customer;
			}  		    
		    });
	}

    public Customer userLogin(String username, String password) {
        List<Customer> customers = jdbcTemplate.query("select * from customer where username='"+
			username+"' _password="+password+"'", new RowMapper<Customer>(){
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer=new Customer();  
		        customer.setId(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setDob(rs.getDate(3).toLocalDate());
				customer.setContact(rs.getString(4));
				customer.setEmail(rs.getString(5));
				customer.setAddress(rs.getString(6));
				customer.setUserName(rs.getString(7));
				customer.setPassword(rs.getString(8));

				return customer;
			}  		    
		    });
		Customer customer = null;
		if(customers.size()>0){
			customer = customers.get(0);
		}
		return customer;
    }
	
}
