package com.cloud.servicehi.service;


import com.cloud.servicehi.entity.User;

/**
 * 用户 业务 接口
 * 
 * @author hkw
 * @since 2014年7月5日 上午11:53:33
 **/
public interface UserService {

	public Integer updateByPrimaryKeySelective(User user);


    User findById(String id);

    public int insert(User user);

    public int update(User model);
    
}
