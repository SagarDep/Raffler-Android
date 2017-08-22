package com.raffler.app.models;

import com.raffler.app.classes.AppManager;

import java.util.Date;
import java.util.Map;

import static com.raffler.app.models.MessageStatus.EDITING;
import static com.raffler.app.models.MessageType.TEXT;
import static com.raffler.app.models.UserType.OTHER;
import static com.raffler.app.models.UserType.SELF;
import static com.raffler.app.utils.Util.getBooleanFromData;
import static com.raffler.app.utils.Util.getDateFromData;
import static com.raffler.app.utils.Util.getIntFromData;
import static com.raffler.app.utils.Util.getStringFromData;

/**
 * Created by Ghost on 16/8/2017.
 */

public class Message {

    private String idx, text, resource;
    private MessageType messageType = TEXT;
    private MessageStatus status = EDITING;
    private UserType userType = SELF;
    private String senderId, senderName;
    private Date createdAt, updatedAt;

    public Message(Map<String, Object> data){
        this.updateValue(data);
    }

    public void updateValue(Map<String, Object> data){
        this.idx = getStringFromData("idx", data);
        this.text = getStringFromData("text", data);
        this.resource = getStringFromData("resource", data);
        this.senderId = getStringFromData("senderId", data);
        this.senderName = getStringFromData("senderName", data);
        this.messageType = MessageType.values()[getIntFromData("messageType", data)];
        this.status = MessageStatus.values()[getIntFromData("status", data)];
        this.userType = senderId.equals(AppManager.getInstance().userId) ? SELF : OTHER;
        this.createdAt = getDateFromData("createdAt", data);
        this.updatedAt = getDateFromData("updatedAt", data);
    }

    public String getIdx() {
        return idx;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getResource() {
        return resource;
    }

    public String getText() {
        return text;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public UserType getUserType() {
        return userType;
    }

}