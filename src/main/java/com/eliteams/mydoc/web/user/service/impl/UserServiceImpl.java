package com.eliteams.mydoc.web.user.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.eliteams.mydoc.web.department.dao.UserDepartmentMapper;
import com.eliteams.mydoc.web.user.dao.UserMapper;
import com.eliteams.mydoc.web.user.model.User;
import com.eliteams.mydoc.web.user.model.UserExample;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import com.eliteams.mydoc.common.generic.GenericDao;
import com.eliteams.mydoc.common.generic.GenericServiceImpl;
import com.eliteams.mydoc.web.user.service.UserService;

/**
 * 用户Service实现类
 *
 * @author uzdz
 * @since 2014年7月5日 上午11:54:24
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserDepartmentMapper userDepartmentMapper;

    @Override
    public int insert(User model) {
        return userMapper.insertSelective(model);
    }

    @Override
    public int update(User model) {
        return userMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User authentication(User user) {
        return userMapper.authentication(user);
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public GenericDao<User, Long> getDao() {
        return userMapper;
    }

    @Override
    public User selectByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        final List<User> list = userMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User selectByUserId(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public boolean register(User user, Long departmentId) {
        int insert = userMapper.insert(user);
        if (insert == 1) {
            int add = userDepartmentMapper.addUserDepartment(user.getUserId(), departmentId);
            if (add == 1) {
                // 验证成功在Session中保存用户信息
                Subject subject = SecurityUtils.getSubject();
                // 身份验证
                subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePassword(String userName, String password) {
        int i = userMapper.updatePassword(userName, password);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public User personalInformation(String userName) {
        return userMapper.personalInformation(userName);
    }

}
