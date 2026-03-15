package com.shivansh.spndr.service;

import com.shivansh.spndr.dto.ExpenseRequest;
import com.shivansh.spndr.dto.ExpenseResponse;
import com.shivansh.spndr.model.Expense;
import com.shivansh.spndr.model.User;
import com.shivansh.spndr.repository.ExpenseRepository;
import com.shivansh.spndr.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public ExpenseResponse addExpense(Long userId, ExpenseRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Expense expense = new Expense();
        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDate(request.getDate());
        expense.setUser(user);

        Expense savedExpense = expenseRepository.save(expense);

        return mapToResponse(savedExpense);
    }

    public List<ExpenseResponse> getUserExpenses(Long userId) {

        List<Expense> expenses = expenseRepository.findByUserId(userId);

        return expenses.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    private ExpenseResponse mapToResponse(Expense expense) {

        ExpenseResponse response = new ExpenseResponse();
        response.setId(expense.getId());
        response.setTitle(expense.getTitle());
        response.setAmount(expense.getAmount());
        response.setCategory(expense.getCategory());
        response.setDate(expense.getDate());

        return response;
    }
}