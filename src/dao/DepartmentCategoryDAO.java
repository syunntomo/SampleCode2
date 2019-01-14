package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DepartmentCategoryDTO;
import util.DBConnector;

public class DepartmentCategoryDAO {

	private List<DepartmentCategoryDTO> departmentCategoryDTO = new ArrayList<DepartmentCategoryDTO>();

	public List<DepartmentCategoryDTO> getDepartmentInfo(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM mst_department";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				DepartmentCategoryDTO dto = new DepartmentCategoryDTO();
				dto.setDepartmentId(rs.getString("departmentid"));
				dto.setDepartmentName(rs.getString("departmentname"));
				departmentCategoryDTO.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return departmentCategoryDTO;
	}
}