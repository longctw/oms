package info.ilong.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import info.ilong.category.service.CategoryService;
import info.ilong.oms.pojo.Category;
import info.ilong.utils.EasyUITreeNode;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.CategoryQuery;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> categoryList(CategoryQuery query, @RequestParam(value="id", defaultValue="0") int parentId){
		query.setParentId(parentId);
		List<EasyUITreeNode> result = categoryService.getCategoryByParentId(query);
		return result;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public OmsResult addNode(Category category){
		return categoryService.createCategoryNode(category);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public OmsResult deleteNode(int id){
		return categoryService.deleteCategoryNode(id);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public OmsResult updateNode(Category category){
		return categoryService.updateCategoryNode(category);
	}
}
