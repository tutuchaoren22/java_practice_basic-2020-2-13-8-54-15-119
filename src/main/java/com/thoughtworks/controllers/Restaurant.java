package com.thoughtworks.controllers;

import com.thoughtworks.repositories.OrderInformation;
import com.thoughtworks.repositories.ParseOrder;
import com.thoughtworks.services.PromotionResult;
import com.thoughtworks.services.Summary;

public class Restaurant {

    public String bestCharge(String selectedItems) {
        OrderInformation orderInformation = new OrderInformation(selectedItems);
        ParseOrder parseOrder = new ParseOrder(orderInformation);
        PromotionResult promotionResult = new PromotionResult(parseOrder);
        Summary summary = new Summary(parseOrder, promotionResult.getPromotionResult());
        return summary.getSummary();
    }
}
