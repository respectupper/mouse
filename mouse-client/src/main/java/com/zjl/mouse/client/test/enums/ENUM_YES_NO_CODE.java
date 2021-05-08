package com.zjl.mouse.client.test.enums;

/**
 * @author zhujingle
 */
public enum ENUM_YES_NO_CODE {
    /** 是 */
    YES("是","YES","yes"),
    /** 否 */
    NO("否","NO","yes");
    private final String name;
    private final String value;
    private final String valueLower;

    ENUM_YES_NO_CODE(String name, String value, String valueLower) {
        this.name = name;
        this.value = value;
        this.valueLower = valueLower;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getValueLower() {
        return valueLower;
    }
}
