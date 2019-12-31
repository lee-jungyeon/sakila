package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sakila.db.DBHelper;

public class AddressDao {
	public int insertAddressDao(Connection conn, Address address) throws Exception {
		int addressId = 0;
		System.out.println("도착2 :"+address);
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO address (address, address2,district, city_id, postal_code, phone, last_update) VALUES (?,?,?,?,?,?,now())";
		
			
			stmt= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//프라이머리 키값을 받는 쿼리문;
			stmt.setString(1,address.getAddress());
			stmt.setString(2,address.getAddress2());
			stmt.setString(3,address.getDistrict());
			stmt.setInt(4, address.getCity().getCityId());
			stmt.setString(5,address.getPostalCode());
			stmt.setString(6,address.getPhone());
		
			stmt.executeUpdate();
			rs= stmt.getGeneratedKeys();
			if(rs.next()) {
				addressId = rs.getInt(1);//프라이머리 키값을 받는다.
			}		
			
		
		return addressId;
	}
	
	public List<Address> selectAddressList(){
		List<Address> list= new ArrayList<Address>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select a.address_id,a.address,a.address2, a.district,a.city_id,a.postal_code,a.phone,a.last_update  from address a inner join city c on c.city_id=a.city_id order by a.address_id desc limit 100";
		try {
			conn =DBHelper.getConnection();
			stmt= conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Address a= new Address();
				a.setAddressId(rs.getInt("a.address_id"));
				a.setAddress(rs.getString("a.address"));
				a.setAddress2(rs.getString("a.address2"));
				a.setDistrict(rs.getString("a.district"));
				a.setCity(new City());
				a.getCity().setCityId(rs.getInt("a.city_id"));
				a.setPostalCode(rs.getString("a.postal_code"));
				a.setPhone(rs.getString("a.phone"));
				a.setLastUpdate(rs.getString("a.last_update"));
				list.add(a);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}

	public int selectAddressCount() {
		int count =0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql="SELECT COUNT(*) FROM address";
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
