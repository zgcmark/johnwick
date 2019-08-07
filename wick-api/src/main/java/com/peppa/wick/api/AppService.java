package com.peppa.wick.api;

import com.peppa.wick.api.exception.WickException;

/**
 * @author zhengguangchen
 */


public interface AppService {



    void registerInstance(String serverName, String ip, int port) throws WickException;
    



}
