package com.genpact.onlineshopingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.genpact.onlineshopingapp.entity.Favorite;
import com.genpact.onlineshopingapp.exception.OSAException;

public class FavoriteRepository {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    public int removeFromFavorite(Integer customerId, Integer productId) {
        int result = 0;
		try{
			String sql = "delete from favorite where cid=? and pid=?";
			result = jdbcTemplate.update(sql, customerId, productId);
		} catch(OSAException e){
			System.out.println(e);
		}
		return result;
    }

    public int addToFavorite(Integer customerId, Integer productId) {
        int result = 0;
		List<Favorite> favoriteList = jdbcTemplate.query("select * from favorite where cid="+customerId+
			" and pid="+productId, new RowMapper<Favorite>(){
			public Favorite mapRow(ResultSet rs, int rowNum) throws SQLException {
				Favorite favorite=new Favorite();  
		        favorite.setCid(rs.getInt(1));
				favorite.setPid(rs.getInt(2));

				return favorite;
			}
		});
		if(!favoriteList.isEmpty())
			return result;
		try{
			String sql = "insert into favorite values("+customerId+", "+productId+")";
			result = jdbcTemplate.update(sql);
		} catch(OSAException e){
			System.out.println(e);
		}
		return result;
    }
	
}
