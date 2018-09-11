//package com.base.intercept;
//
//
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import com.alibaba.fastjson.support.spring.MappingFastJsonValue;
//import com.ttf.common.utils.rest.RestServiceResult;
//import org.springframework.http.HttpOutputMessage;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageNotWritableException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//
//
//import java.io.IOException;
//
//@ControllerAdvice
//public class ExtMappingJackson2HttpMessageConverter extends
//     FastJsonHttpMessageConverter {
//
//	@Override
//	protected void writeInternal(Object object, HttpOutputMessage outputMessage)
//			throws IOException, HttpMessageNotWritableException {
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNonStringValueAsString,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullNumberAsZero);
//		setFastJsonConfig(fastJsonConfig);
//		if(object instanceof MappingFastJsonValue){
//			MappingFastJsonValue container=(MappingFastJsonValue)object;
//			Object value = container.getValue();
//			if(value instanceof RestServiceResult){
//				super.writeInternal(object,
//						outputMessage);
//			}
//		}else{
//			if (outputMessage.getHeaders().getContentType()
//					.includes(MediaType.TEXT_HTML)) {
//				super.writeInternal(object,
//						outputMessage);
//			} else {
//				super.writeInternal(new RestServiceResult(object),
//						outputMessage);
//			}
//		}
//	}
//}
