package com.thoughtworks.services;

import com.thoughtworks.repositories.ParseOrder;

public interface Promotions {
    public Double getReducedMoney();
    public void setReducedMoney(ParseOrder parseOrder);
}
