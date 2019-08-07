package com.peppa.wick.api;

import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * @author zhengguangchen
 */


public class AppFactory {

    public static AppService createAppService(String serverList)  {
        try {
            Class<?> driverImplClass = Class.forName("com.peppa.wick.client.DefaultClientAppService");
            Constructor constructor = driverImplClass.getConstructor(String.class);
            AppService vendorImpl = (AppService)constructor.newInstance(serverList);
            return vendorImpl;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static AppService createAppService(Properties properties)  {
        try {
            Class<?> driverImplClass = Class.forName("com.peppa.wick.client.DefaultClientAppService");
            Constructor constructor = driverImplClass.getConstructor(Properties.class);
            AppService vendorImpl = (AppService)constructor.newInstance(properties);
            return vendorImpl;
        } catch (Throwable e) {
            //TODO 定义异常
            throw new RuntimeException(e);
        }
    }


}
