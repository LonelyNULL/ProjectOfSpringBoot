package com.sword.server.basic.interfaces.request;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * 分页请求
 * @author sword
 * @date 2020-07-07 11:13:57
 */
@Data
@ApiModel(value="PageRequest", description="分页请求")
public class PageRequest {
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", example = "1", position = 990)
    private Integer curPage;

    /**
     * 每页显示条数
     */
    @ApiModelProperty(value = "每页显示条数", example = "10", position = 991)
    private Integer pageSize;

    /**
     * 排序："id desc,name asc"
     */
    @ApiModelProperty(value = "排序：\"id desc,name asc\"", position = 992)
    private String orderBy;

    /**
     * 获取分页对象
     * @return com.baomidou.mybatisplus.core.metadata.IPage<T> 分页对象
     * @author sword
     * @date 2020-07-07 11:13:57
     */
    public <T> IPage<T> buildPage() {
        // 根据当前页和每页显示条数初始化分页对象
        Page<T> listPage = new Page<>(curPage, pageSize);

        // 如果排序不为空则添加排序内容
        if (StringUtils.isNotEmpty(orderBy)) {
            Stream.of(orderBy.split(",")) // 使用“,”将排序分隔为多个列排序
                    .filter(StringUtils::isNotEmpty) // 筛选出非空的列排序
                    .map(orderByStr -> {
                        // 使用“ ”将列排序分隔为排序列名和排序类型
                        String[] order = orderByStr.split(" ");

                        // 如果只有一个元素且不为空说明只有排序列名没有排序类型则默认排序类型为升序
                        if (order.length == 1 && StringUtils.isNotEmpty(order[0])) {
                            return OrderItem.asc(order[0]); // 生成指定列名的升序
                        }
                        // 如果只有两个元素且第一个元素不为空说明有排序列名和排序类型，继续判断
                        else if (order.length == 2 && StringUtils.isNotEmpty(order[0])) {
                            // 如果排序类型为降序则生成指定列名的降序，否则就是生成升序
                            if ("desc".equals(order[1])) {
                                return OrderItem.desc(order[0]);
                            }
                            else {
                                return OrderItem.asc(order[0]);
                            }
                        }
                        else {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull) // 筛选出非空有效的排序对象
                    .forEach(listPage::addOrder);
        }

        return listPage;
    }
}