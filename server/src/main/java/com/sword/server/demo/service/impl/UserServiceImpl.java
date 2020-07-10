package com.sword.server.demo.service.impl;

import com.sword.server.demo.repository.entity.UserPo;
import com.sword.server.demo.repository.mapper.UserMapper;
import com.sword.server.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务-实现类
 * </p>
 *
 * @author sword
 * @date 2020-07-10 08:30:47
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements UserService {

}
