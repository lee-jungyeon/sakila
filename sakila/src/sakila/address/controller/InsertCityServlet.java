package sakila.address.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.address.model.City;
import sakila.address.model.CityDao;
import sakila.address.model.Country;
import sakila.address.model.CountryDao;


@WebServlet("/InsertCity")
public class InsertCityServlet extends HttpServlet {
	
	private CityDao cityDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	 	String city =request.getParameter("city");
	 	int	countryId =Integer.parseInt(request.getParameter("countryId"));
	 	System.out.println("값 확인"+city);
	 	cityDao = new CityDao();
	 	City c = new City();
	 	c.setCity(city);
	 	c.setCountry(new Country());
	 	c.getCountry().setCountryId(countryId);
	 	cityDao.insertCityDao(c);
	 
	}

}
