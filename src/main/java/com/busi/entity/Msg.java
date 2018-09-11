package com.busi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;

import java.util.Date;

/**
 * 消息
 */
public class Msg {
    /**
     * <pre>
     * 信息编码
     * 表字段 : c_u_msg_info.msg_id
     * </pre>
     */
    private String msg_id;

    /**
     * <pre>
     * 来源用户编码,空值标识系统
     * 表字段 : c_u_msg_info.from_user_id
     * </pre>
     */
    private String from_user_id;

    /**
     * <pre>
     * 发送给用户编码，空值标识系统
     * 表字段 : c_u_msg_info.to_user_id
     * </pre>
     */
    private String to_user_id;

    /**
     * <pre>
     * 消息标题
     * 表字段 : c_u_msg_info.title
     * </pre>
     */
    private String title;

    /**
     * <pre>
     * 
     * 表字段 : c_u_msg_info.create_time
     * </pre>
     */
    private Date create_time;

    /**
     * <pre>
     * 
     * 表字段 : c_u_msg_info.operation_time
     * </pre>
     */
    private Date operation_time;

    /**
     * <pre>
     * 状态
0未读
1已读
99删除
     * 表字段 : c_u_msg_info.state
     * </pre>
     */
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Integer state;

    /**
     * <pre>
     * 1通知-客服消息 2通知-我的资产
     * 表字段 : c_u_msg_info.type
     * </pre>
     */
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Integer type;

    /**
     * <pre>
     * 消息内容
     * 表字段 : c_u_msg_info.content
     * </pre>
     */
    private String content;

    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    /**
     * <pre>
     * 获取：信息编码
     * 表字段：c_u_msg_info.msg_id
     * </pre>
     *
     * @return c_u_msg_info.msg_id：信息编码
     */
    public String getMsg_id() {
        return msg_id;
    }

    /**
     * <pre>
     * 设置：信息编码
     * 表字段：c_u_msg_info.msg_id
     * </pre>
     *
     * @param msg_id
     *            c_u_msg_info.msg_id：信息编码
     */
    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id == null ? null : msg_id.trim();
    }

    /**
     * <pre>
     * 获取：来源用户编码,空值标识系统
     * 表字段：c_u_msg_info.from_user_id
     * </pre>
     *
     * @return c_u_msg_info.from_user_id：来源用户编码,空值标识系统
     */
    public String getFrom_user_id() {
        return from_user_id;
    }

    /**
     * <pre>
     * 设置：来源用户编码,空值标识系统
     * 表字段：c_u_msg_info.from_user_id
     * </pre>
     *
     * @param from_user_id
     *            c_u_msg_info.from_user_id：来源用户编码,空值标识系统
     */
    public void setFrom_user_id(String from_user_id) {
        this.from_user_id = from_user_id == null ? null : from_user_id.trim();
    }

    /**
     * <pre>
     * 获取：发送给用户编码，空值标识系统
     * 表字段：c_u_msg_info.to_user_id
     * </pre>
     *
     * @return c_u_msg_info.to_user_id：发送给用户编码，空值标识系统
     */
    public String getTo_user_id() {
        return to_user_id;
    }

    /**
     * <pre>
     * 设置：发送给用户编码，空值标识系统
     * 表字段：c_u_msg_info.to_user_id
     * </pre>
     *
     * @param to_user_id
     *            c_u_msg_info.to_user_id：发送给用户编码，空值标识系统
     */
    public void setTo_user_id(String to_user_id) {
        this.to_user_id = to_user_id == null ? null : to_user_id.trim();
    }

    /**
     * <pre>
     * 获取：消息标题
     * 表字段：c_u_msg_info.title
     * </pre>
     *
     * @return c_u_msg_info.title：消息标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * <pre>
     * 设置：消息标题
     * 表字段：c_u_msg_info.title
     * </pre>
     *
     * @param title
     *            c_u_msg_info.title：消息标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：c_u_msg_info.create_time
     * </pre>
     *
     * @return c_u_msg_info.create_time：
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：c_u_msg_info.create_time
     * </pre>
     *
     * @param create_time
     *            c_u_msg_info.create_time：
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：c_u_msg_info.operation_time
     * </pre>
     *
     * @return c_u_msg_info.operation_time：
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getOperation_time() {
        return operation_time;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：c_u_msg_info.operation_time
     * </pre>
     *
     * @param operation_time
     *            c_u_msg_info.operation_time：
     */
    public void setOperation_time(Date operation_time) {
        this.operation_time = operation_time;
    }

    /**
     * <pre>
     * 获取：状态
0未读
1已读
99删除
     * 表字段：c_u_msg_info.state
     * </pre>
     *
     * @return c_u_msg_info.state：状态
0未读
1已读
99删除
     */
    public Integer getState() {
        return state;
    }

    /**
     * <pre>
     * 设置：状态
0未读
1已读
99删除
     * 表字段：c_u_msg_info.state
     * </pre>
     *
     * @param state
     *            c_u_msg_info.state：状态
0未读
1已读
99删除
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * <pre>
     * 获取：1通知-客服消息 2通知-我的资产
     * 表字段：c_u_msg_info.type
     * </pre>
     *
     * @return c_u_msg_info.type：1通知-客服消息 2通知-我的资产
     */
    public Integer getType() {
        return type;
    }

    /**
     * <pre>
     * 设置：1通知-客服消息 2通知-我的资产
     * 表字段：c_u_msg_info.type
     * </pre>
     *
     * @param type
     *            c_u_msg_info.type：1通知-客服消息 2通知-我的资产
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * <pre>
     * 获取：消息内容
     * 表字段：c_u_msg_info.content
     * </pre>
     *
     * @return c_u_msg_info.content：消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * <pre>
     * 设置：消息内容
     * 表字段：c_u_msg_info.content
     * </pre>
     *
     * @param content
     *            c_u_msg_info.content：消息内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}