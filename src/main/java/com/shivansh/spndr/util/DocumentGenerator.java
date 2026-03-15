package com.shivansh.spndr.util;

import com.shivansh.spndr.model.Expense;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DocumentGenerator {

    public static String generateExpenseReport(List<Expense> expenses, Long userId) {

        String fileName = "expense_report_user_" + userId + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {

            writer.write("Expense Report\n");
            writer.write("========================\n\n");

            for (Expense expense : expenses) {
                writer.write("Title: " + expense.getTitle() + "\n");
                writer.write("Amount: " + expense.getAmount() + "\n");
                writer.write("Category: " + expense.getCategory() + "\n");
                writer.write("Date: " + expense.getDate() + "\n");
                writer.write("-----------------------------\n");
            }

        } catch (IOException e) {
            throw new RuntimeException("Error generating document");
        }

        return fileName;
    }
}