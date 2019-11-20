/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiHospital
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiHospital.mundo;


import java.util.Iterator;

import uniandes.cupi2.cupiHospital.mundo.Paciente.Motivo;
import uniandes.cupi2.cupiHospital.mundo.Unidad.Tipo;

/**
 * Clase que representa el hospital.
 */
public class Hospital  
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Cantidad de unidades del hospital.
	 */
	public final static int NUMERO_UNIDADES = 6;

	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
	
	/**
	 * Arreglo que contiente las unidades del hospital.
	 */
	// TODO Parte3 PuntoA: Declare el atributo unidades como contenedora de tamaño fijo.
	private Unidad[] unidades;
	// TODO Parte3 PuntoA: Declare el atributo unidades como contenedora de tama�o fijo.

		// -----------------------------------------------------------------
		// Constructores
		// -----------------------------------------------------------------
		/**
		 * Construye el hospital con las siguientes unidades en el arreglo:
		 * unidades[0] - nombre: Unidad A, Tipo: Cuidados intensivos.
		 * unidades[1] - nombre: Unidad B, Tipo: Cuidados intermedios.
		 * unidades[2] - nombre: Unidad C, Tipo: Pediatr�a.
		 * unidades[3] - nombre: Unidad D, Tipo: Maternidad.
		 * unidades[4] - nombre: Unidad E, Tipo: Geriatr�a.
		 * unidades[5] - nombre: Unidad F, Tipo: Observaci�n.
		 */
		public Hospital()
		{
			unidades = new Unidad[NUMERO_UNIDADES];
			unidades[0] =  new Unidad("Unidad A",Unidad.Tipo.CUIDADOS_INTENSIVOS);
			unidades[1] =  new Unidad("Unidad B",Unidad.Tipo.CUIDADOS_INTERMEDIOS);
			unidades[2] =  new Unidad("Unidad C",Unidad.Tipo.PEDIATRIA);
			unidades[3] =  new Unidad("Unidad D",Unidad.Tipo.MATERNIDAD);
			unidades[4] =  new Unidad("Unidad E",Unidad.Tipo.GERIATRIA);
			unidades[5] =  new Unidad("Unidad F",Unidad.Tipo.OBSERVACION);
			// TODO Parte3 PuntoB: Inicialice el atributo unidades con tama�o NUMERO_UNIDADES e inicialice cada una da las unidades.
		}

	//-------------------------------------------------------------
	// Métodos
	//-------------------------------------------------------------

	/**
	 * Devuelve el arreglo con las unidades del hospital.
	 * @return El arreglo de unidades.
	 */
		public Unidad[] darUnidades() 
		{
			return unidades;
		}
		// TODO Parte3 PuntoC: Complete el método según la documentación dada.
	/**
	 * Interna un nuevo paciente al hospital con los parámetros dados. No se permite internar un paciente si:
	 *   - existe un paciente con el mismo número de identificación.
	 *   - se desea internarlo en pediatría y tiene mas de 15 años (Unidad.EDAD_MAX_PEDIATRIA).
	 *   - se desea internarlo en geriatría y tiene menos de 60 años (Unidad.EDAD_MIN_GERIATRIA).
	 * @param pNombreUnidad Nombre de la unidad a la que se ingresa el paciente.
	 * @param pNombrePaciente Nombre del paciente. pNombrePaciente != null && pNombrePaciente != "".
	 * @param pApellido Apellido del paciente. pApellido != null &&pApellido != "". 
	 * @param pNumeroIdentificacion ID del paciente. pNumeroidentificacion > 0.
	 * @param pEdad Edad del paciente. pEdad >= 0.
	 * @param pDiagnostico Diagnóstico del paciente. pDiagnostico != null && pDiagnostico != "".
	 * @param pDiasHospitalizacion Días de hospitalización del paciente. pDiasHospitalizacion >= 0.
	 * @param pMotivoIngreso Motivo de ingreso del paciente en el hospital.
	 * @return true si logra ingresar el paciente, false en caso contrario.
	 */
	public boolean internarNuevoPaciente(String pNombreUnidad, String pNombrePaciente, String pApellido, int pNumeroIdentificacion, int pEdad, String pDiagnostico, int pDiasHospitalizacion, Motivo pMotivoIngreso)
	{
		boolean valor = false;
		if(buscarUnidad(pNombreUnidad)!=null && buscarPaciente(pNumeroIdentificacion)==null)
		{
			if((buscarUnidad(pNombreUnidad).darNombre().equals("Unidad C") && pEdad > buscarUnidad(pNombreUnidad).EDAD_MAX_PEDIATRIA) || (buscarUnidad(pNombreUnidad).darNombre().equals("Unidad E") && pEdad >= buscarUnidad(pNombreUnidad).EDAD_MIN_GERIATRIA))   //pediatría y gerartria
			{
				valor = false;
			}
			else
			{
				buscarUnidad(pNombreUnidad).agregarPaciente(pNombrePaciente, pApellido, pNumeroIdentificacion, pEdad, pDiagnostico, pDiasHospitalizacion, pMotivoIngreso);
				valor = true;
			}
		}
		return valor; 
		// TODO Parte3 PuntoD: Complete el método según la documentación dada.
	}
	/**
	 * Devuelve un paciente dado su ID.
	 * @param pNumeroIdentificacion ID del paciente. pNumeroIdentificacion > 0.
	 * @return El paciente que tiene el ID dado por parámetro, null en caso de no encontrarlo.
	 */
	public Paciente buscarPaciente( int pNumeroIdentificacion )
	{
		if(pNumeroIdentificacion > 0)
		{
			for (int i = 0; i < unidades.length; i++) {
				if(unidades[i].buscarPaciente(pNumeroIdentificacion)!=null)
				{
					return unidades[i].buscarPaciente(pNumeroIdentificacion);
				}
			}
		}
		return null;
		// TODO Parte3 PuntoE: Complete el método según la documentación dada.
	}

	/**
	 * Determina si el paciente, dado su ID por parámetro, es dado de alta.
	 * @param pNumeroIdentificacion ID del paciente.
	 * @return True si el paciente es dado de alta, false en caso de no encontrarlo.
	 */
	public boolean darDeAltaPaciente( int pNumeroIdentificacion )
	{
		if(buscarPaciente(pNumeroIdentificacion)!=null)
		{
			buscarUnidadPaciente(pNumeroIdentificacion).darDeAltaPaciente(pNumeroIdentificacion);
			return true;
		}
		return false;
		// TODO Parte3 PuntoF: Complete el método según la documentación dada.
	}

	/**
	 * Cambia de unidad a un paciente dado su ID por parámetro, si se cumplen las siguiente condiciones.
	 * - Si la unidad destino es de tipo PEDIATRIA y el paciente no supera la edad máxima.
	 * - Si la unidad destino es de tipo GERIATRIA y el paciente no está por debajo de la edad mínima.
	 * - Si la unidad de destino no es la misma en la que se encuentra actualmente el paciente.
	 * post:<br> Se retira de la unidad original solo si es posible reasignarlo en la unidad destino. 
	 * @param pNumeroIdentificacion ID del paciente.
	 * @param pNuevaUnidad Unidad a la que será trasferido el paciente.
	 * @return True si pudo reubicar el paciente, false en caso contrario.
	 */
	public boolean reubicarPaciente( int pNumeroIdentificacion, String pNuevaUnidad )
	{
		if(buscarPaciente(pNumeroIdentificacion)!=null && buscarUnidad(pNuevaUnidad)!=null)
		{
			Paciente pacAux = buscarPaciente(pNumeroIdentificacion);
			if((buscarUnidad(pNuevaUnidad).darNombre().equals("Unidad C") && pacAux.darEdad() > buscarUnidad(pNuevaUnidad).EDAD_MAX_PEDIATRIA) || (buscarUnidad(pNuevaUnidad).darNombre().equals("Unidad E") && pacAux.darEdad() >= buscarUnidad(pNuevaUnidad).EDAD_MIN_GERIATRIA))
			{
				return false;
			}
			buscarUnidadPaciente(pNumeroIdentificacion).darDeAltaPaciente(pNumeroIdentificacion);
			internarNuevoPaciente(pNuevaUnidad, pacAux.darNombre(), pacAux.darApellido(), pacAux.darNumeroIdentificacion(), pacAux.darEdad(), pacAux.darDiagnostico(), pacAux.darDiasHospitalizacion(), pacAux.darMotivoIngreso());			
			return true;
		}
		return false;
		// TODO Parte3 PuntoG: Complete el método según la documentación dada.
	}

	/**
	 * Busca la unidad a la que pertenece un paciente.
	 * @param pNumeroIdentificacion ID del paciente.
	 * @return La unidad a la que pertenece el paciente, null en caso de no encontrar el paciente.
	 */
	public Unidad buscarUnidadPaciente( int pNumeroIdentificacion )
	{
		for (int i = 0; i < unidades.length; i++) {
			if(unidades[i].buscarPaciente(pNumeroIdentificacion)!=null)
			{
				return unidades[i];
			}
		}
		return null;
		// TODO Parte3 PuntoH: Complete el método según la documentación dada.
	}
	
	/**
	 * Busca una unidad dado su nombre.
	 * @param pNombreUnidad Nombre de la unidad.
	 * @return La unidad cuyo nombre es dado por parámetro, null en caso de no encontrarla.
	 */
	public Unidad buscarUnidad( String pNombreUnidad )
    {
		for (int i = 0; i < unidades.length; i++) {
			if(unidades[i].darNombre().equals(pNombreUnidad))
			{
				return unidades[i];
			}
		}
		return null;
		// TODO Parte3 PuntoI: Complete el método según la documentación dada.
    }
	
	/**
	 * Calcula la cantidad total de pacientes en el hospital.
	 * @return Cantidad total de pacientes en el hospital.
	 */
	public int darCantidadTotalPacientes() 
	{
		int valorTotal = 0;
		for (int i = 0; i < unidades.length; i++) {
			valorTotal = valorTotal + unidades[i].darPacientes().size();
		}
		return valorTotal;
		// TODO Parte3 PuntoJ: Complete el método según la documentación dada.
	}

	/**
	 * Retorna el paciente de mayor edad en el hospital. Si hay dos o más pacientes con la edad máxima, retorna cualquiera de los dos.
	 * @return Paciente de mayor edad, null si no hay pacientes en el hospital.
	 */
	public Paciente darPacienteMayorEdad() 
	{
		Paciente pacienteMayor = null;
		for (int i = 0; i < unidades.length; i++) {
			if(i==0)
			{
				pacienteMayor = unidades[i].darPacienteMayorEdad(); 
			}
			else if(unidades[i].darPacienteMayorEdad()!= null && pacienteMayor.darEdad() < unidades[i].darPacienteMayorEdad().darEdad())
			{
				pacienteMayor = unidades[i].darPacienteMayorEdad();
			}
		}
		return pacienteMayor;
		// TODO Parte3 PuntoK: Complete el método según la documentación dada.
	}

	/**
	 * Asigna el encargado con los valores dados por parámetro a la unidad dada por parámetro, si la unidad ya tenía encargado no lo asigna.
	 * @param pNombre Nombre del encargado. pNombre != null && pNombre != "".
	 * @param pAniosExperiencia Años de experiencia del encargado. pAniosExperiencia > 0.
	 * @param pUnidad Nombre de la unidad para asignar enccargado. pUnidad != null && pUnidad != "".
	 * @return True si el encargado se pudo asignar, false si la unidad ya tenía encargado o si no existe una unidad con el nombre dado.
	 */
	public boolean asignarEncargado (String pNombre, int pAniosExperiencia, String pUnidad)
	{
		if(pNombre!=null && pNombre != "" && pAniosExperiencia>0 && pUnidad != null && pUnidad!= "" && buscarUnidad(pUnidad)!= null && buscarUnidad(pUnidad).darEncargado()==null)
		{
			buscarUnidad(pUnidad).asignarEncargado(pNombre, pAniosExperiencia);
			return true;
		}
		return false;
		// TODO Parte3 PuntoL: Complete el método según la documentación dada.
	}

	// -----------------------------------------------------------------
	// Puntos de Extensión
	// -----------------------------------------------------------------

	/**
	 * Método para la extensión 1.
	 * @return Respuesta1.
	 */
	public String metodo1( )
	{
		return "Respuesta 1.";
	}

	/**
	 * Método para la extensión 2.
	 * @return Respuesta2.
	 */
	public String metodo2( )
	{
		return "Respuesta 2.";
	}

}