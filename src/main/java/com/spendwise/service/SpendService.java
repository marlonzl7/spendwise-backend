package com.spendwise.service;

import com.spendwise.dao.SpendDAO;
import com.spendwise.model.Spend;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SpendService {
    private final Spend spend;
    private final SpendDAO spendDAO;

    public SpendService(Spend spend, SpendDAO spendDAO) {
        this.spend = spend;
        this.spendDAO = spendDAO;
    }
    public void register(LocalDate date, String description, String category, BigDecimal value, Type){

    }
}
