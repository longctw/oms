package info.ilong.utils.pojo;

import org.apache.commons.lang3.StringUtils;

import info.ilong.oms.pojo.UserExample.Criteria;

public class UserQuery {
	private String empId;
	private String fullname;
    private Integer gender;
    private String title;
    private Integer deptId;
    
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
    
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	public void addCriteria(Criteria criteria){
		if (StringUtils.isNotEmpty(fullname)){
			criteria.andFullnameLike("%" + fullname + "%");
		}
		if (StringUtils.isNotEmpty(empId)){
			criteria.andEmpIdLike("%" + empId + "%");
		}
		if (StringUtils.isNotEmpty(title)){
			criteria.andTitleLike("%" + title + "%");
		}
		if (gender != null){
			criteria.andGenderEqualTo(gender);
		}
	}
}
