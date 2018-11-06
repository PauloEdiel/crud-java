package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {
	
	public static Connection getConexao() {
		String banco = "jdbc:mysql://localhost:3306/produtos?useSSL=false";
		String user = "root";
		String password = "PECS";

		try {
			try {
				Class.forName( "com.mysql.jdbc.Driver" );
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection connection = DriverManager.getConnection(banco, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
}
