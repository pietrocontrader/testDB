package testdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TestDB {
	public static void main(String[] args) {
		try {
			TestDB.query();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void query() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/dbprova";
			
			Connection con = DriverManager.getConnection(url, "admin", "root");
			String query_select = "SELECT* FROM docente WHERE cognome = ?";
			
			PreparedStatement cmd = con.prepareStatement(query_select) ;
			cmd.setString(1,"nardi");
			
			ResultSet risultato = cmd.executeQuery();
			boolean trovati = risultato.next();
			
			while(trovati) {
				int idd = risultato.getInt("id_docente");
				System.out.println(idd);
				System.out.println(risultato.getString("nome"));
				System.out.println(risultato.getString("cognome"));
				trovati = risultato.next();
				
			}
			cmd.close();
			con.close();
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
