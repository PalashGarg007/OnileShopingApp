package com.genpact.onlineshopingapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.genpact.onlineshopingapp.exception.OSAException;

public class ReviewRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public int addReview(Integer oid, Double rating, String review){
		String sql = "update review set rating=? , review='?' where id=?";
		int result = 0;
		try{
        	result = jdbcTemplate.update(sql, rating, review, oid);
		}catch(OSAException e){
            result = 0;
        }
        return result;
	}
	
}
