package com.shivansh.spndr.controller;

import com.shivansh.spndr.dto.ExpenseRequest;
import com.shivansh.spndr.dto.ExpenseResponse;
import com.shivansh.spndr.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<ExpenseResponse> addExpense(
            @PathVariable Long userId,
            @RequestBody ExpenseRequest request) {

        ExpenseResponse response = expenseService.addExpense(userId, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ExpenseResponse>> getExpenses(@PathVariable Long userId) {

        List<ExpenseResponse> expenses = expenseService.getUserExpenses(userId);
        return ResponseEntity.ok(expenses);
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long expenseId) {

        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}