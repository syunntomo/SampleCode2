package dto;

public class BranchCategoryDTO {

	private String branchId;
	private String branchName;

	public String getBranchId(){
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
}
