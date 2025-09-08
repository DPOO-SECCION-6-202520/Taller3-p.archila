package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{

	protected int COSTO_POR_KM_NATURAL = 600;
	protected int COSTO_POR_KM_CORPORATIVO = 900;
	protected double DESCUENTO_PEQ = 0.02;
	protected double DESCUENTO_MEDIANAS = 0.1;
	protected double DESCUENTO_GRANDES = 0.2;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) 
	{
		Ruta ruta = vuelo.getRuta();
		int distancia = calcularDistanciaVuelo(ruta);
		if(cliente.getTipoCliente().equals("Corporativo")) 
		{
			int precioCorp = COSTO_POR_KM_CORPORATIVO * distancia;
			return precioCorp;
		}
		else 
		{
			int precioNat = COSTO_POR_KM_NATURAL * distancia;
			return precioNat;
		}
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) 
	{
		String tipo = cliente.getTipoCliente();
		
		if(tipo.equals("Corporativo")) 
		{
			
		}
		/** No entiendo para nada que quieren que devuelva aca.
		 * Como toda empresa tiene como atributo "PEQUENO", "MEDIANO", "GRANDE" no entiendo como usar los 3 descuantos
		 * Si esos atributos se refieren al tamano de la empresa se haria lo siguiente:
		 * Un if para revisar si la empresa es Grande, else if para ver si la empresa es Mediana y otro else if para ver si es Pequena.
		 * Ahora sabiendo que tipo es la empresa podemos multiplicar el precio base por 1-descuento_dado y ya con eso obtenemos el valor con su descuento.
		 */
			
		return 0;
	}
}
