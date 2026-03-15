package com.shivansh.spndr.service;

import com.shivansh.spndr.model.Expense;
import com.shivansh.spndr.repository.ExpenseRepository;
import com.shivansh.spndr.util.DocumentGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private final ExpenseRepository expenseRepository;

    public DocumentService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public String generateExpenseDocument(Long userId) {

        List<Expense> expenses = expenseRepository.findByUserId(userId);

        return DocumentGenerator.generateExpenseReport(expenses, userId);
    }
}