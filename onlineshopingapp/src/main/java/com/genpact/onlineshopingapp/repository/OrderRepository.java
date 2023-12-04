package com.genpact.onlineshopingapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.genpact.onlineshopingapp.entity.Orders;
import com.genpact.onlineshopingapp.entity.Product;

public class OrderRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    public List<Orders> getOrderByCustomerId(String customerId) {
        return jdbcTemplate.query("select * from orders where cid='"+customerId+
			"'",new RowMapper<Orders>(){
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders order=new Orders();
		        order.setId(rs.getInt(1));
				order.setCid(rs.getInt(2));
				order.setSid(rs.getInt(3));
				order.setPid(rs.getInt(4));
				order.setAmount(rs.getDouble(5));
				order.setQuantity(rs.getInt(6));
				order.setOrderDate(rs.getDate(7).toLocalDate());
				order.setShippingDate(rs.getDate(8).toLocalDate());
				order.setPayId(rs.getInt(9));
				order.setConfirmation(rs.getBoolean(10));

				return order;
			}  		    
		    });
    }

    public List<Orders> getPendingOrders(Integer shopkeeperId) {
        return jdbcTemplate.query("select * from orders where sid='"+shopkeeperId+
			"' and confirmation=null",new RowMapper<Orders>(){
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders order=new Orders();
		        order.setId(rs.getInt(1));
				order.setCid(rs.getInt(2));
				order.setSid(rs.getInt(3));
				order.setPid(rs.getInt(4));
				order.setAmount(rs.getDouble(5));
				order.setQuantity(rs.getInt(6));
				order.setOrderDate(rs.getDate(7).toLocalDate());
				order.setShippingDate(rs.getDate(8).toLocalDate());
				order.setPayId(rs.getInt(9));
				order.setConfirmation(rs.getBoolean(10));

				return order;
			}  		    
		    });
    }

    public int setConfirmation(Orders order) {
        int result;
		try{
			result = jdbcTemplate.update("update orders set Confirmation="+
				order.getConfirmation()+" where id="+order.getId());
			jdbcTemplate.update("update orders set shippingDate='"+
				LocalDate.now().plusDays(6)+"' where id="+order.getId());
		} catch(Exception e){
			result = 0;
		}
        return result;
    }

    public int placeOrder(Integer cid, Product product, Integer quantity, Integer pay_id) {
		int result;
		try{
			result = jdbcTemplate.update("insert into orders(cid, sid, pid, amount"+
				", quantity, order_date, pay_id) values("+cid+", "+product.getSid()+
				", "+product.getId()+", "+product.getCost()+", "+quantity+", '"+
				LocalDate.now()+"', "+pay_id+")");
		} catch(Exception e){
			result = 0;
		}
		return result;
    }
	
}
