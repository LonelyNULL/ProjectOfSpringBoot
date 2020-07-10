package com.sword.server.demo.interfaces.api;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sword.server.basic.interfaces.request.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


import com.sword.server.demo.service.UserService;
import com.sword.server.demo.interfaces.model.UserVo;
import com.sword.server.demo.convert.UserConvert;
import com.sword.server.demo.repository.entity.UserPo;

/**
 * <p>
 * 用户 接口
 * </p>
 *
 * @author sword
 * @date 2020-07-10 08:30:47
 */
@RestController
@RequestMapping("/user")
@Api(tags = {"用户 接口"})
public class UserApi {

    /**
    * 用户 服务类
    */
    private UserService userService;

    /**
     * 用户 转换类
     */
    private UserConvert userConvert;

    /**
     * 构造函数
     * @param userService 用户 服务类
     * @param userConvert 服务类
     * @author sword
     * @date 2020-07-10 08:30:47
     */
    public UserApi(UserService userService, UserConvert userConvert) {
        this.userService = userService;
        this.userConvert = userConvert;
    }

    /**
    * 添加用户
    * @param userVo 用户
    * @return com.sword.server.demo.interfaces.model.UserVo 用户
    * @author sword
    * @date 2020-07-10 08:30:47
    */
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("添加用户")
    @Transactional(rollbackFor = Exception.class)
    public UserVo insertUser(@RequestBody UserVo userVo) throws Exception {
        UserPo userPo = userConvert.convertFrom(userVo); // 视图对象转持久化对象
        userService.save(userPo); // 添加用户

        if (userPo != null) {
            throw new Exception("添加用户异常");
        }
        return userConvert.convertTo(userPo); // 持久化对象转视图对象
    }

    /**
    * 删除用户
    * @param id 用户主键id
    * @return boolean 是否删除成功
    * @author sword
    * @date 2020-07-10 08:30:47
    */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "用户主键id", required = true)
    public boolean deleteUser(@PathVariable("id") Integer id) {
        return userService.removeById(id);
    }

    /**
    * 更新用户
    * @param id 用户主键id
    * @param userVo 用户
    * @return com.sword.server.demo.interfaces.model.UserVo 用户
    * @author sword
    * @date 2020-07-10 08:30:47
    */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("更新用户")
    @ApiImplicitParam(name = "id", value = "用户主键id", required = true)
    public UserVo updateUser(@PathVariable("id") Integer id, @RequestBody UserVo userVo) {
        UserPo userPo = userConvert.convertFrom(userVo); // 视图对象转持久化对象
        userPo.setId(id); // 设置主键id
        userService.updateById(userPo); // 更新用户
        return userConvert.convertTo(userPo); // 持久化对象转视图对象
    }

    /**
     * 查询单个用户
     * @return com.sword.server.demo.interfaces.model.UserVo 单个用户
     * @author sword
     * @date 2020-07-10 08:30:47
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("查询单个用户")
    @ApiImplicitParam(name = "id", value = "用户主键id", required = true)
    public UserVo getUser(@PathVariable("id") Integer id) throws InterruptedException {
        userService.sleep();

        UserPo userPo = userService.getById(id); // 查询单个用户
        return userConvert.convertTo(userPo); // 持久化对象转视图对象
    }

//    /**
//     * 查询多个用户
//     * @param userVo 查询条件
//     * @return java.util.List<com.sword.server.demo.interfaces.model.UserVo> 多个用户
//     * @author sword
//     * @date 2020-07-10 08:30:47
//     */
//    @GetMapping("")
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation("查询多个用户")
//    public List<UserVo> listUser(UserVo userVo) {
//        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>(userConvert.convertFrom(userVo));
//
//        return userConvert.convertToList(userService.list(queryWrapper));
//    }

    /**
     * 分页查询用户
     * @param userVo 查询条件
     * @param page 分页请求
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.sword.server.demo.interfaces.model.UserVo> 用户分页查询结果
     * @author sword
     * @date 2020/7/9 18:54
     */
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("分页查询用户")
    public IPage<UserVo> listUser(UserVo userVo, PageRequest page) {

        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>(userConvert.convertFrom(userVo));

        return userService.page(page.buildPage(), queryWrapper).convert(userConvert::convertTo);
    }
}

