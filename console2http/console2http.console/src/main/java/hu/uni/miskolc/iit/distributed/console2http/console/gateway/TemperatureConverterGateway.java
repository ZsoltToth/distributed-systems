package hu.uni.miskolc.iit.distributed.console2http.console.gateway;

import org.springframework.integration.annotation.Payload;

public interface TemperatureConverterGateway {

	double celsius2fahrenheit(@Payload double celsius);
	double fahrenheit2celsius(@Payload double fahrenheit);
}
