package mx.com.candas.comercializadora.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMySql {

	Connection conn= null;
	
	public Connection getConn() {
		return conn;
	}


	public void setConn(Connection conn) {
		this.conn = conn;
	}


	public DBMySql() {
		// TODO Auto-generated constructor stub
		 String  username="root";
		 String password ="root";
		 String dbUrl="jdbc:mysql://localhost:3306/db_sistema";
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(dbUrl, username, password); 
	} catch (SQLException e) {
		// TODO: handle exception
		System.out.println(e.toString());
	} catch (ClassNotFoundException e) {
		// TODO: handle exception
		System.out.println(e.toString());
	}
	
	}

	
	public void desconectarDB() throws SQLException{
		System.out.println("Cerrar coneccion a BD");
		if (conn != null) {
			conn.close();
		}
	}
}
