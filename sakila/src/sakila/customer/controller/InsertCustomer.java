package sakila.customer.controller;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.address.model.Address;
import sakila.address.model.City;
import sakila.address.model.Customer;
import sakila.address.model.Store;
import sakila.customer.service.CustomerService;

@WebServlet("/InsertCustomer")
public class InsertCustomer extends HttpServlet {
	
	private CustomerService customerService;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//address request.getParameter("")
		String address =request.getParameter("address");
	 	String address2 =request.getParameter("address2");
	 	String district =request.getParameter("district");
	 	int	cityId =Integer.parseInt(request.getParameter("cityId"));
	 	String postalCode =request.getParameter("postalCode");
	 	String phone =request.getParameter("phone");
		PreparedStatement stmt = null;
		
		customerService = new CustomerService();
		Address a = new Address();
		a.setAddress(address);
	 	a.setAddress2(address2);
	 	a.setDistrict(district);
	 	a.setCity(new City());
	 	a.getCity().setCityId(cityId);
	 	a.setPostalCode(postalCode);
	 	a.setPhone(phone);
	 	System.out.println("값 확인 Servlet a:"+a);
		//address.set0
		//customer request.getParameter("")
		int	storeId =Integer.parseInt(request.getParameter("storeId"));
	 	String firstName =request.getParameter("firstName");
	 	String lastName =request.getParameter("lastName");
	 	String email =request.getParameter("email");
	 	
		Customer customer = new Customer();
		customer.setStore(new Store());
		customer.getStore().setStoreId(storeId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		
		System.out.println("값 확인 Servlet a:"+customer);
	 	
		
		customerService.insertCustomer(a, customer);
		
	}

}
