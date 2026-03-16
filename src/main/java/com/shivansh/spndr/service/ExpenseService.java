package com.shivansh.spndr.service;

import com.shivansh.spndr.dto.ExpenseRequest;
import com.shivansh.spndr.dto.ExpenseResponse;
import com.shivansh.spndr.model.Expense;
import com.shivansh.spndr.repository.ExpenseRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseResponse addExpense(Long userId, ExpenseRequest request) {

        Expense expense = new Expense();
        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setUserId(userId);

        Expense saved = expenseRepository.save(expense);

        return new ExpenseResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getAmount(),
                saved.getCategory(),
                saved.getUserId()
        );
    }

    public List<ExpenseResponse> getExpensesByUser(Long userId) {

        return expenseRepository.findByUserId(userId)
                .stream()
                .map(expense -> new ExpenseResponse(
                        expense.getId(),
                        expense.getTitle(),
                        expense.getAmount(),
                        expense.getCategory(),
                        expense.getUserId()
                ))
                .collect(Collectors.toList());
    }

    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }
}