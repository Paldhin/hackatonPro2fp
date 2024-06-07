package es.pro2fp.programacion.main;
import es.pro2fp.programacion.Utiles.Conexion;

public class main {
    public static void Main(String[] args) {
        Conexion con = new Conexion();
        con.getAllHoteles();
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
}
