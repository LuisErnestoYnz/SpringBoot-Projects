package e2annotationbasedconfiguration.metodos.Impl;

import org.springframework.stereotype.Component;

import e2annotationbasedconfiguration.metodos.MetodosDePago;
/*
 * Implementa interfaz MetodosDePago. Se valida la cantidad a pagar.
 * true si el pago es satisfactorio, false si no.
*/
@Component("pagoTDD")
public class PagoTDD implements MetodosDePago {
	@Override
	public boolean procesarPago(double cantidad) {
		if(cantidad > 0) {
			System.out.println("Pago de $"+ cantidad + " efectuado con Tarjeta de Débito.");
			return true;          // Ya que el pago será valido
		} else {
			System.out.println("Antención: ¡Error de pago con Tarjeta de Débito!. Monto no válido.");
			return false;         // Ya que el pago no será valido
		}
	}
}
