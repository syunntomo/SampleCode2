package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BranchCategoryDTO;
import util.DBConnector;

public class BranchCategoryDAO {

	private List<BranchCategoryDTO> branchCategoryDTO = new ArrayList<BranchCategoryDTO>();

	public List<BranchCategoryDTO> getBranchInfo(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from mst_branch";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				BranchCategoryDTO dto = new BranchCategoryDTO();
				dto.setBranchId(rs.getString("branchid"));
				dto.setBranchName(rs.getString("branchname"));
				branchCategoryDTO.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				con.close();
			} catch(SQLException e) {
			e.printStackTrace();
			}
		}
		return branchCategoryDTO;
	}
}