package info.ilong.oms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import info.ilong.oms.pojo.Department;
import info.ilong.oms.pojo.User;
import info.ilong.oms.pojo.UserDept;
import info.ilong.oms.pojo.UserDeptExample;
import info.ilong.oms.pojo.UserDeptKey;

public interface UserDeptMapper {
    int countByExample(UserDeptExample example);

    int deleteByExample(UserDeptExample example);

    int deleteByPrimaryKey(UserDeptKey key);

    int insert(UserDept record);

    int insertSelective(UserDept record);

    List<UserDept> selectByExample(UserDeptExample example);

    UserDept selectByPrimaryKey(UserDeptKey key);

    int updateByExampleSelective(@Param("record") UserDept record, @Param("example") UserDeptExample example);

    int updateByExample(@Param("record") UserDept record, @Param("example") UserDeptExample example);

    int updateByPrimaryKeySelective(UserDept record);

    int updateByPrimaryKey(UserDept record);
    
    List<User> selectUserByDeptId(Integer deptId);
    
    List<Department> selectDeptByUserId(Integer userId);
}