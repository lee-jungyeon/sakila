package sakila.address.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.address.model.Address;
import sakila.address.model.AddressDao;
import sakila.address.model.City;
import sakila.address.model.CityDao;
import sakila.address.model.Country;


@WebServlet("/InsertAddress")
public class InsertAddressServlet extends HttpServlet {
	private AddressDao addressDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 System.out.println("servlet 도착1");
	 	String address =request.getParameter("address");
	 	String address2 =request.getParameter("address2");
	 	String district =request.getParameter("district");
	 	int	cityId =Integer.parseInt(request.getParameter("cityId"));
	 	String postalCode =request.getParameter("postalCode");
	 	String phone =request.getParameter("phone");
	 
	 
	 	addressDao = new AddressDao();
	 	Address a = new Address();
	 	Connection conn = null;
	 	a.setAddress(address);
	 	a.setAddress2(address2);
	 	a.setDistrict(district);
	 	a.setCity(new City());
	 	a.getCity().setCityId(cityId);
	 	a.setPostalCode(postalCode);
	 	a.setPhone(phone);
	 	
	 	System.out.println("값 확인 Servlet a:"+a);
	 	try {
			addressDao.insertAddressDao(conn, a);
		} catch (Exception e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}

}
