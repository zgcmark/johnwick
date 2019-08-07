package com.peppa.wick.client;

import com.peppa.wick.api.AppService;
import com.peppa.wick.config.constant.PropertiesConstant;

import java.util.Properties;

/**
 * @author zhengguangchen
 */

//客户端默认实现
public class DefaultClientAppService implements AppService {

    private String serverList;

    public DefaultClientAppService(String serverList) {
        this.serverList = serverList;
        Properties properties = new Properties();
        properties.setProperty(PropertiesConstant.SERVER_ADDR,serverList);
        init(properties);
    }

    public DefaultClientAppService(Properties properties) {
        init(properties);
    }


    //初始化客户端配置
    private void init(Properties properties) {

    }
}
