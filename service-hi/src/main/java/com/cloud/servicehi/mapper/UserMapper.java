package com.cloud.servicehi.mapper;

import com.cloud.servicehi.entity.User;
import org.jboss.logging.Param;


/**
 * 用户Dao接口
 * 
 * @author hkw
 * @since 2014年7月5日 上午11:49:57
 **/
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    Integer updateByPrimaryKeySelective(User record);

    Integer updateByPrimaryKey(User record);


    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public User selectByUsername(String username);
    


}