package com.sword.server.demo.interfaces.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sword.server.basic.interfaces.request.PageRequest;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


import com.sword.server.demo.service.UserService;
import com.sword.server.demo.interfaces.model.UserVo;
import com.sword.server.demo.convert.UserConvert;
import com.sword.server.demo.repository.entity.UserPo;

import javax.swing.text.html.Option;
import javax.xml.ws.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author sword
 * @date 2020-07-07 21:24:30
 */
@RestController
@RequestMapping("/demo/user")
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
     * @date 2020-07-07 21:24:30
     */
    public UserApi(UserService userService, UserConvert userConvert) {
        this.userService = userService;
        this.userConvert = userConvert;
    }

    /**
    * 添加用户表
    * @param userVo 用户表
    * @return com.sword.server.demo.interfaces.model.UserVo 用户表
    * @author sword
    * @date 2020-07-07 21:24:30
    */
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("添加用户表")
    @Async
    public UserVo insertUser(@RequestBody UserVo userVo) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserPo userPo = userConvert.convertFrom(userVo); // 视图对象转持久化对象
        userService.save(userPo); // 添加用户表
        return userConvert.convertTo(userPo); // 持久化对象转视图对象
    }

    /**
    * 删除用户表
    * @param id 用户表主键id
    * @return boolean 是否删除成功
    * @author sword
    * @date 2020-07-07 21:24:30
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
    * @return com.sword.server.demo.interfaces.model.UserVo 用户表
    * @author sword
    * @date 2020-07-07 21:24:30
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
     * @return com.sword.server.demo.interfaces.model.UserVo 单个用户表
     * @author sword
     * @date 2020-07-07 21:24:30
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("查询单个用户表")
    @ApiImplicitParam(name = "id", value = "用户表主键id", required = true)
    public UserVo getUser(@PathVariable("id") Integer id) throws Exception {
        userService.sleep();
        UserPo userPo = userService.getById(id); // 查询单个用户表


        return userConvert.convertTo(userPo); // 持久化对象转视图对象
    }

    /**
     * 分页查询用户表
     * @param userVo 查询条件
     * @param page 分页请求
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.sword.server.demo.interfaces.model.UserVo> 用户分页查询结果
     * @author sword
     * @date 2020/7/9 18:54
     */
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("分页查询用户表")
    public IPage<UserVo> listUser(UserVo userVo, PageRequest page) throws Exception {

        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>(userConvert.convertFrom(userVo));

        return userService.page(page.buildPage(), queryWrapper).convert(userConvert::convertTo);
    }

}

