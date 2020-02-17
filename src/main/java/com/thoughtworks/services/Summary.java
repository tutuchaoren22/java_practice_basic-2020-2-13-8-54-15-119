package com.thoughtworks.services;

import com.thoughtworks.entities.Dish;
import com.thoughtworks.repositories.ParseOrder;

public class Summary {
    String summary;

    public Summary() {
    }

    public Summary(ParseOrder parseOrder, Promotions promotion) {
        this.summary = calculationSummary(parseOrder, promotion);
    }

    private String calculationSummary(ParseOrder parseOrder, Promotions promotion) {
        StringBuilder summary = new StringBuilder("============= 订餐明细 =============\n");
        for (Dish key : parseOrder.getParseOrder().keySet()) {
            int subtotalPrice = (int) key.getPrice() * parseOrder.getParseOrder().get(key);
            summary.append(key.getName()).append(" x ").append(parseOrder.getParseOrder().get(key)).append(" = ").append(subtotalPrice).append("元\n");
        }
        summary.append(promotion.toString());
        int totalPrice = (int) (parseOrder.getTotalPrice() - promotion.getReducedMoney());
        summary.append("-----------------------------------\n" + "总计：").append(totalPrice).append("元\n").append("===================================");
        return summary.toString();
    }

    public String getSummary() {
        return summary;
    }
}
