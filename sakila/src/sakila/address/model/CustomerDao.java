package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sakila.db.DBHelper;

public class CustomerDao {
		public List<Customer> selectCustomerList(){
		List<Customer> list= new ArrayList<Customer>();	
		System.out.println("listDao :"+list);		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="select customer_id, concat(first_name,'',last_name) name from customer";
		try {
			conn =DBHelper.getConnection();
			stmt= conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Customer c= new Customer();
				c.setCustomerId(rs.getInt("customer_id"));
				c.setName(rs.getString("name"));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		 System.out.println("listDao :"+list);		
		return list;
	}
	
	public void insertCustomer(Connection conn, Customer customer)throws Exception {
		
		System.out.println("도착2 :"+customer);
		//Connection conn = null;
		PreparedStatement stmt = null;
	
		String sql = "INSERT INTO customer (store_id, first_name, last_name, "
				+ "email, address_id, active, create_date, last_update) VALUES (?,?,?,?,?,1, now(),now())";
	
			//conn =DBHelper.getConnection();
		stmt= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1,customer.getStore().getStoreId());
			stmt.setString(2,customer.getFirstName());
			stmt.setString(3, customer.getLastName());
			stmt.setString(4,customer.getEmail());
			stmt.setInt(5,customer.getAddressId());
			stmt.executeUpdate();
			
			return ;
		
	}


	
	public int selectCustomerCount() {
		int count =0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql="SELECT COUNT(*) FROM customer";
		try {
		 conn =DBHelper.getConnection();
		 stmt = conn.prepareStatement(sql);
		 rs =stmt.executeQuery();
		 if(rs.next()) {
			 count = rs.getInt("COUNT(*)");
		 }
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		
	return count;
}
		
}
