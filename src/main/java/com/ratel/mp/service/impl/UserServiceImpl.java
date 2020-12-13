package com.ratel.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ratel.mp.dao.UserDao;
import com.ratel.mp.entity.User;
import com.ratel.mp.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @业务描述：
 * @package_name： com.ratel.mp.service
 * @project_name： mybatis-plus-demo
 * @author： ratelfu@qq.com
 * @create_time： 2020-12-13 10:36
 * @copyright (c) ratelfu 版权所有
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public User myGetById(Integer id) {
        //baseMapper为ServiceImpl 定义好且已经注入的，这里无需再次 定义和注入
        return baseMapper.myGetById(id);
    }
}
