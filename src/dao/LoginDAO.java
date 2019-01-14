package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnector;

public class LoginDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private String sql = "select * from mst_employee where loginid=? and password=?";
	private boolean result;

	//データの有無のみを調べているのでboolean型
	//今回はデータをemployee.jspに送る必要がないので、DAOだけで対応する
	public boolean loginUserInfo(String loginId, String password) {

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			result = rs.next();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
