package info.ilong.dept.service;

import java.util.List;

import info.ilong.oms.pojo.Department;
import info.ilong.utils.EasyUITreeNode;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.DeptQuery;

/**
 * added by xull on 10.18
 * 部门操作接口
 * @author xulon
 */
public interface DeptService {
	/**
	 * 按条件查询部门树
	 * @param query
	 * @return
	 */
	public List<EasyUITreeNode> getDeptByParentId(DeptQuery query);
	
	/**
	 * 创建部门节点
	 * @param dept
	 * @return
	 */
	public OmsResult createDeptNode(Department dept);
	
	/**
	 * 更新部门节点
	 * @param dept
	 * @return
	 */
	public OmsResult updateDeptNode(Department dept);
	
	/**
	 * 删除部门节点
	 * @param id
	 * @return
	 */
	public OmsResult deleteDeptNode(int id);
	
}
