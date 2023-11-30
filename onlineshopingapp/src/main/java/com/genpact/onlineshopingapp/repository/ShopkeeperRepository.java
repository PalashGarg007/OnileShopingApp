package com.genpact.onlineshopingapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class ShopkeeperRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}
