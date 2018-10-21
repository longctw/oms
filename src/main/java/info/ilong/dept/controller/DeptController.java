package info.ilong.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import info.ilong.dept.service.DeptService;
import info.ilong.oms.pojo.Department;
import info.ilong.utils.EasyUITreeNode;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.DeptQuery;

@Controller
@RequestMapping("dept")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> deptList(DeptQuery query, @RequestParam(value="id", defaultValue="0") int parentId){
		query.setParentId(parentId);
		List<EasyUITreeNode> result = deptService.getDeptByParentId(query);
		return result;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public OmsResult addNode(Department dept){
		return deptService.createDeptNode(dept);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public OmsResult deleteNode(int id){
		return deptService.deleteDeptNode(id);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public OmsResult updateNode(Department dept){
		return deptService.updateDeptNode(dept);
	}
	
}
