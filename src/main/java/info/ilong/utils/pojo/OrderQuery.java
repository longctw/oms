package info.ilong.utils.pojo;

import org.apache.commons.lang3.StringUtils;

import info.ilong.oms.pojo.OrderExample.Criteria;

public class OrderQuery {
	
	private String title;

	private String orderId;
	
	private String bailor;
	 
	private String schedule;

	private String cusName;
	
	private String cusCompany;
	
	private Integer status = 1;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBailor() {
		return bailor;
	}

	public void setBailor(String bailor) {
		this.bailor = bailor;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusCompany() {
		return cusCompany;
	}

	public void setCusCompany(String cusCompany) {
		this.cusCompany = cusCompany;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public void addCriteria(Criteria criteria){
		if (StringUtils.isNotEmpty(title)){
			criteria.andTitleLike("%" + title + "%");
		}
		if (StringUtils.isNotEmpty(orderId)){
			criteria.andOrderIdLike("%" + orderId + "%");
		}
		if (StringUtils.isNotEmpty(bailor)){
			criteria.andBailorLike("%" + bailor + "%");
		}
		if (StringUtils.isNotEmpty(schedule)){
			criteria.andScheduleLike("%" + schedule + "%");
		}
		if (StringUtils.isNotEmpty(cusName)){
			criteria.andCusNameLike("%" + cusName + "%");
		}
		if (StringUtils.isNotEmpty(cusCompany)){
			criteria.andCusCompanyLike("%" + cusCompany + "%");
		}
	}
}
