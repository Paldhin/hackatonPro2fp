package es.pro2fp.programacion.Utiles;

import es.pro2fp.programacion.clases.Direccion;
import es.pro2fp.programacion.clases.Usuario;
import es.pro2fp.programacion.clases.Hotel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {
	private Connection con;
	
	public Conexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Gestor_hoteles","fp","fp");
			System.out.println("Conexión establecida");
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}	
	}
	
	
	public ArrayList<Hotel> getAllHoteles() {
		ResultSet rs;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM Hoteles");
			rs = ps.executeQuery();
			
			int id;
			int id_direccion;
			String nombre;
			String email_contacto;
			String telefono_contacto;
			String web;
			ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
			
			while (rs.next()) {
				id = rs.getInt("idHotel");
				id_direccion = rs.getInt("Direcciones_idDireccion");
				nombre = rs.getString("Nombre");
				email_contacto = rs.getString("Email_contacto");
				telefono_contacto = rs.getString("Telefono_contacto");
				web = rs.getString("Web");
				// hoteles.add(new Hotel(id, id_direccion, nombre, email_contacto, telefono_contacto, web));
			}
			return hoteles;
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}
		return null;
	}
	
}
