package com.sword.server.demo.convert;

import java.util.List;
import org.mapstruct.Mapper;
import com.sword.server.demo.repository.entity.UserPo;
import com.sword.server.demo.interfaces.model.UserVo;

/**
 * 用户 转换类
 * @author sword
 * @date 2020-07-10 08:30:47
 */
@Mapper(componentModel = "spring")
public interface UserConvert {
    /**
     * UserPo转UserVo
     *
     * @param userPo UserPo
     * @return UserVo
     * @author sword
     * @date 2020-07-10 08:30:47
     */
    UserVo convertTo(UserPo userPo);

    /**
     * UserVo转回UserPo
     *
     * @param userVo UserVo
     * @return UserPo
     * @author sword
     * @date 2020-07-10 08:30:47
     */
    UserPo convertFrom(UserVo userVo);

    /**
     * UserPo列表转UserVo列表
     *
     * @param userPoList UserPo列表
     * @return List<UserVo>
     * @author sword
     * @date 2020-07-10 08:30:47
     */
    List<UserVo> convertToList(List<UserPo> userPoList);

    /**
     * UserVo列表转回UserPo列表
     *
     * @param userVoList UserVo列表
     * @return List<UserPo>
     * @author sword
     * @date 2020-07-10 08:30:47
     */
    List<UserPo> convertFromList(List<UserVo> userVoList);
}