package com.busi.service;

import com.busi.dao.MsgDao;
import com.busi.entity.Msg;
import com.busi.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by x1505 on 2018/3/19 0019.
 */
@Service
public class MsgService {
    @Autowired
    private MsgDao msgDao;

    public List<Msg> getMsgList(String type,String user_id,String page_no,String page_size){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("type",type);
        map.put("user_id",user_id);
        map.put("start_no", CommonUtil.getStartNo(page_no, page_size));
        map.put("page_size",Integer.parseInt(page_size));
        List<Msg> msgList = msgDao.getMsgList(map);
        return msgList;
    }
}
