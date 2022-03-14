package market.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class FactoryConnection {
	
	private String jdbcUrl = "jdbc:postgresql://localhost/market?useTimezon=true&serverTimezone=UTC";
	private String user = "postgres";
	private String password = "1234";
	private DataSource dataSource;
	
	
	public FactoryConnection() {
		ComboPooledDataSource comboPooled = new ComboPooledDataSource();
		comboPooled.setJdbcUrl(jdbcUrl);
		comboPooled.setUser(user);
		comboPooled.setPassword(password);
		
		this.dataSource = comboPooled;
		}
		
	public Connection openConnection() throws SQLException {
		System.out.println("Preparando para abrir conexão com banco de dados...");
		return this.dataSource.getConnection();
		
	}
	
	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
		System.out.println("Conexão encerrada!");
	}

}
