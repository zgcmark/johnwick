package com.peppa.wick.client.heart;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhengguangchen
 */


public class HeartbeatManager {
    private static final String UNQU_KEY_SQ="&";

    public final Map<String, HeartInfo> plan2Beat = new ConcurrentHashMap<String, HeartInfo>();


    public void addHeartInfo(String serverName, HeartInfo heartInfo) {
        plan2Beat.put(buildUnquKey(serverName,heartInfo.getIp(),heartInfo.getPort()),heartInfo);
    }


    private String buildUnquKey(String serverName, String ip, int port) {
     return    new StringBuffer().append(serverName).append(UNQU_KEY_SQ).append(ip).append(port).toString();
    }
}
