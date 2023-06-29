package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

public class SalesReportDTO {

    private Long id;
    private LocalDate date;
    private double amount;
    private String name;

    public SalesReportDTO(Long id, LocalDate date, double amount, String name) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }
}
