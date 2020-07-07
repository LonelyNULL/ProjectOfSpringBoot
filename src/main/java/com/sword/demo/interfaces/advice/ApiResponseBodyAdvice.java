package com.sword.demo.interfaces.advice;

import com.sword.demo.interfaces.response.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * api接口返回值统一处理
 * @author sword
 * @date 2020-07-07 11:13:57
 */
@ControllerAdvice(basePackages = "com.sword.demo.interfaces.api")
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 是否处理
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 统一处理
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return body instanceof Result ? body : Result.builder().code("000000").msg("调用成功").data(body).build();
    }
}

