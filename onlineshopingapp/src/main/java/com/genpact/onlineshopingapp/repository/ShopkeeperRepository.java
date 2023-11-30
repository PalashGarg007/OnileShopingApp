package com.genpact.onlineshopingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.genpact.onlineshopingapp.entity.Shopkeeper;

public class ShopkeeperRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    public List<Shopkeeper> getAll() {
        return jdbcTemplate.query("select * from customer",new RowMapper<Shopkeeper>(){
			public Shopkeeper mapRow(ResultSet rs, int rowNum) throws SQLException {
				Shopkeeper shopkeeper=new Shopkeeper();  
		        shopkeeper.setId(rs.getInt(1));
				shopkeeper.setName(rs.getString(2));
				shopkeeper.setContact(rs.getString(3));
				shopkeeper.setEmail(rs.getString(4));
				shopkeeper.setUserName(rs.getString(5));
				shopkeeper.setPassword(rs.getString(6));

				return shopkeeper;
			}  		    
		    });
    }
	
	
}
