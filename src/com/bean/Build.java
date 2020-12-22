package com.bean;

import java.io.Serializable;

/**
 * (Build)实体类
 *
 * @author makejava
 * @since 2020-12-21 13:58:14
 */
public class Build implements Serializable {
//    private static final long serialVersionUID = 884899434728084010L;

    private Integer buildId;

    private String buildName;

    private String remarks;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}