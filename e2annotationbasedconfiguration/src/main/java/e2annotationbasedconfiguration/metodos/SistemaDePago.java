package e2annotationbasedconfiguration.metodos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/* Gestion del Pago 
 * Clase donde se realiza la inyección de dependencias y se selecciona el método de pago.
 * */

@Component
public class SistemaDePago {

	private MetodosDePago metodosDePago;
	
	//Constructor. Inyección de dependencias por constructor.
	@Autowired
	public SistemaDePago(@Qualifier("pagoTDC") MetodosDePago metodosDePago) {
		this.metodosDePago = metodosDePago;
	}
	
	public void procesarPago(double cantidad) {
		boolean pagoExitoso = metodosDePago.procesarPago(cantidad);
		if(pagoExitoso) {
			// La factura se genera con un número aleatorio no mayor a 4 dígitos
			System.out.println("Factura generada: #" + (int) (Math.random() * 10000));
		}
	}
}
