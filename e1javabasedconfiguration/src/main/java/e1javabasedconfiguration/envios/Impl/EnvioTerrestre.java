package e1javabasedconfiguration.envios.Impl;

import e1javabasedconfiguration.envios.SistemaCalculoDeCostoEnvioPorTransporte;

public class EnvioTerrestre implements SistemaCalculoDeCostoEnvioPorTransporte {
	// tarifa específica para envío terrestre según el peso del paquete
    private static final double TARIFA_TERRESTRE_POR_KG = 2.00;
    
    // implementa método que recibe el peso del paquete y devolverá el costo total
    @Override
    public void calcularCosto(double peso) {
    	double costo = peso * TARIFA_TERRESTRE_POR_KG;
    	System.out.println("Tipo de envío Terrestre");
    	System.out.println("Peso del paquete: " + peso + " kg");
        System.out.println("Costo total del envío: $" + costo);
        System.out.println("");
    }
}
