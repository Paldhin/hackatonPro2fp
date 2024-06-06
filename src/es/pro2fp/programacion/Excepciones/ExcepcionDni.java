package es.pro2fp.programacion.Excepciones;
/**
 * Excepcio que comprueba el patron de un dni si este es incorrecto salta una excepcion
 * Se usa en la clase Usuario y se elevara al programa principal
 */
public class ExcepcionDni extends Exception {

	/**
	 * Constructor de una excepcion de dni que si no sige el parametro correcto
	 * lanza un aexcepcion de tipo ExcepcionDni
	 * 
	 * @param msg
	 */
	public ExcepcionDni(String msg) {
		super(msg);
	}

}
/*
 * Este sera el metodo de la excepcion para copiar y pegar a donde se quiera
 * 
 * De aqui hacia abajo sera lo que hay que copiar
/**
 * Metodo que valida el dni mediante un patron si no se respeta lanza una
 * excepcion
 * 
 * @param dni a validar
 * @return true si el dni tiene el paron correcto
 * @return da una ExcepcionDni
 * @throws ExcecpionDNI si no sigue el parametro adecuado
 
public static boolean validarDni(String dni) throws ExcepcionDni {

	Pattern p = Pattern.compile("[0-9]{8}[a-zA-Z]{1}");
	Matcher m = p.matcher(dni);

	if (!m.matches()) {
		throw new ExcepcionDni("El DNI no sigue el parametro correcto);
	} else {
		return true;
	}
}
*/

