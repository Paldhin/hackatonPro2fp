package es.pro2fp.programacion.Excepciones;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Excepcion que comprueba el patron de un String para que concuerde con el de un codigo postal
 * Esta excepcion se usara en el constructor de Direccion y posiblemente se elevara la excepcion a la clase principal
 */
public class ExcepcionCodPostal extends Exception{
    /**
     * Constructor para la comprobacion del parametro de un codigo postal
     * Si este no sigue un parametro especifico salta una excepcion 
     * @param msg
     */
    public ExcepcionCodPostal(String msg){
        super(msg);
    }
}

/*
 * 
 * Este sera el metodo de la excepcion para copiar y pegar a donde se quiera
 * 
 * De aqui hacia abajo sera lo que hay que copiar
 * /**
 * Metodo que valida el codigo postal mediante un patron si este no sige el patron
 * salta una excepcion
 * @param codPostal
 * @return true si el codigo postal tiene el patron correcto
 * @throws ExcepcionCodPostal
public static boolean validarCodPostal(String codPostal) throws ExcepcionCodPostal{

    Pattern p = Pattern.compile("[0-9]{5}");
    Matcher m = p.matcher(codPostal);

    if(!m.matches()){
        throw new ExcepcionCodPostal("El codigo postal no es correcto");
    }else{
        return true;
    }

}
 */











