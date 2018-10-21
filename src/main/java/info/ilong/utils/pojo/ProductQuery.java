package info.ilong.utils.pojo;

import org.apache.commons.lang3.StringUtils;

import info.ilong.oms.pojo.ProductExample.Criteria;

public class ProductQuery {
	private String title;
	private String proId;
	private Integer relation;
	private String type;
	private Integer categoryId;
	private Integer status = 1;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public Integer getRelation() {
		return relation;
	}
	public void setRelation(Integer relation) {
		this.relation = relation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public void addCriteria(Criteria criteria){
		if (StringUtils.isNotEmpty(title)){
			criteria.andTitleLike("%" + title + "%");
		}
		if (StringUtils.isNotEmpty(proId)){
			criteria.andProIdLike("%" + proId + "%");
		}
		if (StringUtils.isNotEmpty(type)){
			criteria.andTypeLike("%" + type + "%");
		}
		if (categoryId != null){
			criteria.andCategoryIdEqualTo(categoryId);
		}
		if (relation != null){
			criteria.andRelationEqualTo(relation);
		}
		criteria.andStatusEqualTo(status);
	}
	
}
