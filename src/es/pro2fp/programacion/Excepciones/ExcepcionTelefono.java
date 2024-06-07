package es.pro2fp.programacion.Excepciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Excepcipon que comprueba un parametro de un telefono si este es incorrecto salta una excepcion
 * Se usa en la clase usuario y se elevara a la programa principal
 */
public class ExcepcionTelefono extends Exception{

    /*
     * Constructor de una excepcion de Telefono que si no sige el parametro correcto
	 * lanza una excepcion de tipo ExcepcionTelefono
     *
     * @param msg
     */
    public ExcepcionTelefono(String msg){
        super(msg);
    }

}

/*
 * Este sera el metodo de la excepcion para copiar y pegar a donde se quiera
 * 
 * De aqui hacia abajo sera lo que hay que copiar
/**
 * Metodo que valida un telefono mediante un parametro si este no sigue el parametro 
 * salta una excepcion
 * @param telefono
 * @return true si el telefono respet el parametro 
 * @throws ExcepcionTelefono si no se respeta el parametro
 
public static boolean comprobacionTelefono (String telefono) throws ExcepcionTelefono{
    
    Pattern p = Pattern.compile("[6-7]{1},[0-9]{7}");
	Matcher m = p.matcher(telefono);

	if (!m.matches()) {
		throw new ExcepcionTelefono("El telefono no sigue el parametro correcto");
	} else {
		return true;
	}

 }
 */
