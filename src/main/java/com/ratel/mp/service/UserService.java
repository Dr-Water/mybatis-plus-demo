package com.ratel.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ratel.mp.entity.User;

/**
 * @业务描述：
 * @package_name： com.ratel.mp.service
 * @project_name： mybatis-plus-demo
 * @author： ratelfu@qq.com
 * @create_time： 2020-12-13 10:34
 * @copyright (c) ratelfu 版权所有
 */
public interface UserService extends IService<User> {
    User myGetById(Integer id);
}
