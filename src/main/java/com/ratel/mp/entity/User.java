package com.ratel.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;


/**
 * @业务描述：
 * @package_name： com.ratel.mp.entity
 * @project_name： mybatis-plus-demo
 * @author： ratelfu@qq.com
 * @create_time： 2020-12-13 10:14
 * @copyright (c) ratelfu 版权所有
 */
@Data
@Builder
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}

