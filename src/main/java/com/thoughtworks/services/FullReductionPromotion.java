package com.thoughtworks.services;

import com.thoughtworks.repositories.ParseOrder;

public class FullReductionPromotion implements Promotions {
    Double reducedMoney;

    @Override
    public Double getReducedMoney() {
        return reducedMoney;
    }

    @Override
    public void setReducedMoney(ParseOrder parseOrder) {
        if (parseOrder.getTotalPrice() >= 30) {
            this.reducedMoney = 6.0;
        } else {
            this.reducedMoney = 0.0;
        }
    }

    @Override
    public String toString() {
        return "-----------------------------------\n" + "使用优惠:\n" + "满30减6元，省6元\n";
    }
}
