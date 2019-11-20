package uniandes.cupi2.cupiHospital.mundo;

public class Encargado 
{
	
	
	private int aniosExperiencia;
	
	private String nombre;

	public int darAniosExperiencia() {
		return aniosExperiencia;
	}

	public String darNombre() {
		return nombre;
	}
	
	public Encargado(String pNombre, int pAniosExperiencia)
	{
		nombre = pNombre;
		aniosExperiencia = pAniosExperiencia;
	}
}
