package com.genpact.onlineshopingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.genpact.onlineshopingapp.entity.Cart;

public class CartRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    public List<Cart> getAllItemsByCustomerId(Integer cid) {
        return jdbcTemplate.query("select * from cart where cid="+cid, new RowMapper<Cart>(){
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cart cart=new Cart();  
		        cart.setCid(rs.getInt(1));
				cart.setPid(rs.getInt(2));
				cart.setQuantity(rs.getInt(3));

				return cart;
			}  		    
		    });
    }

    public int remove(Cart cart) {
		int result;
		try{
			result = jdbcTemplate.update("alter table cart delete where cid="+
				cart.getCid()+", pid="+cart.getPid()+", quantity="+cart.getQuantity());
		} catch(Exception e){
			result = 0;
		}
		return result;
    }
	
	
}
