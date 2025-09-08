package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	public ArrayList<Tiquete> tiquetesSinUsar;
	public ArrayList<Tiquete> tiquetesUsados;

	public Cliente() 
	{
		this.tiquetesSinUsar = new ArrayList<Tiquete>();
		this.tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete tiquete) 
	{
		tiquetesUsados.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes(CalculadoraTarifas calculadora) 
	{
		int precioTotal = 0;
		for(int i = 0; i < tiquetesSinUsar.size(); i++) 
		{
			Tiquete tiquete = tiquetesSinUsar.get(i);
			Vuelo vuelo = tiquete.getVuelo();
			precioTotal = precioTotal + calculadora.calcularTarifa(vuelo, null);
		}
		for(int j = 0; j < tiquetesUsados.size(); j++) 
		{
			Tiquete tiquete = tiquetesUsados.get(j);
			Vuelo vuelo = tiquete.getVuelo();
			precioTotal = precioTotal + calculadora.calcularTarifa(vuelo, null);
		}
		return precioTotal;
	}
	
	public void usarTiquetes(Vuelo vuelo) 
	{
		ArrayList<Tiquete> tiquetesVuelo = vuelo.getTiquetes();
		for(int i = 0; i < tiquetesVuelo.size(); i++) 
		{
			tiquetesUsados.add(tiquetesVuelo.get(i));
		}
	}
}
