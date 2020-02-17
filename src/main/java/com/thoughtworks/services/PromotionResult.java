package com.thoughtworks.services;

import com.thoughtworks.repositories.ParseOrder;
import com.thoughtworks.services.FullReductionPromotion;
import com.thoughtworks.services.HalfPricePromotion;
import com.thoughtworks.services.NoPromotion;
import com.thoughtworks.services.Promotions;

import java.util.ArrayList;
import java.util.List;

public class PromotionResult {
    private Promotions promotionResult;

    public PromotionResult() {
    }

    public PromotionResult(ParseOrder parseOrder) {
        this.promotionResult = choosePromotion(parseOrder);
    }

    private Promotions choosePromotion(ParseOrder parseOrder) {
        Promotions fullReductionPromotion = new FullReductionPromotion();
        fullReductionPromotion.setReducedMoney(parseOrder);

        Promotions halfPricePromotion = new HalfPricePromotion();
        halfPricePromotion.setReducedMoney(parseOrder);

        Promotions noPromotion = new NoPromotion();
        noPromotion.setReducedMoney(parseOrder);

        List<Promotions> promotionsList = new ArrayList<>();
        promotionsList.add(noPromotion);
        promotionsList.add(fullReductionPromotion);
        promotionsList.add(halfPricePromotion);

        Promotions promotionResult = noPromotion;
        for (Promotions promotions : promotionsList) {
            if (promotions.getReducedMoney() > promotionResult.getReducedMoney()) {
                promotionResult = promotions;
            }
        }
        return promotionResult;
    }

    public Promotions getPromotionResult() {
        return promotionResult;
    }
}
