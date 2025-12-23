package com.spendwise.dto;

import com.spendwise.enums.Type;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SpendInputDTO {
    private LocalDate date;
    private String description;
    private String category;
    private BigDecimal value;
    private Type type;

    public SpendInputDTO(LocalDate date, String description, String category, BigDecimal value, Type type) {
        this.date = date;
        this.description = description;
        this.category = category;
        this.value = value;
        this.type = type;
    }
}
