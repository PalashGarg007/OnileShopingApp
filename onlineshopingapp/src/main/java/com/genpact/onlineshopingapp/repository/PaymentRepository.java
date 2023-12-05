package com.genpact.onlineshopingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.genpact.onlineshopingapp.entity.Payment;

public class PaymentRepository {
    
    private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    public int addPaymentMethod(String paymentMethod, Double discount) {
		int result = 0;
		try{
			result = jdbcTemplate.update("insert into payment(method, discount) values('"
				+paymentMethod+"', "+discount+")");
		} catch(Exception e){
			result = 0;
		}
        return result;
    }

    public int modefyDiscount(String paymentMethod, Double discount) {
		int result;
		try{
			result = jdbcTemplate.update("update payment set discount="+
				discount+" where method='"+paymentMethod+"'");
		} catch(Exception e){
			result = 0;
		}
        return result;
    }

    public List<Payment> getAllPayment() {
        return jdbcTemplate.query("select * from payment",new RowMapper<Payment>(){
			public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Payment payment = new Payment();
				payment.setId(rs.getInt(1));
				payment.setMethod(rs.getString(2));
				payment.setDiscount(rs.getDouble(3));
				
				return payment;
			}
		});
    }
    
}
