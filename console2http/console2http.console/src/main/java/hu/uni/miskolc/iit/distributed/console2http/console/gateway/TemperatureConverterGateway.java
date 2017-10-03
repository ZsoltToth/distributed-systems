package hu.uni.miskolc.iit.distributed.console2http.console.gateway;

import org.springframework.integration.annotation.Payload;

public interface TemperatureConverterGateway {

	String celsius2fahrenheit(@Payload double celsius);
	String fahrenheit2celsius(@Payload double fahrenheit);
}
