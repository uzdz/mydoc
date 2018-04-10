package com.eliteams.mydoc.web.user.service;

import com.eliteams.mydoc.common.generic.GenericService;
import com.eliteams.mydoc.web.user.model.User;

/**
 * 用户 业务 接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:53:33
 **/
public interface UserService extends GenericService<User, Long> {

    /**
     * 用户验证
     * 
     * @param user
     * @return
     */
    User authentication(User user);

    /**
     * 根据用户名查询用户
     * 
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 根据用户Id查询用户
     *
     * @param userId
     * @return
     */
    User selectByUserId(long userId);

    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean register(User user, Long departmentId);

    /**
     * 修改密码
     * @param userName
     * @param password
     * @return
     */
    boolean updatePassword(String userName, String password);

    /**
     * 根据用户名查询个人信息
     * @param userName
     * @return
     */
    User personalInformation(String userName);
}
