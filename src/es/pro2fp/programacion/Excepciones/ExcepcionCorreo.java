package es.pro2fp.programacion.Excepciones;

/**
 * Excepcion que comprueba un parámetro de una direccion de correo. Si este es incorrecto,
 * saltará una excepción.
 * Se usa en la clase "usuario" y se elevará al programa principal.
 */
public class ExcepcionCorreo extends Exception{
    /*
    Constructor de una excepción de Correo que, si no sigue la estructura correcta,
    lanza una excepción de tipo ExcepcionCorreo.

    @param msg
     */

    public ExcepcionCorreo(String msg) {
        super(msg);
    }
}


/*
Este será el método de la excepción para coìar y pegar a donde se quiera

/**
 * Método que valida un Correo mediante un patrón. Si este no encaja con la
 * estructura predefinida, saltará una excepción
 * @param correo
 * @return true si el Correo respeta el parámetro
 * @throws ExpecionTelefono si no se respeta el parámetro

public static boolean comprobacionCorreo (String correo) throws ExcepcionCorreo{

    Pattern p = Pattern.compile("[a-z, 0-9, A-Z] {1-30} [@gmail.com]");
	Matcher m = p.matcher(correo);

	if (!m.matches()) {
		throw new ExcepcionCorreo("La dirección de corre introducida no sigue el parametro correcto");
	} else {
		return true;
}

 */

