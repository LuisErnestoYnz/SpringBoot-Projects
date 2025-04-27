package e2annotationbasedconfiguration.metodos;

public interface MetodosDePago {
	// Metodo que recibe la cantidad a pagar, true si el pago es satisfactorio, false si no.
    public boolean procesarPago(double cantidad);
}
