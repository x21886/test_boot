package com.busi.controller;

import com.busi.entity.Msg;
import com.busi.service.MsgService;
import com.ttf.common.exception.BusinessException;
import com.ttf.common.log.ExceptionLogger;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息
 * Created by x1505 on 2018/3/19 0019.
 */
@Controller
@RequestMapping(value = "/index",produces = "application/json;charset=UTF-8")
public class MsgController {
    @Autowired
    private MsgService msgService;

    /**
     * 首页-最新消息
     * @param type 所有消息  -1 1通知-客服消息 2通知-我的资产
     * @param page_no 页码
     * @param page_size 页长
     * @param user_id 用户编码
     * @return
     */
    @RequestMapping(value = "get_msg_list")
    @ResponseBody
    public Map<String,Object> get_msg_list(String type,String page_no,String page_size,String user_id){
        Map<String,Object> map=new HashMap<String,Object>();
        if(StringUtils.isEmpty(user_id)){
            throw new BusinessException("缺少用户编码");
        }
        if(StringUtils.isEmpty(type)){
            type="-1";
        }
        try{
            List<Msg> msgList = msgService.getMsgList(type, user_id, page_no, page_size);
            map.put("msg_list",msgList);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw new BusinessException(((BusinessException) e).getCode(), e.getMessage());
            }
//            ExceptionLogger.error(e);
            throw new BusinessException("查询出错");
        }
        return map;
    }
}
