package com.sword.demo.service.impl;

import com.sword.demo.entity.UserPo;
import com.sword.demo.mapper.UserMapper;
import com.sword.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author sword
 * @date 2020-07-06 19:39:35
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements UserService {

}
