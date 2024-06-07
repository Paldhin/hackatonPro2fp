package es.pro2fp.programacion.main;
import es.pro2fp.programacion.Excepciones.ExcepcionCodPostal;
import es.pro2fp.programacion.Excepciones.ExcepcionDni;
import es.pro2fp.programacion.Excepciones.ExcepcionTelefono;
import es.pro2fp.programacion.Utiles.Conexion;
import es.pro2fp.programacion.clases.Direccion;
import es.pro2fp.programacion.clases.Usuario;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainDiego {
    static Conexion con;
    public static void main(String[] args) {
        con = new Conexion();

        //Inicio del Main
        char gestionMenu = 0;
        Scanner sc = new Scanner(System.in);
        Usuario usuario = null;

        //Primera parte del programa: login y register
        do {
            menuUsuario1();
            gestionMenu = sc.next().charAt(0);
            switch (gestionMenu) {
                case '1':
                    try {
                        usuario = CrearUsuario();
                        con.insertarUsuario(usuario);
                    } catch (ExcepcionTelefono | ExcepcionDni | ExcepcionCodPostal e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case '2':
                    usuario = IniciarSesion();
                    break;
                case '0':
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("El valor introducido no es válido. Introduzca un valor entre '1', '2', y '0'.");
                    break;
            }
        } while (gestionMenu != '1' && gestionMenu != '2' && gestionMenu != '0');

        if (gestionMenu == 0) {
            do {
                if (usuario.isAdministrador())
                    gestionMenu = sc.next().charAt(0);
                switch (gestionMenu) {
                    case '1':
                }
            } while (gestionMenu != '0');
        }



    }
    public static void menuUsuario1() {
        System.out.println("""
                \nBIENVENIDO A HOTEL TRIVAGO
                ----------------------
                1.- Registrarse
                2.- Inicio de Sesión
                0.- Salir del programa
                ----------------------""");
    }

    public static void menuUsuario2Cliente() {
        System.out.println("""
                ----------------------
                1.- Reservar Habitación
                2.- Cancelar Reserva
                3.- Consultar Reserva
                0.- Salir del programa
                ----------------------""");
    }
    public static void menuUsuario3Administrador(){
        System.out.println("""
                ----------------------
                1.- Gestionar Reservas
                2.- Gestionar Habitaciones
                0.- Salir del programa
                ----------------------""");
    }

    public static Usuario IniciarSesion() {
        Usuario usuario = null;
        try {
            System.out.println("Introduce tu nombre de Usuario:");
            String nombre_usuario = GetString();
            System.out.println("Introduce tu contraseña:");
            String password = GetString();
            usuario = con.buscarUsuario(nombre_usuario, password);
            if (usuario == null) {
                System.out.println("Usuario o contraseña incorrectos.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public static Usuario CrearUsuario() throws ExcepcionTelefono, ExcepcionDni, ExcepcionCodPostal {
        System.out.println("Introduce tu nombre:");
        String nombre = GetString();

        System.out.println("Introduce tu nombre usuario:");
        String nombre_usuario = GetString();

        System.out.println("Introduce tu primer apellido:");
        String apellido1 = GetString();

        System.out.println("Introduce tu segundo apellido:");
        String apellido2 = GetString();

        System.out.println("Introduce un numero de teléfono:");
        String telefono = GetTelefono();

        System.out.println("Introduce un correo electrónico:");
        String email = GetString();

        System.out.println("Introduce tu DNI:");
        String dni = GetDNI();

        System.out.println("¿Eres administrador? (S/N)");
        boolean administrador = false;
        if (GetString().equalsIgnoreCase("S")) administrador = true;

        System.out.println("Introduce una contraseña:");
        String password = GetString();

        // Creamos los campos necesarios para la direccion
        System.out.println("Introduce tu calle:");
        String calle = GetString();

        System.out.println("Introduce tu número:");
        String numero = GetString();

        System.out.println("Introduce tu puerta:");
        String puerta = GetString();

        System.out.println("Introduce tu ciudad:");
        String ciudad = GetString();

        System.out.println("Introduce tu municipio:");
        String municipio = GetString();

        System.out.println("Introduce tu código postal:");
        String codigoPostal = GetCodPostal();

        System.out.println("Introduce tu país:");
        String pais = GetString();

        Direccion direccion = new Direccion(-1, calle,numero,puerta,ciudad,municipio,codigoPostal,pais);
        Usuario usuarioTMP = new Usuario(nombre_usuario,nombre, apellido1, apellido2, telefono,email,dni,direccion,administrador,-1,password);

        return usuarioTMP;
    }

    public static String GetString(){
        String tmp;
        do {
            Scanner sc = new Scanner(System.in);
            tmp = sc.nextLine();
            if (tmp.trim().isEmpty()) {
                System.out.println("Este campo no puede estar vacío.");
            }
        }while (tmp.trim().isEmpty());
        return tmp;
    }

    public static String GetCodPostal () throws ExcepcionCodPostal {
        String codPostal = GetString();
        boolean bool = ComprobacionCodPostal(codPostal);
        if (!bool) System.out.println("El Código Postal itnroducido no es válido.");
        return codPostal;
    }

    public static String GetTelefono () throws ExcepcionTelefono {
        String tlf = GetString();
        boolean bool = ComprobacionTelefono(tlf);
        if (!bool) System.out.println("El teléfono introducido no existe.");
        return tlf;
    }

    public static String GetDNI () throws ExcepcionDni {
        String dni = GetString();
        boolean bool = ComprobacionDNI(dni);
        if (!bool) System.out.println("El DNI introducido no existe o no es correcto.");
        return dni;
    }

    public static boolean ComprobacionCodPostal(String codPostal) throws ExcepcionCodPostal{
        Pattern p = Pattern.compile("[0-5][1-9]{3}[0-9]");
        Matcher m = p.matcher(codPostal);
        if(!m.matches()){
            throw new ExcepcionCodPostal("El codigo postal no sigue el parametro correcto");
        }else{
            return true;
        }
    }

    public static boolean ComprobacionDNI(String dni) throws ExcepcionDni {
        Pattern p = Pattern.compile("[0-9]{8}[a-zA-Z]{1}");
        Matcher m = p.matcher(dni);
        if (!m.matches()) {
            throw new ExcepcionDni("El DNI no sigue el parámetro correcto");
        } else {
            return true;
        }
    }

    public static boolean ComprobacionTelefono(String telefono) throws ExcepcionTelefono {
        Pattern p = Pattern.compile("[6-7]{1}[0-9]{8}");
        Matcher m = p.matcher(telefono);
        System.out.println(telefono+"----");
        if (!m.matches()) {
            throw new ExcepcionTelefono("El telefono no sigue el parametro correcto");
        } else {
            return true;
        }
    }

}










