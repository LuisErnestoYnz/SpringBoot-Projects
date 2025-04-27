package e1javabasedconfiguration.envios.Impl;

import e1javabasedconfiguration.envios.SistemaCalculoDeCostoEnvioPorTransporte;

public class EnvioMaritimo implements SistemaCalculoDeCostoEnvioPorTransporte {
	// tarifa específica para envío marítimo según el peso del paquete
    private static final double TARIFA_MARITIMA_POR_KG = 1.50;
    
    // implementa método que recibe el peso del paquete y devolverá el costo total
    @Override
    public void calcularCosto(double peso) {
    	double costo = peso * TARIFA_MARITIMA_POR_KG;
    	System.out.println("Tipo de envío Marítimo");
    	System.out.println("Peso del paquete: " + peso + " kg");
        System.out.println("Costo total del envío: $" + costo);
        System.out.println("");
    }
}
