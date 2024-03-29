/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiHospital
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiHospital.mundo;

import java.util.ArrayList;

import uniandes.cupi2.cupiHospital.mundo.Paciente.Motivo;

/**
 * Clase que representa una unidad del hospital.
 */
public class Unidad 
{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

	/**
	 * Enumeraci�n para el tipo de unidad.
	 */
	public enum Tipo
	{
		CUIDADOS_INTENSIVOS,
		CUIDADOS_INTERMEDIOS,
		PEDIATRIA,
		MATERNIDAD,
		GERIATRIA,
		OBSERVACION
	}
	
	/**
	 * Edad m�xima pediatr�a.
	 */
	public final static int EDAD_MAX_PEDIATRIA = 15;	

	/**
	 * Edad m�nima geriatr�a.
	 */
	public final static int EDAD_MIN_GERIATRIA = 60;	
	
	
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
	
	/***
	 * Nombre de la unidad.
	 */
	private String nombre;
	
	/**
	 * Tipo de unidad.
	 */
	private Tipo tipo;
	
	/**
	 * Lista de pacientes de la unidad.
	 */
	// TODO Parte2 PuntoA: Declare el atributo pacientes de tipo ArrayList.
	ArrayList<Paciente> pacientes;
	
	/**
	 * Encargado de la unidad.
	 */
	private Encargado encargado;
	
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

	/**
	 * Construye una nueva unidad con los par�metros dados.
	 * Inicializa una lista de pacientes vac�a.
	 * El encargado es null.
	 * @param pNombre Nombre de la unidad. pNombre != null && pNombre != "".
	 * @param pTipo Tipo de unidad.
	 */
	public Unidad(String pNombre, Tipo pTipo)
	{
		nombre=pNombre;
		tipo=pTipo;
		// TODO Parte2 PuntoB: Inicialice el atributo pacientes.
		pacientes  = new ArrayList<Paciente>();
		encargado = null;
	}
	
	//-------------------------------------------------------------
	// M�todos
	//-------------------------------------------------------------
	
	/**
     * Devuelve el nombre de la unidad.
     * @return Nombre de la unidad.
     */
    public String darNombre( )
    {
        return nombre;
    }
 
    /**
     * Devuelve el tipo de unidad.
     * @return Tipo de unidad.
     */
    public Tipo darTipo( )
    {
        return tipo;
    }
    
    /**
	 * Devuelve la lista de los pacientes que se encuentran en la unidad.
	 * @return La lista de pacientes que hay en la unidad.
	 */
	public ArrayList<Paciente> darPacientes( )
	{
		return pacientes;
		// TODO Parte2 PuntoC: Complete el m�todo seg�n la documentaci�n dada.
	}
    
	/**
	 * Devuelve el encargado de la unidad.
	 * @return Encargado de la unidad.
	 */
	public Encargado darEncargado()
	{
		return encargado;
	}
    
    /**
     * Da de alta de la unidad al paciente dado por par�metro. <br>
     * <b> pre: </b> pacientes!=null <br>
     * <b> post: </b> Si el paciente se encontraba en el unidad fue eliminado de la lista de pacientes. <br>
     * @param pNumeroIdentificacion N�mero de identificaci�n del paciente.
     */
    public void darDeAltaPaciente( int pNumeroIdentificacion )
    {
    	if(pacientes != null)
    	{
    		for (int i = 0; i < pacientes.size(); i++) 
    		{
				if(pacientes.get(i).darNumeroIdentificacion()==pNumeroIdentificacion)
				{
					pacientes.remove(i);
				}
			}
    	}
    	// TODO Parte2 PuntoD: Complete el m�todo seg�n la documentaci�n dada.
    }
    
    /**
     * Busca el paciente con el n�mero de identificaci�n dado. <br>
     * <b> pre: </b> pacientes!=null <br>
     * @param pNumeroIdentificacion N�mero de identificaci�n del paciente a ser buscado.
     * @return El paciente con el n�mero de identificaci�n especificado o null si �ste no es encontrado.
     */
    public Paciente buscarPaciente( int pNumeroIdentificacion )
    {
    	if(pacientes != null)
    	{
    		for (int i = 0; i < pacientes.size(); i++) {
				if(pacientes.get(i).darNumeroIdentificacion() == pNumeroIdentificacion)
				{
					return pacientes.get(i); 
				}
			}
    	}
    	return null;
    	// TODO Parte2 PuntoE: Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega un paciente a la lista de pacientes.
     * @param pNombrePaciente Nombre del paciente. pNombrePaciente != null && pNombrePaciente != "".
	 * @param pApellido Apellido del paciente. pApellido != null &&pApellido != "". 
	 * @param pNumeroIdentificacion ID del paciente. pNumeroidentificacion > 0.
	 * @param pEdad Edad del paciente. pEdad >= 0.
	 * @param pDiagnostico Diagn�stico del paciente. pDiagnostico != null && pDiagnostico != "".
	 * @param pDiasHospitalizacion D�as de hospitalizaci�n del paciente. pDiasHospitalizacion >= 0.
	 * @param pMotivoIngreso Motivo de ingreso del paciente en el hospital.
     */
	public void agregarPaciente(String pNombrePaciente, String pApellido, int pNumeroIdentificacion, int pEdad, String pDiagnostico, int pDiasHospitalizacion, Motivo pMotivoIngreso) 
	{
		if(pNombrePaciente != null && pNombrePaciente != "" && pApellido != null && pApellido != "" && pNumeroIdentificacion > 0 && pEdad >=0 && pDiagnostico != null && pDiagnostico != "" && pDiasHospitalizacion >=0)
		{
			Paciente paciente = new Paciente(pNombrePaciente,pApellido,pNumeroIdentificacion,pEdad,pDiagnostico,pDiasHospitalizacion, pMotivoIngreso);
			pacientes.add(paciente);
		}
		// TODO Parte2 PuntoF: Complete el m�todo seg�n la documentaci�n dada.
	}

	/**
	 * Retorna el paciente de mayor edad en la unidad. Si hay dos o m�s pacientes con la edad m�xima, retorna cualquiera de los dos.
	 * @return Paciente de mayor edad, null si no hay pacientes en el hospital.
	 */
	public Paciente darPacienteMayorEdad() 
	{
		Paciente pacienteMayor = null;
		if(pacientes.size()==0)
		{
			return pacienteMayor;
		}
		else
		{
			for (int i = 0; i < pacientes.size(); i++) 
			{
				if(i==0)
				{
					pacienteMayor = pacientes.get(i);
				}
				else if(pacienteMayor.darEdad() < pacientes.get(i).darEdad())
				{
					pacienteMayor = pacientes.get(i);
				}
			}
		}
		return pacienteMayor;
		 //revisar
		// TODO Parte2 PuntoG: Complete el m�todo seg�n la documentaci�n dada.
	}
	
	/**
	 * Asigna el encargado con los valores dados por par�metro a la unidad, si la unidad ya ten�a encargado no lo asigna.
	 * @param pNombre Nombre del encargado. pNombre != null && pNombre != "".
	 * @param pAniosExperiencia A�os de experiencia del encargado. pAniosExperiencia > 0.
	 * @return True si el encargado se pudo asignar, false si la unidad ya ten�a encargado.
	 */
	public boolean asignarEncargado( String pNombre, int pAniosExperiencia)
	{
		boolean valor = false;
		if(encargado == null)
		{
			encargado = new Encargado(pNombre,pAniosExperiencia);
			valor = true;
		}
		return valor;
		// TODO Parte2 PuntoH: Complete el m�todo seg�n la documentaci�n dada.
	}
    
}
