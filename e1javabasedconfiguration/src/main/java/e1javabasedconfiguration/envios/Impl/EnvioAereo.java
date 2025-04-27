package e1javabasedconfiguration.envios.Impl;

import e1javabasedconfiguration.envios.SistemaCalculoDeCostoEnvioPorTransporte;

public class EnvioAereo implements SistemaCalculoDeCostoEnvioPorTransporte {
	// tarifa específica para envío aéreo según el peso del paquete
    protected static final double TARIFA_AEREA_POR_KG = 5.00;
    
    // implementa método que recibe el peso del paquete y devolverá el costo total
    @Override
    public void calcularCosto(double peso) {
    	double costo = peso * TARIFA_AEREA_POR_KG;
    	System.out.println("Tipo de envío Aereo");
    	System.out.println("Peso del paquete: " + peso + " kg");
        System.out.println("Costo total del envío: $" + costo);
        System.out.println("");
    }
}
