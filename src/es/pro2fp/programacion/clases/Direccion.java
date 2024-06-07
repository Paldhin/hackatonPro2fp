package es.pro2fp.programacion.clases;
/**
 * Esta es la clase Direccion, clase que tiene unos atributos definidos y un unico constructor
 * 
 * Como atributos la clase tiene:
 * 
 * id_direccion que es un identificador unico para cada direccion de cada usuario.
 * calle que es la calle donde reside el usuario a tratar.
 * numero que es el numero de la calle de la residencia.
 * puerta que es el numero de la casa en caso de una casa o el numero y la letra en caso de un piso.
 * provincia que es la provincia donde esta situada la residencia.
 * ciudad que es la ciudad donde esta la provincia y, evidentemente, la residencia.
 * municipio que es el municipio donde se encuentra la residencia.
 * codigoPostal que es el codigo postal del municipio anteriormente mencionado.
 * pais que es el pais donde se encuentra la ciudad de residencia del usuario.
 */
public class Direccion {

    private int id_direccion;
    private String calle;
    private String numero;
    private String puerta;
    private String provincia;
    private String ciudad;
    private String municipio;
    private String codigoPostal;
    private String pais;
/**
 * Constructor de la clase Direccion que recibe como parametros los siguientes atributos y posteriormente 
 * los iguala a los atributos anteriormente mencionados. 
 * 
 * Todos los parametros siguientes coinciden en nombre y definicion con los atributos de la definicion de la clase:
 * 
 * @param id_direccion
 * @param calle
 * @param numero
 * @param puerta
 * @param provincia
 * @param ciudad
 * @param municipio
 * @param codigoPostal
 * @param pais
 */
    public Direccion (int id_direccion, String calle, String numero, String puerta, String provincia, String ciudad, String municipio, String codigoPostal, String pais){
        this.id_direccion = id_direccion;
        this.calle = calle;
        this.numero = numero;
        this.puerta = puerta;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }
    /**
     * Metodo getId_Direccion que devuelve un dato de tipo int 
     * 
     * @return id_direccion que es un atributo de la clase Direccion, identificador unico de cada direccion creada.
     */
    public int getId_Direccion() {
        return id_direccion;
    }
    /**
     * Metodo que recibe como parametro un int y lo iguala al atributo id_direccion de la clase Direccion
     * 
     * @param id_direccion String que se iguala al atributo de la clase Direccion
     */
    public void setId_Direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }
    /**
     * Metodo getCalle que devuelve un dato de tipo String
     * 
     * @return calle que es un atributo de la clase Direccion, que es la calle de la direccion del usuario
     */
    public String getCalle() {
        return calle;
    }
    /**
     * Metodo que recibe como parametro un String y lo iguala al atributo calle de la clase Direccion
     * 
     * @param calle String que se iguala al atributo de la clase Direccion
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }
    /**
     * Metodo getNumero que devuelve un dato de tipo String
     * 
     * @return numero que es un atributo de la clase Direccion, que es el numero de la calle de la direccion del usuario 
     */
    public String getNumero() {
        return numero;
    }
    /**
     * Metodo que recibe como parametro un String y lo iguala al atributo numero de la clase Direccion
     * 
     * @param numero String que se iguala al atributo de la clase Direccion
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    /**
     * Metodo getPuerta que devuelve un dato de tipo String
     * 
     * @return puerta que es un atributo de la clase Direccion, que es la puerta o piso de la direccion del usuario
     */
    public String getPuerta() {
        return puerta;
    }
    /**
     * Metodo que recibe como parametro un String y lo iguala al atributo puerta de la clase Direccion
     * 
     * @param puerta String que se iguala al atributo de la clase Direccion
     */
    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }
    /**
     * Metodo getProvincia que devuelve un dato de tipo String
     * 
     * @return provincia que es un atributo de la clase Direccion, que es la provincia donde esta la direccion del usuario
     */
    public String getProvincia() {
        return provincia;
    }
    /**
     * Metodo que recibe como parametro un String y lo iguala al atributo provincia de la clase Direccion
     * 
     * @param provincia String que se iguala al atributo de la clase Direccion
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    /**
     * Metodo getCiudad que devuelve un dato de tipo String
     * 
     * @return ciudad que es un atributo de la clase Direccion, que es la ciudad donde esta direccion del usuario
     */
    public String getCiudad() {
        return ciudad;
    }
    /**
     * Metodo que recibe como parametro un String y lo iguala al atributo ciudad de la clase Direccion
     * 
     * @param ciudad String que se iguala al atributo de la clase Direccion
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * Metodo getMunicipio que devuelve un dato de tipo String
     * 
     * @return municipio que es un atributo de la clase Direccion, que es el municipio donde esta la direccion del usuario
     */
    public String getMunicipio() {
        return municipio;
    }
    /**
     * Metodo que recibe como parametro un String y lo iguala al atributo municipio de la clase Direccion
     * 
     * @param municipio String que se iguala al atributo de la clase Direccion
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    /**
     * Metodo getcodigoPostal que devuelve un dato de tipo String
     * 
     * @return codigoPostal que es un atributo de la clase Direccion, que es el codigo postal del municpio donde esta la direccion del usuario
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }
    /**
     * Metodo que recibe como parametro un String y lo iguala al atributo codigoPostal de la clase Direccion
     * 
     * @param codigoPostal String que se iguala al atributo de la clase Direccion
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    /**
     * Metodo que retorna un dato tipo String
     * 
     * @return pais que es el pais de residencia del usuario
     */
    public String getPais() {
        return pais;
    }
    /**
     * Metodo que recibe como parametro de entrada un String y lo iguala al atributo pais de la clase Direccion 
     * 
     * @param pais String que se iguala al atributo de la clase Direccion
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    /**
     * Metodo toString de la clase Direccion
     * 
     * @return devuelve todo los atributos de la clase Direccion, en definitiva devuelve la direccion del usuario al completo.
     */
    @Override
    public String toString (){
        return "\n----------------------" + 
                "\nDireccion: " + 
                "\n----------------------" + 
        		"\nCalle: " + this.getCalle() + "\nNúmero: " + this.getNumero() + 
        		"\nPuerta: " + this.getPuerta() + "\nPais: " + this.getPais() + 
                "\nProvincia: " + this.getProvincia() + "\nCiudad: " + this.getCiudad() + 
                "\nMunicipio: " + this.getMunicipio() + "\nCódigo Postal: " + this.getCodigoPostal();
    }
}
