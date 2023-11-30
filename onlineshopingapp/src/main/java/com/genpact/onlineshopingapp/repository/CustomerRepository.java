package com.genpact.onlineshopingapp.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

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
		return jdbcTemplate.query("select * from customer",new RowMapper(){
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer=new Customer();  
		        customer.setId(sr.getInt(1));

			}  		    
		    });
	}
	
}
