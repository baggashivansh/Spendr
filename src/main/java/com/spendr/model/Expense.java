package com.spendr.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Expense() {}

    public Expense(String title, BigDecimal amount, String category, LocalDateTime createdAt) {
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.createdAt = createdAt;
    }

    // getters and setters
}