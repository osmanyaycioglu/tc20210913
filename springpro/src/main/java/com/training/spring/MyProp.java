package com.training.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "app.prop")
public class MyProp {

    private String name;
    private String desc;
    private int    version;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String descParam) {
        this.desc = descParam;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int versionParam) {
        this.version = versionParam;
    }


}
