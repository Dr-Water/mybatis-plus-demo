package com.ratel.mp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.mp.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @业务描述：
 * @package_name： com.ratel.mp
 * @project_name： mybatis-plus-demo
 * @author： ratelfu@qq.com
 * @create_time： 2020-12-02 20:45
 * @copyright (c) ratelfu 版权所有
 */
public interface UserDao extends BaseMapper<User> {
    /**
     * 自定义的getById
     * @param id
     * @return
     */
    User myGetById(@Param("id") Integer id);
}
