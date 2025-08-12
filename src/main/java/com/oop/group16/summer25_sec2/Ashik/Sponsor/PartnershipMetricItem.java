package com.oop.group16.summer25_sec2.Ashik.Sponsor;

public class PartnershipMetricItem {
    private String metric;
    private String target;
    private String actual;
    private String comments;

    public PartnershipMetricItem() {
    }

    public PartnershipMetricItem(String metric, String target, String actual, String comments) {
        this.metric = metric;
        this.target = target;
        this.actual = actual;
        this.comments = comments;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}