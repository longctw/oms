package info.ilong.utils.pojo;

import org.apache.commons.lang3.StringUtils;

import info.ilong.oms.pojo.OrderDetailExample.Criteria;

public class OrderDetailQuery {
	private Integer orderId;

    private Integer proId;
    
    private String dept;

    private String owner;
    
    private String schedule;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
    
	public void addCriteria(Criteria criteria){
		if (StringUtils.isNotEmpty(dept)){
			criteria.andDeptLike("%" + dept + "%");
		}
		
		if (StringUtils.isNotEmpty(owner)){
			criteria.andOwnerLike("%" + owner + "%");
		}
		
		if (StringUtils.isNotEmpty(schedule)){
			criteria.andScheduleLike("%" + schedule + "%");
		}
		
		if (orderId != null){
			criteria.andOrderIdEqualTo(orderId);
		}
		
		if (proId != null){
			criteria.andProIdEqualTo(proId);
		}
	}
}
