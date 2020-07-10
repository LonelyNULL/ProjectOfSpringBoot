package com.sword.server.demo.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户 持久化对象
 * </p>
 *
 * @author sword
 * @date 2020-07-10 08:30:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@ApiModel(value="UserPo对象", description="用户")
public class UserPo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    private String name;

    /**
     * 用户手机
     */
    @ApiModelProperty(value = "用户手机")
    private String phone;

    /**
     * 流程实例id
     */
    @ApiModelProperty(value = "流程实例id")
    private String procInstId;

    /**
     * 逻辑删除标志，1-删除，0-未删除
     */
    @ApiModelProperty(value = "逻辑删除标志，1-删除，0-未删除")
    @TableLogic
    private String deleted;


}
