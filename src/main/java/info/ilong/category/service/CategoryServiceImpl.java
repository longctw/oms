package info.ilong.category.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ilong.oms.mapper.CategoryMapper;
import info.ilong.oms.pojo.Category;
import info.ilong.oms.pojo.CategoryExample;
import info.ilong.oms.pojo.CategoryExample.Criteria;
import info.ilong.utils.EasyUITreeNode;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.CategoryQuery;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<EasyUITreeNode> getCategoryByParentId(CategoryQuery query) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		query.addCriteria(criteria);
		List<Category> list = categoryMapper.selectByExample(example);
		List<EasyUITreeNode> result = new ArrayList<EasyUITreeNode>();
		
		for(Category cate : list){
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(cate.getId());
			node.setText(cate.getName());
			node.setState(cate.getType() == 1 ? "closed":"open");
			result.add(node);
		}
		
		return result;
	}

	@Override
	public OmsResult createCategoryNode(Category category) {
		// 封装数据，type=2表示叶子结点，1非叶子结点
		category.setType(2);
		category.setStatus(1);
		//插入
		categoryMapper.insert(category);
		//查询父节点
		Category pNode =categoryMapper.selectByPrimaryKey(category.getParentId());
		// 判断父节点是否为父节点类型 1：父节点类型 ，2：叶子结点
		if (pNode.getType() == 2){
			pNode.setType(1);
			categoryMapper.updateByPrimaryKey(pNode);
		}
		
		return OmsResult.ok(category);
	}

	@Override
	public OmsResult updateCategoryNode(Category category) {
		Category cate = categoryMapper.selectByPrimaryKey(category.getId());
		// 临时方案，只能修改分类名
		cate.setName(category.getName());
		categoryMapper.updateByPrimaryKey(cate);
		return OmsResult.ok();
	}

	@Override
	public OmsResult deleteCategoryNode(int id) {
		Category category =categoryMapper.selectByPrimaryKey(id);
		//判断如果是父节点，递归删除子节点
		if (category != null && category.isParent()){
			deleteChildNode(id);
		}
		Integer parentId = category.getParentId();
		category.setStatus(0);
		categoryMapper.updateByPrimaryKey(category);
		
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		criteria.andStatusEqualTo(1);
		List<Category> list = categoryMapper.selectByExample(example);
		//如果没有子节点
		if (list==null || list.size()==0){
			Category parentNode = categoryMapper.selectByPrimaryKey(parentId);
			parentNode.isParent(false);
			categoryMapper.updateByPrimaryKey(parentNode);
		}
		return OmsResult.ok();
	}
	
	private void deleteChildNode(int id){
		//查询父节点下所有子节点
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		criteria.andStatusEqualTo(1);
		List<Category> list = categoryMapper.selectByExample(example);
		//遍历删除所有子节点
		for(Category cate : list){
			cate.setStatus(0);
			categoryMapper.updateByPrimaryKey(cate);
			//如果当前节点是父节点，删除其子节点
			if (cate.isParent()){
				deleteChildNode(cate.getId());
			}
		}
	}
}
