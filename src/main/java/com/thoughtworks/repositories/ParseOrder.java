package com.thoughtworks.repositories;

import com.thoughtworks.data.DataProvider;
import com.thoughtworks.entities.Dish;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParseOrder {
    private Map<Dish, Integer> parseOrder;
    private Double totalPrice;

    public ParseOrder() {
    }

    public ParseOrder(OrderInformation orderInformation) {
        this.parseOrder = parseOrderToMap(orderInformation.getOrder());
        this.totalPrice = calculationTotalPrice();
    }

    private Map<Dish, Integer> parseOrderToMap(String order) {
        Map<Dish, Integer> parseOrder = new LinkedHashMap<>();
        List<Dish> dishes = DataProvider.getDishes();
        for (String orderPer : order.split(",")) {
            String[] dishIdAndCount = orderPer.split(" x ");
            for (Dish dish : dishes) {
                if (dishIdAndCount[0].equals(dish.getId())) {
                    parseOrder.put(dish, Integer.valueOf(dishIdAndCount[1]));
                    break;
                }
            }
        }
        return parseOrder;
    }

    private Double calculationTotalPrice() {
        double totalPrice = 0.0;
        for (Dish key : this.parseOrder.keySet()) {
            totalPrice += key.getPrice() * this.parseOrder.get(key);
        }
        return totalPrice;
    }

    public Map<Dish, Integer> getParseOrder() {
        return parseOrder;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
