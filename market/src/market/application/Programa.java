package market.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import market.connection.FactoryConnection;


public class Programa {
	
	Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Programa main = new Programa();
		
		main.menuPrincipal();
		
		
	}
	
	private void menuPrincipal() {
		
		try {
			FactoryConnection connectionFactory = new FactoryConnection();
			Connection connection = connectionFactory.openConnection();
			System.out.println("Abriu Conex?o");
			
//			// testes
//			System.out.println("\n Listando PRODUTO");
//			listProducts(connection);
//			System.out.println("\nCriando PRODUTO");
//			createProduct(connection);
//			System.out.println("\nLISTANDO PRODUTO");
//			listProducts(connection);
//			System.out.println("\n DELETANDO PRODUTO");
//			deleteProduct(connection);
//			System.out.println("\nLISTANDO PRODUTO");
//			listProducts(connection);
			
			while(true){
	            System.out.println("--------------------------------------------------");
	            System.out.println("::              C R U D    P R O                ::");
	            System.out.println("--------------------------------------------------");
	            System.out.println("\nBem-vindo(a) ao sistema. Escolha a op??o desejada");
	            System.out.println("1 - Novo Produto");
	            System.out.println("2 - Listar Produto");
	            System.out.println("3 - Pesquisar Produto");
	            System.out.println("4 - Excluir Produto");
	            System.out.println("5 - Atualizar Produto");
	            System.out.print("Sua op??o: ");
	            int opcao = Integer.parseInt(entrada.nextLine());
	            // l? a op??o do usu?rio
	           
	            switch(opcao){
	                case 1:
	                	System.out.print("Digite o Nome do Produto: ");
	                    String nomeProd = entrada.nextLine();
	                    System.out.print("Digite a descri??o do Produto: ");
	                    String descProd = entrada.nextLine();
	                    createProduct(connection,nomeProd,descProd);
	                    
	                    
	                    break;

	                case 2:
	                	listProducts(connection);
	                    break;

	                case 3:
	                	System.out.print("Digite o Nome do Produto: ");
	                    int idProd = entrada.nextInt();
	                	pesquisarProduct(connection, idProd);
	                    break;

	                case 4:
	                	System.out.print("Digite o ID do Produto a ser deletado: ");
	                    idProd = entrada.nextInt();
	                	deleteProduct(connection,idProd);
	                    break;

	                case 5:
	                    //atualizarProd();
	                    break;

	               

	                case 00:
	                    System.out.println("\nObrigado por usar o Sistema CRUD\n");
	                            System.exit(0);
	            }
			}
			
			
			//connectionFactory.closeConnection(connection);
		} catch (Exception e) {
			System.out.println("[ERROR]: Erro ao se conectar ao Banco de Dados!");
			e.printStackTrace();
		}
		
		
    }
    
		
	private List<Product> listProducts(Connection conn) throws SQLException {
		Statement statement  = conn.createStatement();
		 statement.execute("select id, name, descricao from produto");
		
		 ResultSet resultSet = statement.getResultSet();
	
		 while(resultSet.next()) {
			 
			 int id = resultSet.getInt("id");
			 String name = resultSet.getString("name");
			 String descricao = resultSet.getString("descricao");
			 
		 }
	}
	
	private static boolean createProduct(Connection conn, String nome, String descricao) {
				
		String sql = "INSERT INTO produto(name, descricao) VALUES (?,?)";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, descricao);
			
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println("Erro na cria??o do Produto, causado por "+ e.getMessage());
			return false;
		}
		System.out.println("produto criado");
		return true;
	}
	
//	private static void addProduct() {
//		
//	}
	
	private static boolean pesquisarProduct(Connection conn, int idProd) throws SQLException {
		String sql = "select * FROM produto WHERE id = ?";
		Statement statement  = conn.createStatement();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, idProd);
			preparedStatement.execute();
			int updateCount = preparedStatement.getUpdateCount();
			if (updateCount == 0) {
				System.out.println("Produto nao encontrado no banco.");
				return false;
			}else {
				ResultSet resultSet = statement.getResultSet();
				int id = resultSet.getInt("id");
				 String name = resultSet.getString("name");
				 String descricao = resultSet.getString("descricao");
				 System.out.println("Produto : id={"+id+"},nome={"+name+"}, descricao={"+descricao+"}");
				return true;
			}
		} catch (Exception e) {
			System.out.println("Erro ao Deletar um Produto. Causado por:" + e.getMessage());
			return false;
		}
	}
	
	private static boolean deleteProduct(Connection conn, int idProd) {
		
				
		String sql = "DELETE FROM produto WHERE id = ?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, idProd);
			
			preparedStatement.execute();
			
			int updateCount = preparedStatement.getUpdateCount();
			if (updateCount == 0) {
				System.out.println("Produto nao encontrado no banco. N?o Deletado!");
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
