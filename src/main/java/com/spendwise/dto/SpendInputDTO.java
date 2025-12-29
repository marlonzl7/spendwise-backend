package com.spendwise.dto;

import com.spendwise.enums.Type;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SpendInputDTO {
    public LocalDate date;
    public String description;
    public String category;
    public BigDecimal value;
    public Type type;

    public SpendInputDTO(LocalDate date, String description, String category, BigDecimal value, Type type) {
        this.date = date;
        this.description = description;
        this.category = category;
        this.value = value;
        this.type = type;
    }
}
