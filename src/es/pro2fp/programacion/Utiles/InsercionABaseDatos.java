import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public void insertHotel(Hotel hotel) throws SQLException{
    ResultSet rs;
    PreparedStatement ps;

    //Añadimos la direccion del hotel a la tabla direccion
    try {
        ps = con.prepareStatement("INSERT INTO `Gestor_hoteles`.`Direcciones` (`Calle`, `Numero`, `Municipio`, `Pais`, `Codigo_Postal`, `Puerta`, `Ciudad`) VALUES (?, ?, ?, ?, ?, ?, ?);");
        ps.setString(1, hotel.getDireccion().getCalle());
        ps.setString(2, hotel.getDireccion().getNumero());
        ps.setString(3, hotel.getDireccion().getMunicipio());
        ps.setString(4, hotel.getDireccion().getPais);
        ps.setString(5, hotel.getDireccion().getCodigoPostal());
        ps.setString(6, hotel.getDireccion().getPuerta());
        ps.setString(7, hotel.getDireccion().getCiudad());
    } catch (Exception e) {
       System.err.println("Error: "+e);
    }
    
    //Recogemos la clave foranea de la direccion que acabamos de añadir a la tabla direccion
    try {
        int direccionHotel = rs.getInt("SELECT idDireccion FROM direcciones WHERE idDireccion = @@identity;");//Comprobar si funciona el @@Identity
    } catch (Exception e) {
        System.err.println("Error: "+e);
    }
    
    //Añadimos el hotel 


}




}
