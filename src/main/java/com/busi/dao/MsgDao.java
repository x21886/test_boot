package com.busi.dao;


import com.busi.entity.Msg;

import java.util.List;
import java.util.Map;

/**
 * 消息dao
 * Created by x1505 on 2018/3/19 0019.
 */
public interface MsgDao {
    List<Msg> getMsgList(Map<String, Object> map);
}
