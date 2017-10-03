package console2http.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import console2http.webapp.service.TemperatureConverter;

@Controller
@RequestMapping(value= {"/temperature"})
public class TemperatureConverterController {

	@Autowired
	private TemperatureConverter tempConverter;
	
	@RequestMapping(value= {"/c2f","/celsius2fahrenheit"}, method = {RequestMethod.GET})
	@ResponseBody
	public Double celsius2fahrenheit(double celsius) {
		return tempConverter.celsius2fahrenheit(celsius);
	}
	
	@RequestMapping(value= {"/f2c","/fahrenheit2celsius"}, method = {RequestMethod.GET})
	@ResponseBody
	public Double fahrenheit2celsius(double fahrenheit) {
		return tempConverter.fahrenheit2celsius(fahrenheit);
	}
}
