package com.cloud.servicehi.service.impl;

import com.cloud.servicehi.entity.User;
import com.cloud.servicehi.mapper.UserMapper;
import com.cloud.servicehi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户Service实现类
 *
 * @author hkw
 * @since 2014年7月5日 上午11:54:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    public Integer updateByPrimaryKeySelective(User user){
    	return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int insert(User model) {
        return userMapper.insertSelective(model);
    }

    @Override
    public int update(User model) {
        return userMapper.updateByPrimaryKeySelective(model);
    }

    public User findById(String id){
        return userMapper.selectByPrimaryKey(id);
    }

}
