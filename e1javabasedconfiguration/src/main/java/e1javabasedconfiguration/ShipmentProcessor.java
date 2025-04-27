package e1javabasedconfiguration;

import e1javabasedconfiguration.envios.SistemaCalculoDeCostoEnvioPorTransporte;

/*
 * En esta clase se recibirá un SistemaCalculoDeCostoEnvioPorTransporte y usará el método calcularCosto() 
 * para calcular el costo del envío según el peso.
 * */

public class ShipmentProcessor {
	// Uso de esta variable de referencia para utilizar el método calcularCosto()
    private SistemaCalculoDeCostoEnvioPorTransporte sistemaCalculoDeCostoEnvioPorTransporte;
    
    // Se utiliza la inyección de dependencias por Constructor 
    public ShipmentProcessor(SistemaCalculoDeCostoEnvioPorTransporte sistemaCalculoDeCostoEnvioPorTransporte) {
    	this.sistemaCalculoDeCostoEnvioPorTransporte = sistemaCalculoDeCostoEnvioPorTransporte;
    }
    
    // Procesar envío para calcular el costo dado el peso de un Tipo de envío
    public void procesarEnvio(double peso) {
    	this.sistemaCalculoDeCostoEnvioPorTransporte.calcularCosto(peso);
    }
    
}
