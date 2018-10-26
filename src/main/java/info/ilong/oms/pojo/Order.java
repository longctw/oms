package info.ilong.oms.pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;

    private String title;

    private String orderId;

    private Date createDate;

    private String bailor;

    private String schedule;

    private Integer sumMoney;

    private Date requireDate;

    private Date competeDate;

    private String type;

    private String state;

    private String image;

    private String files;

    private String cusName;

    private String cusCompany;

    private String cusAddress;

    private String cusPhone;

    private String cusDesc;

    private String expressInfo;

    private Date expressDate;

    private String remark;
    
    private List<OrderDetail> odList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getBailor() {
        return bailor;
    }

    public void setBailor(String bailor) {
        this.bailor = bailor == null ? null : bailor.trim();
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule == null ? null : schedule.trim();
    }

    public Integer getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Integer sumMoney) {
        this.sumMoney = sumMoney;
    }

    public Date getRequireDate() {
        return requireDate;
    }

    public void setRequireDate(Date requireDate) {
        this.requireDate = requireDate;
    }

    public Date getCompeteDate() {
        return competeDate;
    }

    public void setCompeteDate(Date competeDate) {
        this.competeDate = competeDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files == null ? null : files.trim();
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    public String getCusCompany() {
        return cusCompany;
    }

    public void setCusCompany(String cusCompany) {
        this.cusCompany = cusCompany == null ? null : cusCompany.trim();
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress == null ? null : cusAddress.trim();
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone == null ? null : cusPhone.trim();
    }

    public String getCusDesc() {
        return cusDesc;
    }

    public void setCusDesc(String cusDesc) {
        this.cusDesc = cusDesc == null ? null : cusDesc.trim();
    }

    public String getExpressInfo() {
        return expressInfo;
    }

    public void setExpressInfo(String expressInfo) {
        this.expressInfo = expressInfo == null ? null : expressInfo.trim();
    }

    public Date getExpressDate() {
        return expressDate;
    }

    public void setExpressDate(Date expressDate) {
        this.expressDate = expressDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public List<OrderDetail> getOdList() {
		return odList;
	}

	public void setOdList(List<OrderDetail> odList) {
		this.odList = odList;
	}
	
}