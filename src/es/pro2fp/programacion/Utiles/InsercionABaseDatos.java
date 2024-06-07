import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.pro2fp.programacion.clases.Habitacion;
import es.pro2fp.programacion.clases.Hotel;

public class InsercionABaseDatos {
  
    private Connection con;
	
	public void Conexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Gestor_hoteles","fp","fp");
			System.out.println("Conexión establecida");
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}	
	}

    /**
     * Metodo que inserta un hotel en una base de datos salta una excepcion si hay algun error con las consultas SQL
     * @param hotel
     * @throws SQLException
     */
public void insertHotel(Hotel hotel) throws SQLException{
    ResultSet rs;
    PreparedStatement ps;

    //Añadimos la direccion del hotel a la tabla direccion
    try {
        //Insertamos la direccion del hotel en la tabla direccion
        ps = con.prepareStatement("INSERT INTO `Gestor_hoteles`.`Direcciones` (`Calle`, `Numero`, `Municipio`, `Pais`, `Codigo_Postal`, `Puerta`, `Ciudad`) VALUES (?, ?, ?, ?, ?, ?, ?);");
        ps.setString(1, hotel.getDireccion().getCalle());
        ps.setString(2, hotel.getDireccion().getNumero());
        ps.setString(3, hotel.getDireccion().getMunicipio());
        ps.setString(4, hotel.getDireccion().getPais());
        ps.setString(5, hotel.getDireccion().getCodigoPostal());
        ps.setString(6, hotel.getDireccion().getPuerta());
        ps.setString(7, hotel.getDireccion().getCiudad());
        rs = ps.executeQuery();
        int direccionHotel = rs.getInt("SELECT idDireccion FROM direcciones WHERE idDireccion = @@identity;");//Comprobar si funciona el @@Identity
        //Insercion del hotel en la tabla de hotel
        ps = con.prepareStatement("INSERT INTO `Gestor_hoteles`.`Hoteles` (`Direcciones_idDireccion`, `Nombre`, `Telefono_contacto`, `Email_contacto`, `Web`) VALUES (?, ?, ?, ?, ?);");
        ps.setInt(1,direccionHotel);
        ps.setString(2,hotel.getNombre());
        ps.setString(3,hotel.getTelefonoContacto());
        ps.setString(4, hotel.getEmailContacto());
        ps.setString(5, hotel.getWeb());
    } catch (Exception e) {
       System.err.println("Error: "+e);
    }
}

/**
 * Metodo que inserta una habitacion a la tabla habitaciones de SQL
 * @param habitacion
 * @throws SQLException
 */
public void insertHabitacion(Habitacion habitacion) throws SQLException{
    ResultSet rs;
    PreparedStatement ps;
    //Añadimos la habitacion a la tabla habitaciones
    try {
        ps = con.prepareStatement("INSERT INTO `Gestor_hoteles`.`Habitaciones` (`NumeroHabitacion`, `TipoHabitacion`, `Hoteles_idHotel`, `Borrada`, `Precio_habitacion_euros`) VALUES (?,?,?,?,?);");
        ps.setInt(1, habitacion.getNumeroHabitacion());
        ps.setString(2, habitacion.getTipoHabitacion());
        ps.setInt(3,habitacion.getHoteles_idHotel());
        ps.setBoolean(4, false);
        ps.setFloat(5,habitacion.getPrecio_habitacion_euros());
    } catch (Exception e) {
        System.err.println("Error: "+e);
    }


}
}
