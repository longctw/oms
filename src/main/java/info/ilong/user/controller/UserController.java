package info.ilong.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import info.ilong.oms.pojo.User;
import info.ilong.user.service.UserService;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.UserQuery;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("{id}")
	@ResponseBody
	public User getUserById(@PathVariable int id){
		return userService.getUserById(id);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIResult userList(int page, int rows, UserQuery query){
		EasyUIResult result = userService.getUserList(page, rows, query);
		return result;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public OmsResult insertUser(User user, String deptIds){
		List<Integer> deptList = new ArrayList<Integer>();
		if (StringUtils.isNotEmpty(deptIds)){
			String[] ids = deptIds.split(",");
			for(String id : ids){
				int deptIdInt = Integer.parseInt(id);
				deptList.add(deptIdInt);
			}
		}
		return userService.insertUser(user, deptList);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public OmsResult updateUser(User user, String deptIds){
		List<Integer> deptList = new ArrayList<Integer>();
		if (StringUtils.isNotEmpty(deptIds)){
			String[] ids = deptIds.split(",");
			for(String id : ids){
				int deptIdInt = Integer.parseInt(id);
				deptList.add(deptIdInt);
			}
		}
		return userService.updateUser(user, deptList);
	}
	
	@RequestMapping("edit")
	public ModelAndView editUser(int id){
		ModelAndView result = new ModelAndView();
		result.setViewName("user-edit");
		
		User user = userService.getUserById(id);
		result.addObject("user", user);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public OmsResult deleteUser(String ids){
		if (StringUtils.isNotEmpty(ids)){
			String[] idArr = ids.split(",");
			for(String idStr : idArr){
				int id = Integer.parseInt(idStr);
				userService.deleteUser(id);
			}
		}
		return OmsResult.ok();
	}
}
