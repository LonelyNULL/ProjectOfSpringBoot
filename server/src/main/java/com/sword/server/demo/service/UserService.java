package com.sword.server.demo.service;

import com.sword.server.demo.repository.entity.UserPo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author sword
 * @date 2020-07-07 21:24:30
 */
public interface UserService extends IService<UserPo> {

    @Async
    public default void sleep() throws InterruptedException {
        Thread.sleep(3000);

        System.out.println("睡了3秒");
    }
}
