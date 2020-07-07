package com.sword.demo.interfaces.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


import com.sword.demo.service.UserService;
import com.sword.demo.interfaces.model.UserVo;
import com.sword.demo.convert.UserConvert;
import com.sword.demo.repository.entity.UserPo;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author sword
 * @date 2020-07-07 11:13:57
 */
@RestController
@RequestMapping("/user")
@Api(tags = {"用户表 接口"})
public class UserApi {

    /**
    * 用户表 服务类
    */
    private UserService userService;

    /**
     * 用户表 转换类
     */
    private UserConvert userConvert;

    /**
     * 构造函数
     * @param userService 用户表 服务类
     * @param userConvert 服务类
     * @author sword
     * @date 2020-07-07 11:13:57
     */
    public UserApi(UserService userService, UserConvert userConvert) {
        this.userService = userService;
        this.userConvert = userConvert;
    }

    /**
    * 添加用户表
    * @param userVo 用户表
    * @return com.sword.demo.interfaces.model.UserVo 用户表
    * @author sword
    * @date 2020-07-07 11:13:57
    */
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("添加用户表")
    public UserVo insertUser(@RequestBody UserVo userVo) {
        UserPo userPo = userConvert.convertFrom(userVo); // 视图对象转持久化对象
        userService.save(userPo); // 添加用户表
        return userConvert.convertTo(userPo); // 持久化对象转视图对象
    }

    /**
    * 删除用户表
    * @param id 用户表主键id
    * @return boolean 是否删除成功
    * @author sword
    * @date 2020-07-07 11:13:57
    */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("删除用户表")
    @ApiImplicitParam(name = "id", value = "用户表主键id", required = true)
    public boolean deleteUser(@PathVariable("id") Integer id) {
        return userService.removeById(id);
    }

    /**
    * 更新用户表
    * @param id 用户表主键id
    * @param userVo 用户表
    * @return com.sword.demo.interfaces.model.UserVo 用户表
    * @author sword
    * @date 2020-07-07 11:13:57
    */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("更新用户表")
    @ApiImplicitParam(name = "id", value = "用户表主键id", required = true)
    public UserVo updateUser(@PathVariable("id") Integer id, @RequestBody UserVo userVo) {
        UserPo userPo = userConvert.convertFrom(userVo); // 视图对象转持久化对象
        userPo.setId(id); // 设置主键id
        userService.updateById(userPo); // 更新用户表
        return userConvert.convertTo(userPo); // 持久化对象转视图对象
    }

    /**
     * 查询单个用户表
     * @return com.sword.demo.interfaces.model.UserVo 单个用户表
     * @author sword
     * @date 2020-07-07 11:13:57
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("查询单个用户表")
    @ApiImplicitParam(name = "id", value = "用户表主键id", required = true)
    public UserVo getUser(@PathVariable("id") Integer id) {
        UserPo userPo = userService.getById(id); // 查询单个用户表
        return userConvert.convertTo(userPo); // 持久化对象转视图对象
    }

}

