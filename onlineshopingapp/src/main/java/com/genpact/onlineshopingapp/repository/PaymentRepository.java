package com.genpact.onlineshopingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PaymentRepository {
    
    private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    public int addPaymentMethod(String paymentMethod, Double discount) {
		List<String> existingPaymentMethod = jdbcTemplate.query("select * from payment where method='"+paymentMethod+"'",new RowMapper<String>(){
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(2);
			}});
		
		int result;
		if(existingPaymentMethod.contains(paymentMethod))
			result = 0;
		else
			result = jdbcTemplate.update("insert into payment values('"+existingPaymentMethod.size()+1+"','"+paymentMethod+"', "+discount+")");
        return result;
    }

    public int modefyDiscount(String paymentMethod, Double discount) {
		int result = jdbcTemplate.update("update payment set discount="+discount+" where method='"+paymentMethod+"')");
        return result;
    }
    
}
