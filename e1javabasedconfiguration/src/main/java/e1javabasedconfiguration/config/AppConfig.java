package e1javabasedconfiguration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import e1javabasedconfiguration.ShipmentProcessor;
import e1javabasedconfiguration.envios.Impl.EnvioAereo;
import e1javabasedconfiguration.envios.Impl.EnvioMaritimo;
import e1javabasedconfiguration.envios.Impl.EnvioTerrestre;

// Configuración de los Beans para realizar la inyección de dependencias 

@Configuration
public class AppConfig {

	@Bean
	public EnvioAereo envioAereo() {
		return new EnvioAereo();
	}
	
	@Bean
	public EnvioMaritimo envioMaritimo() {
		return new EnvioMaritimo();
	}
	
	@Bean
	public EnvioTerrestre envioTerrestre() {
		return new EnvioTerrestre();
	}
	
	@Bean 
	public ShipmentProcessor shipmentProcessor() {
		return new ShipmentProcessor(envioAereo());
	}
}
