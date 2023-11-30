package com.genpact.onlineshopingapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Bike> getAll() {
		return jdbcTemplate.query("select * from bike",new RowMapper<Bike>(){
			public Bike mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bike bike=new Bike();  
		        bike.setId(rs.getInt(1));  
		        bike.setModel(rs.getString(2));    
		        bike.setColor(rs.getString(3));
		        return bike;  
			}  		    
		    });
	}
	
}
