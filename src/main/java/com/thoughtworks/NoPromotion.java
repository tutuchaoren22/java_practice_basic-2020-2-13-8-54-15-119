package com.thoughtworks;

public class NoPromotion implements Promotions {
    Double reducedMoney;

    @Override
    public Double getReducedMoney() {
        return reducedMoney;
    }

    @Override
    public void setReducedMoney(ParseOrder parseOrder) {
        this.reducedMoney = 0.0;
    }

    @Override
    public String toString() {
        return "";
    }
}
