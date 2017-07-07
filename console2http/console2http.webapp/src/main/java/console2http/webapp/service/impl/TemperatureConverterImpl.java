package console2http.webapp.service.impl;

import console2http.webapp.service.TemperatureConverter;

public class TemperatureConverterImpl implements TemperatureConverter {

	public double celsius2fahrenheit(double celsius) {
		return celsius * 9.0 / 5.0 + 32.0;
	}

	public double fahrenheit2celsius(double fahrenheit) {
		return (fahrenheit - 32.0) * 5.0 / 9.0;
	}

}
