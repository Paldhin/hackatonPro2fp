
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
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","password");
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}	
	}
	
	
	public ArrayList<Habitacion> getAllHabitaciones() {
		ResultSet rs;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM HABITACIONES WHERE IDHABITA=? and fecha=?");
			ps.setInt(1, 7);
			ps.setDate(2, "");
			rs = ps.executeQuery();
			
			int idHab;
			while (rs.next()) {
				idHab = rs.getInt("idHabitacion");
				
			}
			//rs = ps.execute("select * from hoteles");
			
			//rs=st.executeQuery("Select")
		} catch (Exception e) {
			
		}
	}
	
	
}
