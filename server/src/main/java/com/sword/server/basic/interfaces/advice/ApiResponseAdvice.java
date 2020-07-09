package com.sword.server.basic.interfaces.advice;

import com.sword.server.basic.interfaces.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 对外接口响应结果统一包装
 * ControllerAdvice如果不指定具体的包可能会导致Swagger-ui.html页面无法打开，报“Unable to infer base url....”错误
 */
@ControllerAdvice(basePackages = "com.sword.server.demo.interfaces.api")
@Slf4j
public class ApiResponseAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 响应成功结果是否统一处理
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 响应成功结果统一处理
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

    /**
     * 如果发生Exception异常则统一返回响应失败结果
     * @param e 异常
     * @return 响应失败结果
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Result apiExceptionHandle(Exception e) {
        Result result = Result.builder().code("999999").msg(e.getMessage()).build();
        log.info("----------------http响应异常----------------");
        log.info("response = {}", result.toString()); // 响应数据
        log.info("--------------------------------------------");
        return result;
    }
}
