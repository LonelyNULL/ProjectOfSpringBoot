package com.sword.demo.convert;

import org.mapstruct.Mapper;
import com.sword.demo.entity.UserPo;
import com.sword.demo.model.UserVo;
import com.sword.demo.common.BaseConvert;

/**
 * 用户表 转换类
 * @author wukongjian
 * @date 2019/12/29 9:38
 */
@Mapper(componentModel = "spring")
public interface UserConvert extends BaseConvert<UserPo, UserVo> {
}