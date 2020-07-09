package com.sword.server.demo.convert;

import java.util.List;
import org.mapstruct.Mapper;
import com.sword.server.demo.repository.entity.UserPo;
import com.sword.server.demo.interfaces.model.UserVo;

/**
 * 用户表 转换类
 * @author sword
 * @date 2020-07-07 21:24:30
 */
@Mapper(componentModel = "spring")
public interface UserConvert {
    /**
     * UserPo转UserVo
     *
     * @param userVo UserPo
     * @return UserVo UserVo
     * @author sword
     * @date 2020-07-07 21:24:30
     */
    UserVo convertTo(UserPo userVo);

    /**
     * UserVo转回UserPo
     *
     * @param userPo UserVo
     * @return UserPo UserPo
     * @author sword
     * @date 2020-07-07 21:24:30
     */
    UserPo convertFrom(UserVo userPo);

    /**
     * UserPo列表转UserVo列表
     *
     * @param userVoList UserPo列表
     * @return List<UserVo> UserVo列表
     * @author sword
     * @date 2020-07-07 21:24:30
     */
    List<UserVo> convertToList(List<UserPo> userVoList);

    /**
     * UserVo列表转回UserPo列表
     *
     * @param userPoList UserVo列表
     * @return List<UserPo> UserPo列表
     * @author sword
     * @date 2020-07-07 21:24:30
     */
    List<UserPo> convertFromList(List<UserVo> userPoList);
}