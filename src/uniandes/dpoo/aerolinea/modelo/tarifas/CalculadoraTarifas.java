package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	
	public double IMPUESTO = 0.28;
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) 
	{
		return calcularCostoBase(vuelo, cliente);
	}
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaVuelo(Ruta ruta)
	{
		Aeropuerto aeropuerto1 = ruta.getOrigen();
		Aeropuerto aeropuerto2 = ruta.getDestino();
		int distancia = Aeropuerto.calcularDistancia(aeropuerto1, aeropuerto2);
		return distancia;
	}

	protected int calcularVlorImpuesto(int costoBase) 
	{
		//
		int valorImpuesto = (int) (costoBase + (costoBase*IMPUESTO));
		return valorImpuesto;
	}


}
