package com.genpact.onlineshopingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.genpact.onlineshopingapp.entity.Cart;
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
				product.setSid(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setCategory(rs.getString(4));
				product.setCost(rs.getDouble(5));
				product.setWarehouse(rs.getInt(6));
				product.setRating(rs.getDouble(7));
				product.setPurchased(rs.getInt(8));

				return product;
			}  		    
		    });
    }

	public int addProduct(Integer sid, String name, String category, Double cost, Integer warehouse){
		int result=0;
		try{
			result = jdbcTemplate.update("insert into product(sid,name,category,cost,warehouse) values("+
				sid+",'"+name+"','"+category+"',"+cost+","+warehouse+")");
		} catch(Exception e){
			result = 0;
		}
		return result;
	}

	public int removeProduct(Integer sid, String name, String category, Integer warehouse){
		int result=0;
		try{
			result = jdbcTemplate.update("update product set warehouse=warehouse-"+
				warehouse+" where name='"+name+"' and category='"+category+"' sid="+sid);
		} catch(Exception e){
			result = 0;
		}
		return result;
	}
	

    public int getOrderFromWherehouse(Integer pid, Integer quantity) {
        int result;
		try{
			result = jdbcTemplate.update("update product set wharehouse=warehouse-"+quantity+" where id="+pid);
		} catch(Exception e){
			result = 0;
		}
        return result;
    }

    public String getProductName(Integer pid) {
        List<String> productNamelist = jdbcTemplate.query("select name from product where id="+pid,new RowMapper<String>(){
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}  		    
		    });
		return productNamelist.get(0);
    }

	public Product getProductById(Integer pid){
		List<Product> productList = jdbcTemplate.query("select * from product where id="+pid, new RowMapper<Product>(){
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();  
		        product.setId(rs.getInt(1));
				product.setSid(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setCategory(rs.getString(4));
				product.setCost(rs.getDouble(5));
				product.setWarehouse(rs.getInt(6));
				product.setRating(rs.getDouble(7));
				product.setPurchased(rs.getInt(8));

				return product;
			}});
		
		if(productList.size()==0){
			return null;
		} else{
			return productList.get(0);
		}
				
	}

    public Product getProductByCart(Cart cart) {
        List<Product> productList = jdbcTemplate.query("select * from product where id="+cart.getPid(), new RowMapper<Product>(){
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();  
		        product.setId(rs.getInt(1));
				product.setSid(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setCategory(rs.getString(4));
				product.setCost(rs.getDouble(5));
				product.setWarehouse(rs.getInt(6));
				product.setRating(rs.getDouble(7));
				product.setPurchased(rs.getInt(8));

				return product;
			}  		    
		    });
		Product product = productList.get(0);
		
		if(product.getWarehouse()<cart.getQuantity()){
			List<Product> productList2 = jdbcTemplate.query("select * from product where name='"+product.getName()
				+"' and category='"+product.getCategory()+"' and warehouse>"+cart.getQuantity()+" order by cost asc", new RowMapper<Product>(){
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();  
		        product.setId(rs.getInt(1));
				product.setSid(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setCategory(rs.getString(4));
				product.setCost(rs.getDouble(5));
				product.setWarehouse(rs.getInt(6));
				product.setRating(rs.getDouble(7));
				product.setPurchased(rs.getInt(8));

				return product;
			}  		    
		    });
			if(productList2.size()>0)
				product = productList2.get(0);
			else
				product = null;
		}
		return product;
	}
	
	public int restock(Integer sid, String name, String category, Integer warehouse){
		int result=0;
		try{
			result = jdbcTemplate.update("update product set warehouse=warehouse+"+
				warehouse+" where name='"+name+"' and category='"+category+"' and sid="+sid);
		} catch(Exception e){
			result = 0;
		}
		return result;
	}

	public List<Product> showAllProducts(){
		//(Palash Add Query)String sql = "select * from product p1 where cost=(select min(cost) from product p2 where p1.id=p2.id) "
		return  jdbcTemplate.query("select * from product ", new RowMapper<Product>(){
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();  
		        product.setId(rs.getInt(1));
				product.setSid(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setCategory(rs.getString(4));
				product.setCost(rs.getDouble(5));
				product.setWarehouse(rs.getInt(6));
				product.setRating(rs.getDouble(7));
				product.setPurchased(rs.getInt(8));

				return product;
			}});}

			public List<Product> showProductsByCategory(String category){
				return  jdbcTemplate.query("select * from product where category="+category+"", new RowMapper<Product>(){
					public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
						Product product=new Product();  
						product.setId(rs.getInt(1));
						product.setSid(rs.getInt(2));
						product.setName(rs.getString(3));
						product.setCategory(rs.getString(4));
						product.setCost(rs.getDouble(5));
						product.setWarehouse(rs.getInt(6));
						product.setRating(rs.getDouble(7));
						product.setPurchased(rs.getInt(8));
		
						return product;
					}
				});}

				public List<Product> showProductsByName(String name){
					return  jdbcTemplate.query("select * from product where category="+name+"", new RowMapper<Product>(){
						public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
							Product product=new Product();  
							product.setId(rs.getInt(1));
							product.setSid(rs.getInt(2));
							product.setName(rs.getString(3));
							product.setCategory(rs.getString(4));
							product.setCost(rs.getDouble(5));
							product.setWarehouse(rs.getInt(6));
							product.setRating(rs.getDouble(7));
							product.setPurchased(rs.getInt(8));
			
							return product;
						}
					});}

}
