package com.sword.demo.service.impl;

import com.sword.demo.repository.entity.UserPo;
import com.sword.demo.repository.mapper.UserMapper;
import com.sword.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author sword
 * @date 2020-07-07 11:13:57
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements UserService {

}
