package com.example.westudy.Model;

import com.google.firebase.Timestamp;

public class AnnouncementModel {

    String announcementId;
    String TVAnnouncementContent;
    Timestamp AnnouncementTimestamp;

    public AnnouncementModel() {
    }

    public AnnouncementModel(String announcementId, String TVAnnouncementContent, Timestamp announcementTimestamp) {
        this.announcementId = announcementId;
        this.TVAnnouncementContent = TVAnnouncementContent;
        AnnouncementTimestamp = announcementTimestamp;
    }

    public String getTVAnnouncementContent() {
        return TVAnnouncementContent;
    }

    public void setTVAnnouncementContent(String TVAnnouncementContent) {
        this.TVAnnouncementContent = TVAnnouncementContent;
    }

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    public Timestamp getAnnouncementTimestamp() {
        return AnnouncementTimestamp;
    }

    public void setAnnouncementTimestamp(Timestamp announcementTimestamp) {
        AnnouncementTimestamp = announcementTimestamp;
    }
}
