package info.ilong.category.service;

import java.util.List;

import info.ilong.oms.pojo.Category;
import info.ilong.utils.EasyUITreeNode;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.CategoryQuery;

public interface CategoryService {
	
	/**
	 * 按条件查询分类树
	 * @param query
	 * @return
	 */
	public List<EasyUITreeNode> getCategoryByParentId(CategoryQuery query);
	
	/**
	 * 创建分类节点
	 * @param dept
	 * @return
	 */
	public OmsResult createCategoryNode(Category category);
	
	/**
	 * 更新分类节点
	 * @param dept
	 * @return
	 */
	public OmsResult updateCategoryNode(Category category);
	
	/**
	 * 删除分类节点
	 * @param id
	 * @return
	 */
	public OmsResult deleteCategoryNode(int id);
}
