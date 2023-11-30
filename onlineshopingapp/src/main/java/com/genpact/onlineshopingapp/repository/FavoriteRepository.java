package com.genpact.onlineshopingapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class FavoriteRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
