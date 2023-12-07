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
        return jdbcTemplate.query("select * from customer", new RowMapper<Shopkeeper>(){
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

    public Shopkeeper vendorLogin(String username, String password) {
        List<Shopkeeper> shopkeepers = jdbcTemplate.query("select * from shopkeeper where username='"+
			username+"' _password='"+password+"'", new RowMapper<Shopkeeper>(){
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
		Shopkeeper shopkeeper = null;
		if(shopkeepers.size()>0){
			shopkeeper = shopkeepers.get(0);
		}
		return shopkeeper;
    }

    public Shopkeeper createShopkeeper(String name, String contact, 
		String email, String userName, String password) {
        int result = jdbcTemplate.update("insert into shopkeeper (name,"+
			" contact, email, userName, _password) values('"+name+"', '"+
			contact+"', '"+email+"', '"+userName+"', '"+password+"')");
		
		Shopkeeper shopkeeper = null;
		if(result==0)
			return shopkeeper;
		List<Shopkeeper> shopkeepers = jdbcTemplate.query("select * from shopkeeper where username='"+
			userName+"' _password='"+password+"'", new RowMapper<Shopkeeper>(){
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
		
        return shopkeepers.get(0);
    }
	
	//vendors should be able to view his/her details
	public Shopkeeper viewDetails(Integer id ){
		List<Shopkeeper> shopkeepers = jdbcTemplate.query("select * from shopkeeper where id="
		+id+"", new RowMapper<Shopkeeper>(){
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
		
        return shopkeepers.get(0);
	}

	public int checkVendorPassword(String password){

		List<Shopkeeper> shopkeepers = jdbcTemplate.query("select * from shopkeeper where Id="+
			shopkeepers.getId()+" _password='"+password+"'", new RowMapper<Shopkeeper>(){
				public Shopkeeper mapRow(ResultSet rs, int rowNum) throws SQLException {
                	Shopkeeper shopkeeper=new Shopkeeper();
					shopkeeper.setId(rs.getInt(1));
					shopkeeper.setPassword(rs.getString(2));

					return shopkeeper;
            	}
		}

		if(shopkeepers.size()>0){
			return 1;
		}
		else{
			return 0;
		}
	}

	@Override
	public int updateVendorPassword(String password){
		int update = jdbcTemplate.query("Update shopkeeper set _password='"+password+"' where id="+shopkeeper.getId()+"")
			if(update==0){
				return 0;
			}
			else{
				return 1;
			}
	
	}
}
