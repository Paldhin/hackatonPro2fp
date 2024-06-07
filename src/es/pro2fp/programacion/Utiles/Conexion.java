package es.pro2fp.programacion.Utiles;

import es.pro2fp.programacion.clases.Direccion;
import es.pro2fp.programacion.clases.Habitacion;
import es.pro2fp.programacion.clases.Usuario;
import es.pro2fp.programacion.clases.Hotel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
			ps = con.prepareStatement("SELECT * FROM Hoteles JOIN Direcciones ON Hoteles.Direcciones_idDireccion = Direcciones.idDireccion");
			rs = ps.executeQuery();
			
			int id;
			int id_direccion;
			String nombre;
			String email_contacto;
			String telefono_contacto;
			String web;
			ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
			Direccion direccion;

			
			while (rs.next()) {
				id = rs.getInt("idHotel");
				id_direccion = rs.getInt("Direcciones_idDireccion");
				nombre = rs.getString("Nombre");
				email_contacto = rs.getString("Email_contacto");
				telefono_contacto = rs.getString("Telefono_contacto");
				web = rs.getString("Web");
				System.out.println(id+" "+id_direccion+" "+nombre+" "+email_contacto+" "+telefono_contacto+" "+web);
				int idDireccion = rs.getInt("idDireccion");
				String calle = rs.getString("Calle");
				String numero = rs.getString("Numero");
				String puerta = rs.getString("Puerta");
				String codigo_postal = rs.getString("Codigo_postal");
				String ciudad = rs.getString("Ciudad");
				String provincia = rs.getString("Provincia");
				String municipio = rs.getString("Municipio");
				String pais = rs.getString("Pais");
				System.out.println(idDireccion+" "+calle+" "+numero+" "+puerta+" "+codigo_postal+" "+ciudad+" "+municipio+" "+pais);
				direccion = new Direccion(idDireccion, calle, numero, puerta, provincia, ciudad, municipio, codigo_postal, pais);
				hoteles.add(new Hotel(id, direccion, nombre));
			}
			return hoteles;
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}
		return null;
	}
	
	public ArrayList<Habitacion> getAllHabitacionesDisponibles(int id_hotel,Date fecha_entrada, Date fecha_salida){
		ResultSet rs;
		PreparedStatement ps;
		try {
			if (id_hotel != -1){
				String query = """
						SELECT * FROM Habitaciones 
						LEFT JOIN Reservas ON Habitaciones.idHabitacion = Reservas.Habitaciones_idHabitacion
						WHERE Habitaciones.Hoteles_idHotel = ? 
						AND ((Reservas.Fecha_entrada > ? OR Reservas.Fecha_salida < ?
						AND Reservas.Cancelada = 0 ) OR Reservas.idReserva IS NULL)	
				""";
				ps = con.prepareStatement(query);
				ps.setInt(1, id_hotel);
				ps.setDate(2, new java.sql.Date(fecha_salida.getTime()));
				ps.setDate(3, new java.sql.Date(fecha_entrada.getTime()));
			}else {
				String query = """
						SELECT * FROM Habitaciones 
						LEFT JOIN Reservas ON Habitaciones.idHabitacion = Reservas.Habitaciones_idHabitacion
						WHERE ((Reservas.Fecha_entrada > ? OR Reservas.Fecha_salida < ?
						AND Reservas.Cancelada = 0) OR Reservas.idReserva IS NULL)	
				""";
				ps = con.prepareStatement(query);
				ps.setDate(1, new java.sql.Date(fecha_salida.getTime()));
				ps.setDate(2, new java.sql.Date(fecha_entrada.getTime()));
			}
			rs = ps.executeQuery();
			
			int id;
			int id_hotels;
			String tipo;
			float precio;
			int numero;
			ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
			
			while (rs.next()) {
				id = rs.getInt("idHabitacion");
				id_hotels = rs.getInt("Hoteles_idHotel");
				tipo = rs.getString("TipoHabitacion");
				precio = rs.getFloat("Precio_habitacion_euros");
				numero = rs.getInt("NumeroHabitacion");
				System.out.println(id+" "+id_hotel+" "+tipo+" "+precio);
				habitaciones.add(new Habitacion(id, numero,tipo, precio,id_hotels));
			}
			return habitaciones;
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}
		return null;
	}

	public void insertarUsuario(Usuario usuario) {
		try {
			// Insertar direccion
			PreparedStatement ps = con.prepareStatement("INSERT INTO Direcciones (Calle, Numero, Municipio, Pais, Codigo_Postal, Puerta, Ciudad) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, usuario.getDireccion().getCalle());
			ps.setString(2, usuario.getDireccion().getNumero());
			ps.setString(3, usuario.getDireccion().getMunicipio());
			ps.setString(4, usuario.getDireccion().getPais());
			ps.setString(5, usuario.getDireccion().getCodigoPostal());
			ps.setString(6, usuario.getDireccion().getPuerta());
			ps.setString(7, usuario.getDireccion().getCiudad());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int idDireccion = rs.getInt(1);
			ps = con.prepareStatement("INSERT INTO Usuario (Direcciones_idDireccion, Administrador,Nombre_usuario, Password,Nombre,Apellido1,Apellido2, email, telefono) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, idDireccion);
			ps.setBoolean(2, usuario.isAdministrador());
			ps.setString(3, usuario.getNombreUsuario());
			ps.setString(4, usuario.getPassword());
			ps.setString(5, usuario.getNombre());
			ps.setString(6, usuario.getApellido1());
			ps.setString(7, usuario.getApellido2());
			ps.setString(8, usuario.getCorreoElectronico());
			ps.setString(9, usuario.getTelefono());
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}
	}

	public void hacerReserva(Usuario usuario, Habitacion habitacion, Date fecha_entrada, Date fecha_salida) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO Reservas (Clientes_idCliente, Habitaciones_idHabitacion, Cancelada, Momento_entrada, Momento_salida) VALUES (?,?,?,?,?)");
			ps.setInt(1, usuario.getIdUsuario());
			ps.setInt(2, habitacion.getId_habitacion());
			ps.setBoolean(3, false);
			ps.setDate(4, new java.sql.Date(fecha_entrada.getTime()));
			ps.setDate(5, new java.sql.Date(fecha_salida.getTime()));
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}
	}

	public void cancelarReserva(int id_reserva) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE Reservas SET Cancelada = 1 WHERE idReserva = ?");
			ps.setInt(1, id_reserva);
			ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}
	}

	public Usuario buscarUsuario(String nombre_usuario, String password) {
		ResultSet rs;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM Usuario WHERE Nombre_usuario = ? AND Password = ?");
			ps.setString(1, nombre_usuario);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("idUsuario");
				int id_direccion = rs.getInt("Direcciones_idDireccion");
				boolean administrador = rs.getBoolean("Administrador");
				String nombre = rs.getString("Nombre");
				String apellido1 = rs.getString("Apellido1");
				String apellido2 = rs.getString("Apellido2");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				String dni = rs.getString("dni");
				Direccion direccion = getDireccion(id_direccion);
				return new Usuario(nombre,apellido1,apellido2,telefono,email,dni,direccion,administrador,id,password);
			}
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}
		return null;
	}

	public Direccion getDireccion(int id_direccion) {
		ResultSet rs;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM Direcciones WHERE idDireccion = ?");
			ps.setInt(1, id_direccion);
			rs = ps.executeQuery();
			while (rs.next()) {
				String calle = rs.getString("Calle");
				String numero = rs.getString("Numero");
				String puerta = rs.getString("Puerta");
				String codigo_postal = rs.getString("Codigo_postal");
				String ciudad = rs.getString("Ciudad");
				String provincia = rs.getString("Provincia");
				String municipio = rs.getString("Municipio");
				String pais = rs.getString("Pais");
				return new Direccion(id_direccion, calle, numero, puerta, provincia, ciudad, municipio, codigo_postal, pais);
			}
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}
		return null;
	}
}
