package com.cxsz.mealbuy.bean;

import java.util.List;

public class MealGoodsFilterBean {
    private String groupName;
    private List<MealGoodsBean.MealGoodsBodyBean> body;

    public MealGoodsFilterBean() {
    }

    public MealGoodsFilterBean(String groupName, List<MealGoodsBean.MealGoodsBodyBean> body) {
        this.groupName = groupName;
        this.body = body;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<MealGoodsBean.MealGoodsBodyBean> getBody() {
        return body;
    }

    public void setBody(List<MealGoodsBean.MealGoodsBodyBean> body) {
        this.body = body;
    }
}
