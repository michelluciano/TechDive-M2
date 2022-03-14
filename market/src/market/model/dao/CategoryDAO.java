package market.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class CategoryDAO {
	private Connection conn;
	
	public CategoryDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Category> list() throws SQLException{
		
	}
}
