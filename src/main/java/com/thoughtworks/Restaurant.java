package com.thoughtworks;

public class Restaurant {

    public String bestCharge(String selectedItems) {
        OrderInformation orderInformation = new OrderInformation(selectedItems);
        ParseOrder parseOrder = new ParseOrder(orderInformation);
        PromotionResult promotionResult = new PromotionResult(parseOrder);
        Summary summary = new Summary(parseOrder, promotionResult.getPromotionResult());
        return summary.getSummary();
    }
}
