package info.ilong.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import info.ilong.oms.mapper.DepartmentMapper;
import info.ilong.oms.mapper.UserDeptMapper;
import info.ilong.oms.mapper.UserMapper;
import info.ilong.oms.pojo.Department;
import info.ilong.oms.pojo.DepartmentExample;
import info.ilong.oms.pojo.User;
import info.ilong.oms.pojo.UserDept;
import info.ilong.oms.pojo.UserDeptExample;
import info.ilong.oms.pojo.UserDeptKey;
import info.ilong.oms.pojo.UserExample;
import info.ilong.oms.pojo.UserExample.Criteria;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.Md5Utils;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.UserQuery;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserDeptMapper userDeptMapper;
	
	@Autowired
	private DepartmentMapper deptMapper;

	@Override
	public User getUserById(int id) {
		User user = userMapper.selectByPrimaryKey(id);
		List<Department> deptList = userDeptMapper.selectDeptByUserId(id);
		user.setDeptList(deptList);
		return user;
	}

	@Override
	public OmsResult insertUser(User user, List<Integer> deptList) {
		Date currentDate = new Date();
		user.setRegisterTime(currentDate);
		
		if (StringUtils.isEmpty(user.getPassword())){
			// 初始密码
			user.setPassword("123456");
			// 设置有效期三天
			user.setExpireTime(new Date(currentDate.getTime() + 1000 * 60 * 60 * 24 * 3)); 
		}
		// 密码加密
		String password = Md5Utils.parseStrToMd5U32(user.getPassword());
		user.setPassword(password);
		user.setStatus(1);
		userMapper.insert(user);
		
		for (int deptId : deptList ){
			UserDept ud = new UserDept();
			ud.setUserId(user.getId());
			ud.setDeptId(deptId);
			userDeptMapper.insert(ud);
		}
		
		return OmsResult.ok(user);
	}

	@Override
	public OmsResult updateUser(User user, List<Integer> deptList) {
		userMapper.updateByPrimaryKeySelective(user);
		
		UserDeptExample example = new UserDeptExample();
		info.ilong.oms.pojo.UserDeptExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(user.getId());
		
		List<UserDept> udList = userDeptMapper.selectByExample(example);
		for (UserDept ud : udList){
			UserDeptKey pkey = new UserDeptKey();
			pkey.setUserId(ud.getUserId());
			pkey.setDeptId(ud.getDeptId());
			userDeptMapper.deleteByPrimaryKey(pkey);
		}
		
		for (int deptId : deptList ){
			UserDept ud = new UserDept();
			ud.setUserId(user.getId());
			ud.setDeptId(deptId);
			userDeptMapper.insert(ud);
		}
		
		return OmsResult.ok();
	}

	@Override
	public OmsResult deleteUser(int id) {
		User user = new User();
		user.setId(id);
		user.setStatus(0);
		userMapper.updateByPrimaryKeySelective(user);
		
		UserDeptExample example = new UserDeptExample();
		info.ilong.oms.pojo.UserDeptExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(id);
		List<UserDept> udList = userDeptMapper.selectByExample(example);
		
		for (UserDept ud : udList){
			UserDeptKey pkey = new UserDeptKey();
			pkey.setUserId(ud.getUserId());
			pkey.setDeptId(ud.getDeptId());
			userDeptMapper.deleteByPrimaryKey(pkey);
		}

		return OmsResult.ok();
	}

	@Override
	public EasyUIResult getUserList(int page, int rows, UserQuery query) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		
		//查询商品信息，紧跟着分析信息的第一个select语句会被分页
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		query.addCriteria(criteria);
		Integer deptId = query.getDeptId();
		
		if (deptId != null){
			List<Integer> deptList = new ArrayList<Integer>();
			recursiveQueryChildDept(deptList, deptId);
			
			UserDeptExample udExample = new UserDeptExample();
			info.ilong.oms.pojo.UserDeptExample.Criteria udCriteria = udExample.createCriteria();
			udCriteria.andDeptIdIn(deptList);
			List<UserDept> udList = userDeptMapper.selectByExample(udExample);
			List<Integer> userIdList = new ArrayList<Integer>();
			
			if(udList != null && udList.size() > 0){
				for(UserDept ud : udList){
					userIdList.add(ud.getUserId());
				}
			}
			
			// 保证userlist不为空
			if (userIdList.size() == 0){
				userIdList.add(0);
			}
			criteria.andIdIn(userIdList);
				
		}
		List<User> list = userMapper.selectByExample(example);
		
		for (User user : list){
			List<Department> deptList = userDeptMapper.selectDeptByUserId(user.getId());
			user.setDeptList(deptList);
		}
		
		//对结果进行包装
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		//构造相应结果 
		EasyUIResult result = new EasyUIResult(pageInfo.getTotal(), list);
		return result;
	}

	private void recursiveQueryChildDept(List<Integer> deptList, int deptId){
		deptList.add(deptId);
		
		DepartmentExample example = new DepartmentExample();
		info.ilong.oms.pojo.DepartmentExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(deptId);
		criteria.andStatusEqualTo(1);
		List<Department> list = deptMapper.selectByExample(example);
		if (list != null && list.size() > 0){
			for (Department dept : list){
				recursiveQueryChildDept(deptList, dept.getId());
			}
		}
	}
}
