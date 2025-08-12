package com.oop.group16.summer25_sec2.Ashik.TicketBuyer;

public class RewardSummary {
    private int pointsEarned;
    private int pointsRedeemed;
    private int currentBalance;

    public RewardSummary() {
    }

    public RewardSummary(int pointsEarned, int pointsRedeemed, int currentBalance) {
        this.pointsEarned = pointsEarned;
        this.pointsRedeemed = pointsRedeemed;
        this.currentBalance = currentBalance;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public int getPointsRedeemed() {
        return pointsRedeemed;
    }

    public void setPointsRedeemed(int pointsRedeemed) {
        this.pointsRedeemed = pointsRedeemed;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
}