package com.sword.demo.interfaces.response;

import lombok.Builder;
import lombok.Data;

/**
 * 公共响应
 * @author sword
 * @date 2020-07-07 11:13:57
 */
@Data
@Builder
public class Result<T> {

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应内容
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;
}

