package info.ilong.user.service;

import java.util.List;

import info.ilong.oms.pojo.User;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.UserQuery;

/**
 * added by xull on 8.22
 * 用户操作接口
 * @author xulon
 */
public interface UserService {
	/**
	 * 根据主键查询用户信息
	 * @param id
	 * @return User
	 */
	public User getUserById(int id);
	/**
	 * 按条件查询所有用户列表
	 * @param id
	 * @return User
	 */
	public EasyUIResult getUserList(int page, int rows, UserQuery query);
	
	/**
	 * 向用户表插入一条数据
	 * @param User
	 * @return
	 */
	public OmsResult insertUser(User user, List<Integer> deptList );
	
	/**
	 * 更新一条已存在的信息
	 * @param User
	 * @return
	 */
	public OmsResult updateUser(User user, List<Integer> deptList);
	
	/**
	 * 删除一条信息
	 * @param id
	 * @return
	 */
	public OmsResult deleteUser(int id);
	
}
