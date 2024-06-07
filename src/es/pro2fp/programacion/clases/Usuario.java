package es.pro2fp.programacion.clases;

public class Usuario {
/**
 * Esta es la clase Usuario, clase que tiene unos atributos definidos y un unico constructor
 *
 * Como atributos la clase tiene:
 *
 * "id_usuario", que es un identificador único para cada usuario creado.
 * "nombre" que es el nombre del usuario.
 * "apellido1" y "apellido2" que son los apellidos del usuario.
 * "telefono" que es el número de contacto principal del usuario.
 * "correoElectronico" que es la dirección de correo con la que se relaciona la cuenta del usuario.
 * "dni" que es el número nacional de identificación, uno para cada usuario.
 * "direccion" que es un objeto de tipo Direccion que almacena datos de la residencia del usuario.
 * "administrador" que es un booleano que determina si el usuario es Cliente (boolean = False) o Administrador (boolean = True).
 * "password" que es la contraseña encriptada de acceso de la cuenta del usuario.
 */
	private int id_usuario;
	private String nombreUsuario;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String telefono;
	private String correoElectronico;
	private String dni;
	private Direccion direccion;
	private String password;
	private boolean administrador;
/**
 * Constructor de la clase Usuario que recibe como parametros los siguientes atributos y posteriormente 
 * los iguala a los atributos anteriormente mencionados. 
 * 
 * Todos los parametros siguientes coinciden en nombre y definicion con los atributos de la definicion de la clase:
 * 
 * @param nombre
 * @param apellido1
 * @param apellido2
 * @param telefono
 * @param correoElectronico
 * @param dni
 * @param direccion
 * @param administrador
 * @param id_usuario
 * @param password
 */	
	public Usuario(String nombreUsuario, String nombre, String apellido1, String apellido2, String telefono, String correoElectronico,
                   String dni, Direccion direccion, boolean administrador, int id_usuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.dni = dni;
		this.direccion = direccion;
		this.administrador = administrador;
		this.id_usuario = id_usuario;
		this.password = password;
	}


	public String getNombreUsuario(){return nombreUsuario;}
	/**
	 * Metodo getApellido2 que devuelve un dato de tipo String
	 * 
	 * @return getApellido2 que es el segundo apellido del usuario, un atributo de tipo String
	 */
	public String getApellido2() {
		return apellido2;
	}
	/**
	 * Metodo que recibe como parametro de entrada un String y lo iguala al atributo apellido2 de la clase Usuario
	 * 
	 * @param apellido2 String como parametro de entrada
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	/**
	 * Metodo getTelefono que devuelve un dato tipo String
	 *
	 * @return getTelefono que es el telefono del usuario, un atributo de tipo String 
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * Metodo que recibe como parametro de entrada un String y lo iguala al atributo telefono de la clase Usuario
	 *
	 * @param telefono que es el telefono del usuario, un atributo de tipo String
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * Metodo que devuelve un objeto tipo String 
	 *
	 * @return getCorreoElectronico que es el correo electronico del usuario 
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	/**
	 * Metodo que recibe como parametro un tipo String y lo iguala al atributo de la clase Usuario correoElectronico
	 *
	 * @param correoElectronico dato de tipo String que se iguala al atributo correoElectronico
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	/**
	 * Metodo que retorna 'True' si el usuario a tratar es administrador o 'False' si el usuario no es administrador
	 *
	 * @return isAdministrador dato de tipo boolean, devuelve 'True' o 'False'
	 */
	public boolean isAdministrador() {
		return administrador;
	}
	/**
	 * Metodo que recibe como parametro de entrada un dato de tipo boolean, 'True' o 'False' y se iguala al atributo administrador
	 *
	 * @param administrador parametro de entrada de tipo boolean
	 */
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	/**
	 * Metodo que retorna un atributo nombre de tipo String 
	 * 
	 * @return nombre que es el nombre del cliente 
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que recibe un tipo String como parametro de entrada y lo iguala al atributo nombre de la clase Usuario
	 * 
	 * @param nombre que es un String que se iguala al atributo nombre de la clase Usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que retorna un String con el primer apellido del usuario
	 * 
	 * @return apellido1 que es el primer apellido del usuario
	 */
	public String getApellido1() {
		return apellido1;
	}
	/**
	 * Metodo recibe como parametro de entrada un String y lo iguala al atributo apellido1 de la clase Usuario
	 * 
	 * @param apellido1 que es el primer apellido del usuario
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	/**
	 * Metodo que retorna el dni del usuario como dato de tipo String
	 * 
	 * @return dni que es el dni del usuario
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Metodo que recibe como parametro de entrada un dato de tipo String y lo iguala al atributo dni de la clase Usuario
	 * 
	 * @param dni que es el parametro String de entrada igualado al atributo dni de la clase Usuario
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * Metodo que retorna la direccion del usuario 
	 * 
	 * @return direccion que es la direccion del usuario
	 */
	public Direccion getDireccion() {
		return direccion;
	}
	/**
	 * Metood que recibe como parametro de entrada un objeto de tipo Direccion y lo iguala al atributo direccion de la clase Usuario
	 * 
	 * @param direccion que es el objeto de tipo Direccion que se iguala al atributo direccion de la clase Usuario
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 * Método que retorna el DNI del usuario
	 *
	 * @return getDni
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metodo toString de la clase Usuario
	 * 
	 * @return devuelve todo los atributos de la clase Usuario, en definitiva devuelve todos los datos de un cliente.
	 */
	@Override
	public String toString() {
		if (this.isAdministrador()) {
			return "\n---------------------" +
					"\nUsuario administrador: " +
					"\n---------------------" +
					"\nNombre: " + this.getNombre() +
					"\nApellido 1: " + this.getApellido1() +
					"\nApellido 2: " + this.getApellido2() +
					"\nTelefono: " + this.getTelefono() +
					"\nCorreo Electronico: " + this.getCorreoElectronico() +
					"\nDni: " + this.getDni() +
					"\nAdministrador" +
					"\n--------------------" +
					"\nDireccion del integrante del equipo: " + direccion.toString();
		} else {
			return "\n---------------------" +
					"\nUsuario: " + 
					"\n---------------------" +
					"\nNombre: " + this.getNombre() +
					"\nApellido 1: " + this.getApellido1() +
					"\nApellido 2: " + this.getApellido2() +
					"\nTelefono: " + this.getTelefono() +
					"\nCorreo Electronico: " + this.getCorreoElectronico() +
					"\nDni: " + this.getDni() +
					"\nUsuario" +
					"\n--------------------" +
					"\nDireccion del Usuario: " + direccion.toString();
		}
	}
}
