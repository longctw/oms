package info.ilong.utils.pojo;

import org.apache.commons.lang3.StringUtils;

import info.ilong.oms.pojo.CategoryExample.Criteria;

public class CategoryQuery {
	private String name;
	private Integer parentId;
	private Integer status = 1;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public void addCriteria(Criteria criteria){
		if (StringUtils.isNotEmpty(name)){
			criteria.andNameLike("%" + name + "%");
		}
		if (parentId != null){
			criteria.andParentIdEqualTo(parentId);
		}
		criteria.andStatusEqualTo(status);
	}
}
