package com.example.wedding.http.bean;

import cn.bmob.v3.BmobObject;

/**
 * 用户反馈信息表
 */
public class FeedbackBean extends BmobObject {
    /**
     * 反馈用户id
     */
    private String userId;
    /**
     * 反馈的内容
     */
    private String feedback;

    public FeedbackBean() {
    }

    public FeedbackBean(String userId, String feedback) {
        this.userId = userId;
        this.feedback = feedback;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "FeedbackBean{" +
                "userId='" + userId + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
