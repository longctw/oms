package info.ilong.dept.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ilong.oms.mapper.DepartmentMapper;
import info.ilong.oms.pojo.Department;
import info.ilong.oms.pojo.DepartmentExample;
import info.ilong.oms.pojo.DepartmentExample.Criteria;
import info.ilong.utils.EasyUITreeNode;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.DeptQuery;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DepartmentMapper deptMapper;
	
	@Override
	public List<EasyUITreeNode> getDeptByParentId(DeptQuery query) {
		DepartmentExample example = new DepartmentExample();
		Criteria criteria = example.createCriteria();
		query.addCriteria(criteria);
		List<Department> list = deptMapper.selectByExample(example);
		
		List<EasyUITreeNode> result = new ArrayList<EasyUITreeNode>();
		
		for(Department dept : list){
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(dept.getId());
			node.setText(dept.getName());
			node.setState(dept.getType() == 1 ? "closed":"open");
			result.add(node);
		}
		
		return result;
	}

	@Override
	public OmsResult createDeptNode(Department dept) {
		// 封装数据，type=2表示叶子结点，1非叶子结点
		dept.setType(2);
		dept.setStatus(1);
		//插入
		deptMapper.insert(dept);
		//查询父节点
		Department pNode = deptMapper.selectByPrimaryKey(dept.getParentId());
		// 判断父节点是否为父节点类型 1：父节点类型 ，2：叶子结点
		if (pNode.getType() == 2){
			pNode.setType(1);
			deptMapper.updateByPrimaryKey(pNode);
		}
		
		return OmsResult.ok(dept);
	}

	@Override
	public OmsResult updateDeptNode(Department dept) {
		Department department = deptMapper.selectByPrimaryKey(dept.getId());
		department.setName(dept.getName());
		deptMapper.updateByPrimaryKey(department);
		return OmsResult.ok();
	}

	@Override
	public OmsResult deleteDeptNode(int id) {
		Department dept = deptMapper.selectByPrimaryKey(id);
		//判断如果是父节点，递归删除子节点
		if (dept != null && dept.isParent()){
			deleteChildNode(id);
		}
		Integer parentId = dept.getParentId();
		dept.setStatus(0);
		deptMapper.updateByPrimaryKey(dept);
		
		DepartmentExample example = new DepartmentExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		criteria.andStatusEqualTo(1);
		List<Department> list = deptMapper.selectByExample(example);
		//如果没有子节点
		if (list==null || list.size()==0){
			Department parentNode = deptMapper.selectByPrimaryKey(parentId);
			parentNode.isParent(false);
			deptMapper.updateByPrimaryKey(parentNode);
		}
		return OmsResult.ok();
	}
	
	private void deleteChildNode(int id){
		//查询父节点下所有子节点
		DepartmentExample example = new DepartmentExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		criteria.andStatusEqualTo(1);
		List<Department> list = deptMapper.selectByExample(example);
		//遍历删除所有子节点
		for(Department dept : list){
			dept.setStatus(0);
			deptMapper.updateByPrimaryKey(dept);
			//如果当前节点是父节点，删除其子节点
			if (dept.isParent()){
				deleteChildNode(dept.getId());
			}
		}
	}

}
