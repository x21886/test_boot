package com.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Description: 配置文件
 * Author: x1505
 * Version: 1.0
 * Create Date Time: 2018/9/7 0007 16:54.
 * Update Date Time:
 *
 * @see
 */
// 将当前Bean添加到容器中
@Component
// 默认读取全局配置文件获取值，将当前类中的属性与配置文件中的user进行绑定
//@ConfigurationProperties(prefix = "prop")
public class PropertyConfig implements Serializable {

//    @Value("${user.username}")
    private String exp;

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
