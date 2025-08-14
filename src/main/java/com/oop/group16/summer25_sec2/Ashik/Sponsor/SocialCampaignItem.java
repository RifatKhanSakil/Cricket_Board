package com.oop.group16.summer25_sec2.Ashik.Sponsor;

public class SocialCampaignItem {
    private String campaignName;
    private String platform;
    private String engagementRate;
    private String status;

    public SocialCampaignItem() {
    }

    public SocialCampaignItem(String campaignName, String platform, String engagementRate, String status) {
        this.campaignName = campaignName;
        this.platform = platform;
        this.engagementRate = engagementRate;
        this.status = status;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getEngagementRate() {
        return engagementRate;
    }

    public void setEngagementRate(String engagementRate) {
        this.engagementRate = engagementRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}