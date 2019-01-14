package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.BranchCategoryDAO;
import dao.DepartmentCategoryDAO;
import dao.LoginDAO;
import dto.BranchCategoryDTO;
import dto.DepartmentCategoryDTO;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginId;
	private String password;
	private Map<String,Object>session;
	private boolean result;

	public String execute() {
		LoginDAO loginDAO = new LoginDAO();
		//次のjspに渡す情報はないので、booleanで対応  次のif分で使用する
		result = loginDAO.loginUserInfo(loginId, password);

		if(result) {
			//所属、部署の動的プルダウンに対応する
			BranchCategoryDAO branchCategoryDAO = new BranchCategoryDAO();
			DepartmentCategoryDAO departmentCategoryDAO = new DepartmentCategoryDAO();
			List<BranchCategoryDTO> branchCategoryList = new ArrayList<BranchCategoryDTO>();
			List<DepartmentCategoryDTO> departmentCategoryList = new ArrayList<DepartmentCategoryDTO>();

			branchCategoryList = branchCategoryDAO.getBranchInfo();
			departmentCategoryList = departmentCategoryDAO.getDepartmentInfo();
			session.put("branchCategoryList",branchCategoryList);
			session.put("departmentCategoryList", departmentCategoryList);

			//sessionはログインの有無に使用する
			session.put("loginId",loginId);
			return SUCCESS;
		}
		return ERROR;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
