package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class HalfPricePromotion implements Promotions {
    List<String> halfPriceItems;
    Double reducedMoney;

    public List<String> getHalfPriceItems() {
        return halfPriceItems;
    }

    @Override
    public Double getReducedMoney() {
        return reducedMoney;
    }

    @Override
    public void setReducedMoney(ParseOrder parseOrder) {
        Double reducedMoney = 0.0;
        halfPriceItems = new ArrayList<>();
        List<String> halfDishIds = DataProvider.getHalfDishIds();
        for (Dish key : parseOrder.getParseOrder().keySet()) {
            for (String id : halfDishIds) {
                if (key.getId().equals(id)) {
                    reducedMoney += 0.5 * key.getPrice() * parseOrder.getParseOrder().get(key);
                    halfPriceItems.add(key.getName());
                    break;
                }
            }
        }
        this.reducedMoney = reducedMoney;
        this.halfPriceItems = halfPriceItems;
    }

    @Override
    public String toString() {
        return "-----------------------------------\n" + "使用优惠:\n" + "指定菜品半价("
                + String.join("，", this.halfPriceItems)
                + ")，省" + this.reducedMoney.intValue() + "元\n";
    }
}
