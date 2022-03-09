package market.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
	
	public FactoryConnection() {}
	
	public Connection openConnection() throws SQLException {
		System.out.println("Preparando para abrir conexão com banco de dados...");
		return  DriverManager.getConnection(
				"jdbc:postgresql://localhost/market?useTimezon=true&serverTimezone=UTC",
				"postgres",
				"1234");
	}
	
	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
		System.out.println("Conexão encerrada!");
	}

}
