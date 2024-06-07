package es.pro2fp.programacion.main;
import es.pro2fp.programacion.Excepciones.ExcepcionTelefono;
import es.pro2fp.programacion.Utiles.Conexion;
import es.pro2fp.programacion.clases.Usuario;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.getAllHoteles();

        //Inicio del Main
        char gestionMenu = 0;
        Scanner sc = new Scanner(System.in);

        //Primera parte del programa: login y register
        switch (gestionMenu) {
            case '1':
        }

        do {
            gestionMenu = sc.next().charAt(0);
            switch (gestionMenu) {
                case '1':
            }
        } while (gestionMenu != '0');


    }
    public static void menuUsuario1() {
        System.out.println("""
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

    public static Usuario CrearUsuario() {
        System.out.println("Introduce tu nombre:");
        String nombre = GetString();
        System.out.println("Introduce tu primer apellido:");
        String apellido1 = GetString();
        System.out.println("Introduce tu segundo apellido:");
        String apellido2 = GetString();
        System.out.println("Introduce un numero de teléfono:");
        String telefono =
        Usuario usuarioTMP = new Usuario(nombre, apellido1, apellido2, );
        return usuarioTMP;
    }

    public static String GetString(){
        String tmp;
        do {
            Scanner sc = new Scanner(System.in);
            tmp = sc.nextLine();
            if (!tmp.trim().isEmpty()) {
            } else System.out.println("Este campo no puede estar vacío.");
        }while (tmp.trim().isEmpty());
        return tmp;
    }

    public static String GetTelefono() throws ExcepcionTelefono {
        String tmp;
        do {
            Scanner sc = new Scanner(System.in);
            tmp = sc.nextLine();
            if (!tmp.trim().isEmpty()) {
            } else System.out.println("Este campo no puede estar vacío.");
        }while (tmp.trim().isEmpty());
        return tmp;
    }
}










