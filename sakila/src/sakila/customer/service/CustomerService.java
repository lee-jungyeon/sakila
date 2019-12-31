package sakila.customer.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import sakila.address.model.Address;
import sakila.address.model.AddressDao;
import sakila.address.model.Customer;
import sakila.address.model.CustomerDao;
import sakila.db.DBHelper;

public class CustomerService {
	private AddressDao addressDao;
	private CustomerDao customerDao;
	public void insertCustomer(Address address, Customer customer)  {
	System.out.println("servlet 도착 :"+address+customer);
		Connection conn = null;
		try {
			
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			
			addressDao= new AddressDao();
			
			int addressId = addressDao.insertAddressDao(conn, address);
			customer.setAddressId(addressId);
			
			customerDao = new CustomerDao();
			customerDao.insertCustomer(conn, customer);
			conn.commit();
		}catch(Exception e) {
			try{conn.rollback();} catch(SQLException e1) {
				e1.printStackTrace();
			}//rollback:예외가 생기면 commit x
			e.printStackTrace();
		}finally {
			DBHelper.close(null, null, conn);
			
		}
		
		
	}
	
			
}
