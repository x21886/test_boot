package com.base.intercept;


import com.alibaba.fastjson.JSON;
import com.ttf.common.log.ExceptionLogger;
import com.ttf.common.utils.base.DateUtils;
import com.ttf.common.utils.rest.RestServiceResult;
import org.jboss.logging.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author YeChunBo
 * @time 2017年9月8日
 *
 *       类说明: ip 拦截器，只有在配置文件中定义了的ip 才可以访问接口
 */

public class URLInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(URLInterceptor.class);
    private static String nullResultJson = null;

    static {
        try {
            nullResultJson = JSON.toJSONString(new RestServiceResult(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        if (ex != null) {
            ExceptionLogger.error(DateUtils.getCurrentTimeNumber(), "ip:" + request.getLocalAddr() + ";uri:" + request.getRequestURI(), DateUtils.getCurrentTime(), ex);
        }
        if (response.getContentType() == null) {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.print(nullResultJson);
            pw.flush();
            pw.close();
        }
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）调用,
     *  返回true 则放行， false 则将直接跳出方法
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
       return true;
    }



}