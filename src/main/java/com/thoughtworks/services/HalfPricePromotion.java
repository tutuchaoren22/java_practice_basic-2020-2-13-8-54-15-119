package com.thoughtworks.services;

import com.thoughtworks.repositories.ParseOrder;
import com.thoughtworks.data.DataProvider;
import com.thoughtworks.entities.Dish;

import java.util.ArrayList;
import java.util.List;

public class HalfPricePromotion implements Promotions {
    List<String> halfPriceItems;
    Double reducedMoney;

    @Override
    public Double getReducedMoney() {
        return reducedMoney;
    }

    @Override
    public void setReducedMoney(ParseOrder parseOrder) {
        double reducedMoney = 0.0;
        List<String> halfPriceItems = new ArrayList<>();
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
