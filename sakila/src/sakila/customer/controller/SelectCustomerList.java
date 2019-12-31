package sakila.customer.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.City;
import sakila.address.model.Country;
import sakila.address.model.CountryDao;
import sakila.address.model.Customer;
import sakila.address.model.CustomerDao;


@WebServlet("/SelectCustomerList")
public class SelectCustomerList extends HttpServlet {
	private CustomerDao customerDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json;charset=UTF-8"); 
		 System.out.println("/CUSTOMER/selectCityList");
			customerDao = new CustomerDao();
			List<Customer>list= customerDao.selectCustomerList();
			 System.out.println("listCont :"+list);		
			Gson gson = new Gson();
			String jsonStr = gson.toJson(list);
			System.out.println(jsonStr);
			response.getWriter().write(jsonStr);
		
	}

}
