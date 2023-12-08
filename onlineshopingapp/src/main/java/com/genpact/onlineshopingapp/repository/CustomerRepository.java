package com.genpact.onlineshopingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.genpact.onlineshopingapp.entity.Customer;
import com.genpact.onlineshopingapp.exception.OSAException;

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
			username+"'and _password='"+password+"'", new RowMapper<Customer>(){
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

	public Customer createCustomer(String name, String dob, String contact, String email, String address,
			String username, String password) {
		int result = 0;
		try{
			result = jdbcTemplate.update("insert into customer (name, dob, contact, email, address, userName, _password)"
				+"values('"+name+"', '"+dob+"', '"+contact+"', '"+email+"', '"+address+"', '"+username+"', '"+password+"')");
		} catch(OSAException e){
			result = 0;
		}
		if(result>0){
			List<Customer> customers = jdbcTemplate.query("select * from customer where username='"+
				username+"'and _password='"+password+"'", new RowMapper<Customer>(){
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
		} else {
			return null;
		}
		
	}
	
	//customers should be able to view his/her details
	public Customer viewDetails(int id){
		List<Customer> customers = jdbcTemplate.query("select * from customer where id="
		+id, new RowMapper<Customer>(){
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

	public int checkUserPassword(String password){
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'checkUserPassword'");
// 		List<Customer> customers = jdbcTemplate.query("select * from customer where id='"+
// 				customer.getId()+"'and _password="+password+"'", new RowMapper<Customer>(){
// 				public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
// 					Customer customer=new Customer();
// 					customer.setId(rs.getInt(1));
// 					customer.setPassword(rs.getString(2));
// 					return customer;
// 				}

// 				if(customers.size()>0){
// 					return 1;
// 				}
// 				else{
// 					return 0;
// 				}
//     }
	}
}
