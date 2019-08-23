package com.peppa.wick.naming.nodes;

/**
 * node status
 */
public enum ServerNodeStatusEnum implements EnumInterface {

    UP     (1, "上线状态"),
    DOWN     (0, "下线状态"),
    ISOLATION     (1, "隔离状态");

    private int value;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    ServerNodeStatusEnum(int _value, String _desc) {
        this.description = _desc;
        this.value = _value;
    }

    public static ServerNodeStatusEnum valueOfType(int value) {
        for (ServerNodeStatusEnum type : ServerNodeStatusEnum.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        return null;
    }
}
