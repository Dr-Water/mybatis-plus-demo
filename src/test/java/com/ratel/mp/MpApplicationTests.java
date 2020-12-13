package com.ratel.mp;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ratel.mp.entity.User;
import com.ratel.mp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MpApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void queryTest(){
        //普通写法
        List<User> userList = userService.list(Wrappers.<User>query().eq("id",1));
        System.out.println(userList);

        //lambda写法
        List<User> list = userService.list(Wrappers.<User>lambdaQuery().eq(User::getId,1));
        list.forEach(System.out::println);

        //new LambdaQueryWrapper<>(entity) 这种写法会将 entity中不为null的属性 拼接成where后的条件，且是 拼接出来是：eq（eg: id=1 and name = 'zs'...）
        // 便于日常开发使用，比如说 前端会根据 id/name/age/email 这四种的任意一个或多个 进行查询，list，手动一个一个 .eq 太麻烦，就可以使用这种方式
        List<User> list2 = userService.list(Wrappers.<User>lambdaQuery(User.builder().id(1).build()));
        list.forEach(System.out::println);
    }
    @Test
    void saveTest(){
        //由于主键是自增的所以这里就不用设置id的值了
        boolean isSuccess = userService.save(User.builder().name("zhangsan").age(18).email("zhangsan@qq.com").build());
        System.out.println(isSuccess);
    }
    @Test
    void updateTest(){
        User user = User.builder().name("zhangsan2").age(20).email("zhangsan2@qq.com").build();
        boolean isSuccess = userService.update(user, Wrappers.<User>update().eq("id",13));
        System.out.println(isSuccess);

        //用于构成 update语句的where部分
        User condition = User.builder().id(13).build();
        UpdateWrapper<User> updateWrapper = Wrappers.<User>update(condition)
                .setSql("name=" + "'zhangsan3'," + "age=" + 18); //设置 set 语句（name=zs，age=18...）
        boolean isSuccess2 = userService.update(updateWrapper);
        System.out.println(isSuccess2);
    }

    @Test
    void deleteTest(){
        boolean isSuccess = userService.removeById(14);
        System.out.println(isSuccess);
        //删除一个不存在的数据 返回false
        boolean isSuccess2 = userService.removeById(-1);
        System.out.println(isSuccess2);
    }

    @Test
    void myGetByIdTest(){
        User user = userService.myGetById(1);
        System.out.println(user);
    }

}
