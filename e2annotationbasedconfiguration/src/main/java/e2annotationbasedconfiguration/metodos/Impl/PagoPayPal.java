package e2annotationbasedconfiguration.metodos.Impl;

import org.springframework.stereotype.Component;

import e2annotationbasedconfiguration.metodos.MetodosDePago;
/*
 * Implementa interfaz MetodosDePago. Se valida la cantidad a pagar.
 * true si el pago es satisfactorio, false si no.
*/
@Component("pagoPayPal")
public class PagoPayPal implements MetodosDePago {
	@Override
	public boolean procesarPago(double cantidad) {
		if(cantidad > 0) {
			System.out.println("Pago de $"+ cantidad + " efectuado con PayPal.");
			return true;          // Ya que el pago será valido
		} else {
			System.out.println("Antención: ¡Error de pago con PayPal!. Monto no válido.");
			return false;         // Ya que el pago no será valido
		}
	}
}
