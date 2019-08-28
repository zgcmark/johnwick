package com.peppa.wick.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengguangchen
 */


public class AppInfo {

    private String name;

    private List<Instance> instanceList = new ArrayList<Instance>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Instance> getInstanceList() {
        return instanceList;
    }

    public void setInstanceList(List<Instance> instanceList) {
        this.instanceList = instanceList;
    }
}
