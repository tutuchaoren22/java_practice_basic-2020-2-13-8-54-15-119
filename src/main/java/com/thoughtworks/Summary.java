package com.thoughtworks;

public class Summary {
    String summary;

    public Summary() {
    }

    public Summary(ParseOrder parseOrder, Promotions promotion) {
        this.summary = calculationSummary(parseOrder, promotion);
    }

    private String calculationSummary(ParseOrder parseOrder, Promotions promotion) {
        String summary = "============= 订餐明细 =============\n";
        for (Dish key : parseOrder.getParseOrder().keySet()) {
            int subtotalPrice = (int) key.getPrice() * parseOrder.getParseOrder().get(key);
            summary += (key.getName() + " x " + parseOrder.getParseOrder().get(key) + " = " + subtotalPrice + "元\n");
        }
        summary += promotion.toString();
        int totalPrice = (int) (parseOrder.getTotalPrice() - promotion.getReducedMoney());
        summary += "-----------------------------------\n" + "总计：" + totalPrice + "元\n" + "===================================";
        return summary;
    }

    public String getSummary() {
        return summary;
    }
}
