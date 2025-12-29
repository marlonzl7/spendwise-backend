package com.spendwise.service;

import com.spendwise.dao.SpendDAO;
import com.spendwise.dto.SpendInputDTO;
import com.spendwise.model.Spend;

public class SpendService {
    private final Spend spend;
    private final SpendDAO spendDAO;

    public SpendService(Spend spend, SpendDAO spendDAO) {
        this.spend = spend;
        this.spendDAO = spendDAO;
    }

    public void register(SpendInputDTO dto) {
        spend.setDate(dto.date);
        spend.setDescription(dto.description);
        spend.setCategory(dto.category);
        spend.setValue(dto.value);
        spend.setType(dto.type);

        spendDAO.save(spend);
    }
}
