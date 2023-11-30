package com.genpact.onlineshopingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.genpact.onlineshopingapp.entity.Product;

public class ProductRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    public List<Product> getProductByShopkeeperId(String shopkeeperId) {
        return jdbcTemplate.query("select * from product where sid='"+shopkeeperId+"'",new RowMapper<Product>(){
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();  
		        product.setId(rs.getInt(1));
				product.setId(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setCategory(rs.getString(4));
				product.setCost(rs.getFloat(5));
				product.setCost(rs.getInt(6));
				product.setRating(rs.getFloat(7));
				product.setTotalBuy(rs.getString(8));

				return product;
			}  		    
		    });
    }
	
	
}
