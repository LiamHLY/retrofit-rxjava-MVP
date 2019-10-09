package com.example.retrofitandrxjava.entity;

import com.google.gson.annotations.SerializedName;

public class MessageNotificateEntity {
    @SerializedName("id")
    int id;

    //题目
    @SerializedName("title")
    String title;

    //是否已读
    @SerializedName("is_read")
    String isRead;

    //用户id
    @SerializedName("user")
    int userId;

    //消息类型
    private String notificationType;

    //时间
    @SerializedName("created_time")
    private String displayTime;

    //内容
    @SerializedName("content")
    private String content;

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
