package com.base.intercept;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.MappingFastJsonValue;
import com.ttf.common.exception.BusinessException;
import com.ttf.common.utils.rest.RestServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by x1505 on 2018/5/4 0004.
 */
@ControllerAdvice
public class ExceptionHandleAndMessageConvert {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandleAndMessageConvert.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestServiceResult Handle(Exception e,HttpServletResponse response){
        response.setHeader("Content-Type", MediaType.TEXT_HTML_VALUE);
        RestServiceResult<String> restServiceResult = new RestServiceResult<String>();
        if (e instanceof BusinessException){
            BusinessException bs = (BusinessException) e;

            if(bs.getCode()<0){
                restServiceResult.setResult_code(String.valueOf(bs.getCode()));
                restServiceResult.setErr_msg(bs.getMessage());
                restServiceResult.setResult_info("");
            }else{
                restServiceResult.setResult_code(RestServiceResult.CODE_UNKNOW);
                restServiceResult.setErr_msg(bs.getMessage());
                restServiceResult.setResult_info("");
            }
            logger.debug("[系统异常]{}", e);
            return restServiceResult;
        }else {
            restServiceResult.setResult_code(RestServiceResult.CODE_UNKNOW);
            logger.debug("[系统异常]{}",e);
            return restServiceResult;
        }

    }
    @Bean
    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter(){
        return new ByteArrayHttpMessageConverter();
    }

    //如果采用注解这种方式，感觉都可以不用放在这个地方
    //只要在spring容器启动的时候被扫描到就行了

    /**
     * 自定义消息解析器 fastjson
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonConfigure(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter(){
            @Override
            protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
                if(object instanceof MappingFastJsonValue){
                    MappingFastJsonValue container=(MappingFastJsonValue)object;
                    Object value = container.getValue();
                    if(value instanceof RestServiceResult){
                        super.writeInternal(object,
                                outputMessage);
                    }else{
                        super.writeInternal(new RestServiceResult(object),
                                outputMessage);
                    }
                }else{
                    if (outputMessage.getHeaders().getContentType()
                            .includes(MediaType.TEXT_HTML)) {
                        super.writeInternal(object,
                                outputMessage);
                    } else {
                        super.writeInternal(new RestServiceResult(object),
                                outputMessage);
                    }
                }
            }
        };
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNonStringValueAsString,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullNumberAsZero);
        //日期格式化
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        converter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(converter);
    }
    //另一种写法
//    @Bean
//    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue,SerializerFeature.WriteSlashAsSpecial,SerializerFeature.DisableCheckSpecialChar);
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        return fastJsonHttpMessageConverter;
//    }
}
