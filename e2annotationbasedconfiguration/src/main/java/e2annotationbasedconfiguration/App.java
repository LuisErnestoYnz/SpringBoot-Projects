package e2annotationbasedconfiguration;

/*
 * Luis Ernesto Fernández Yáñez, EID luis.b.fernandez
 * */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import e2annotationbasedconfiguration.config.AppConfig;
import e2annotationbasedconfiguration.metodos.SistemaDePago;
import e2annotationbasedconfiguration.metodos.Impl.PagoTDC;

public class App {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		// Seleccionamos el pago con tarjeta de crédito en SistemaDePago.java con la notación @Qualifier 
		SistemaDePago sistemaDePago = appContext.getBean(SistemaDePago.class);
		sistemaDePago.procesarPago(250.00);
	}

}
