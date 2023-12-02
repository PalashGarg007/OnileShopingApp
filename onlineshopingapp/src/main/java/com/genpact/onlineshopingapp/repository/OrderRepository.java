package com.genpact.onlineshopingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.genpact.onlineshopingapp.entity.Orders;

public class OrderRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    public List<Orders> getOrderByCustomerId(String customerId) {
        return jdbcTemplate.query("select * from order where cid='"+customerId+"'",new RowMapper<Orders>(){
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders order=new Orders();
		        order.setId(rs.getInt(1));
				order.setCid(rs.getInt(2));
				order.setSid(rs.getInt(3));
				order.setPid(rs.getInt(4));
				order.setAmount(rs.getFloat(5));
				order.setCount(rs.getInt(6));
				order.setOrderDate(rs.getDate(7).toLocalDate());
				order.setShipingDate(rs.getDate(8).toLocalDate());
				order.setPayId(rs.getInt(9));

				return order;
			}  		    
		    });
    }
	
}
