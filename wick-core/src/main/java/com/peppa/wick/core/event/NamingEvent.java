package com.peppa.wick.core.event;

import com.peppa.wick.core.model.Instance;

import java.util.Collection;
import java.util.List;

/**
 * @author zhengguangchen
 */


public class NamingEvent implements Event{

    private String appName;
    private List<Instance> instances;

    public NamingEvent(String appName, List<Instance> instances) {
    this.appName=appName;
    this.instances=instances;
    }


}
