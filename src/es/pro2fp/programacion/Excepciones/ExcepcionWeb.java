package es.pro2fp.programacion.Excepciones;

/**
 * Excepcion que comprueba un parámetro de una direccion de correo. Si este es incorrecto,
 * saltará una excepción.
 * Se usa en la clase "usuario" y se elevará al programa principal.
 */
public class ExcepcionWeb extends Exception{
    /*
    Constructor de una excepción de Correo que, si no sigue la estructura correcta,
    lanza una excepción de tipo ExcepcionCorreo.

    @param msg
     */

    public ExcepcionWeb(String msg) {
        super(msg);
    }
}


/*
Este será el método de la excepción para copiar y pegar a donde se quiera

/**
 * Método que valida una dirección Web mediante un patrón. Si este no encaja con la
 * estructura predefinida, saltará una excepción
 * @param web
 * @return true si el Correo respeta el parámetro
 * @throws ExpecionWeb si no se respeta el parámetro

public static boolean comprobacionWeb (String web) throws ExcepcionWeb{

    Pattern p = Pattern.compile("[www][a-z, A-Z, 0-9]{1-99}[.com]");
	Matcher m = p.matcher(web);

	if (!m.matches()) {
		throw new ExcepcionCorreo("La dirección web introducida no sigue el parámetro correcto");
	} else {
		return true;
}

 */