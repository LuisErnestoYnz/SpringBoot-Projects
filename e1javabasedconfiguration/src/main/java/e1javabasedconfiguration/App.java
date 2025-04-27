package e1javabasedconfiguration;

/*
 * Luis Ernesto Fernández Yáñez, EID luis.b.fernandez
*/

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import e1javabasedconfiguration.config.AppConfig;
import e1javabasedconfiguration.envios.Impl.EnvioAereo;
import e1javabasedconfiguration.envios.Impl.EnvioTerrestre;
import e1javabasedconfiguration.envios.Impl.EnvioMaritimo;
import e1javabasedconfiguration.ShipmentProcessor;

public class App {

	public static void main(String[] args) {
		// Código cuando se va a utilizar las configuraciones basadas en Java
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
				
		// Selección del tipo de Envío Aéreo
        EnvioAereo envioAereo = appContext.getBean(EnvioAereo.class);
        envioAereo.calcularCosto(10);
        
        // Selección del tipo de Envío Marítimo
        EnvioMaritimo envioMaritimo = appContext.getBean(EnvioMaritimo.class);
        envioMaritimo.calcularCosto(10);
        
        // Selección del tipo de Envío Terrestre
        EnvioTerrestre envioTerrestre = appContext.getBean(EnvioTerrestre.class);
        envioTerrestre.calcularCosto(10);
        
        // Por Gestor de envíos con peso de 10 kg
        ShipmentProcessor shipmentProcessor = new ShipmentProcessor(envioAereo);
        shipmentProcessor.procesarEnvio(10);
	}

}
