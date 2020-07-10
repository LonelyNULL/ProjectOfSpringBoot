package com.sword.server.demo.interfaces.model;

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
 * 用户 视图对象
 * </p>
 *
 * @author sword
 * @date 2020-07-10 08:30:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserVo对象", description="用户")
public class UserVo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
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



}
