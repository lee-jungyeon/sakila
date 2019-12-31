package sakila.address.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.City;
import sakila.address.model.CityDao;
import sakila.address.model.Country;
import sakila.address.model.CountryDao;


@WebServlet("/SelectCityList")
public class SelectCityListServlet extends HttpServlet {
	
	private CityDao cityDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		System.out.println("/address/selectCityList");
		System.out.println("cut : "+request.getParameter("currentPage"));
		
		
		int	currentPage=Integer.parseInt(request.getParameter("currentPage"));
		

		cityDao = new CityDao();
		List<City>list= cityDao.selectCityList(currentPage);
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		System.out.println(jsonList);
		response.getWriter().write(jsonList);
	}
}
