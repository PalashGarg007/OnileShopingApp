package com.genpact.onlineshopingapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class CartRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}
