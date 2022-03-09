package market.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import market.connection.FactoryConnection;


public class Programa {
	
	public static void main(String[] args) {
		try {
			FactoryConnection connectionFactory = new FactoryConnection();
			Connection connection = connectionFactory.openConnection();
			System.out.println("Abriu Conex�o");
			System.out.println("\n Listando PRODUTO");
			listProducts(connection);
			System.out.println("\nCriando PRODUTO");
			createProduct(connection);
			System.out.println("\nLISTANDO PRODUTO");
			listProducts(connection);
			System.out.println("\n DELETANDO PRODUTO");
			deleteProduct(connection);
			
			System.out.println("\nLISTANDO PRODUTO");
			listProducts(connection);
			
			connectionFactory.closeConnection(connection);
		} catch (Exception e) {
			System.out.println("[ERROR]: Erro ao se conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		
	}
	
	private static void listProducts(Connection conn) throws SQLException {
		Statement statement  = conn.createStatement();
		 statement.execute("select id, name, descricao from produto");
		
		 ResultSet resultSet = statement.getResultSet();
		 int count = 1;
		 while(resultSet.next()) {
			 
			 int id = resultSet.getInt("id");
			 String name = resultSet.getString("name");
			 String descricao = resultSet.getString("descricao");
			 System.out.println("Produto " + count +": id={"+id+"},nome={"+name+"}, descricao={"+descricao+"}");
			 count++;
		 }
	}
	
	private static boolean createProduct(Connection conn) {
		Statement statement;
		String nome = "Blu-ray";
		String descricao = "Leitor de disco";
		
		String sql = "INSERT INTO produto(name, descricao) VALUES (?,?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, descricao);
			
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println("Erro na cria��o do Produto, causado por "+ e.getMessage());
			return false;
		}
		System.out.println("produto criado");
		return true;
	}
	
	
	private static boolean deleteProduct(Connection conn) {
		Statement statement;
		
		int id = 3;
				
		String sql = "DELETE FROM produto WHERE id = ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			preparedStatement.execute();
			
			int updateCount = preparedStatement.getUpdateCount();
			if (updateCount == 0) {
				System.out.println("Produto nao encontrado no banco. N�o Deletado!");
				return false;
			}else {
				System.out.println("Produto deletado com sucesso!");
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao Deletar um Produto. Causado por:" + e.getMessage());
			return false;
		}
		
	}

}