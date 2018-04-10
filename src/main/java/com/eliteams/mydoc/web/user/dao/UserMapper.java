package com.eliteams.mydoc.web.user.dao;

import java.util.List;

import com.eliteams.mydoc.web.user.model.User;
import com.eliteams.mydoc.web.user.model.UserExample;
import org.apache.ibatis.annotations.Param;
import com.eliteams.mydoc.common.generic.GenericDao;
import org.springframework.stereotype.Repository;

/**
 * 用户Dao接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:49:57
 **/
@Repository
public interface UserMapper extends GenericDao<User, Long> {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 用户登录验证查询
     * 
     * @param record
     * @return
     */
    User authentication(@Param("record") User record);

    int updatePassword(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据用户名查询个人信息
     * @param userName
     * @return
     */
    User personalInformation(String userName);
}