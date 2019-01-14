package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String user = "system";
	private String password ="Syunntomo1991";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";

	public Connection getConnection() {

		Connection con = null;

		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}