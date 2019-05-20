package com.cxsz.mealbuy.bean;

import java.io.Serializable;

public class BusinessManagementBean implements Serializable{
    private String info;
    private int tag;

    public BusinessManagementBean(String info, int tag) {
        this.info = info;
        this.tag = tag;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
