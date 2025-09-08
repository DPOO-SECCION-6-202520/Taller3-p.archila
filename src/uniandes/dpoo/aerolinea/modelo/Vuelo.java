package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Collection<Tiquete> tiquetes;

	public Vuelo(Ruta ruta, String fecha, Avion avion) 
	{
		this.avion = avion;
		this.fecha = fecha;
		this.ruta = ruta;
		this.tiquetes = new ArrayList<Tiquete>();
	}
	
	public Ruta getRuta() 
	{
		return ruta;
	}
	
	public Avion getAvion() 
	{
		return avion;
	}
	
	public String getFecha() 
	{
		return fecha;
	}
	
	public ArrayList<Tiquete> getTiquetes() 
	{
		return (ArrayList<Tiquete>) tiquetes;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) 
	{
		int tarifa = calculadora.calcularTarifa(null, cliente);
		return tarifa*cantidad;
		/** Como no sabemos el formato de la fecha no puedo saber si la fecha corresponde a temporada alta o baja. Si supieramos este dato tocaria usar o la clase de CalcluladoraTarifasTemporadaAlta o CalculadoraTarifasTemporadaBaja.
		 */
	}

}