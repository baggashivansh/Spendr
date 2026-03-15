# Spendr

## Personal Expense Tracking Backend

Spendr is a personal expense tracking application built using **Java and Spring Boot**.
It provides a structured way to record, organize, and analyze daily expenses.

The idea for Spendr came from a common real-life problem. While making payments, many people write quick notes to remember where money was spent. Over time these notes become scattered and difficult to track.

Spendr solves this by providing a centralized system where users can log their expenses and review spending patterns in an organized way.

The project focuses primarily on backend system design, data modeling, and REST API development.

---

# Overview

Managing personal finances often becomes difficult when expenses are not recorded consistently.

Common problems include:

• forgetting where money was spent
• difficulty tracking monthly spending
• lack of structured expense records
• no category-wise visibility of expenses

Spendr helps users maintain a clear record of their spending by allowing them to log expenses and analyze them later.

---

# How Spendr Works

Spendr operates as a backend service that stores and manages expense data.

### Adding an Expense

1. A user submits a request to log an expense.
2. The backend validates the input.
3. The expense is stored in the database.
4. The system returns confirmation to the user.

Example flow:

User → POST /api/expenses
→ validate request
→ store expense in database
→ return response

---

### Viewing Expenses

Users can retrieve all their recorded expenses.

Example flow:

User → GET /api/expenses
→ backend queries database
→ returns list of expenses

---

### Monthly Summary

Spendr can group expenses by month and category to help users understand spending patterns.

Example summary:

Month: March

Food: ₹3200
Transport: ₹900
Shopping: ₹2100

This helps users analyze how their money is distributed across categories.

---

# Core Features

## User Authentication

Users can register and log in to their account.
Each user's expenses are stored separately to ensure data privacy.

---

## Expense Logging

Users can add expenses with important details such as:

• amount
• category
• date
• optional description

Example expense entry:

Category: Food
Amount: ₹250
Date: 2026-03-10
Description: Lunch

---

## Expense History

Users can view previously recorded expenses in chronological order.

This allows them to track spending behavior over time.

---

## Category Based Tracking

Expenses can be grouped into categories such as:

• Food
• Transport
• Shopping
• Bills
• Entertainment

This helps users understand where most of their money is being spent.

---

# System Architecture

Spendr follows a typical backend service architecture.

Client
↓
REST API (Spring Boot)
↓
Service Layer
↓
Database (MySQL)

The service layer contains the business logic while the database stores expense records.

---

# Technology Stack

Backend

Java
Spring Boot
Spring Web
Spring Data JPA

Database

MySQL

ORM

JPA and Hibernate

---

# Database Design

## Users Table

Stores registered users.

Fields:

id – primary key
name – user name
email – unique email address
password_hash – encrypted password

---

## Expenses Table

Stores individual expense records.

Fields:

id – primary key
user_id – reference to user
amount – expense amount
category – expense category
description – optional note
expense_date – date of expense
created_at – timestamp

---

# Example API Endpoints

### Register User

POST /api/auth/register

---

### Login

POST /api/auth/login

---

### Add Expense

POST /api/expenses

Request

{
"amount": 250,
"category": "Food",
"description": "Lunch",
"date": "2026-03-10"
}

---

### Get Expenses

GET /api/expenses

Returns all recorded expenses for the user.

---

# Project Structure

spendr
├── controller
│   └── ExpenseController.java
│
├── service
│   └── ExpenseService.java
│
├── repository
│   └── ExpenseRepository.java
│
├── model
│   ├── Expense.java
│   └── User.java
│
└── config
└── SecurityConfig.java

This layered structure separates controllers, services, and database logic.

---

# Future Improvements

Spendr can evolve into a more advanced financial tracking system.

Possible enhancements:

• expense analytics dashboard
• budget tracking
• recurring expense tracking
• export reports (PDF or CSV)
• AI-powered spending insights

---

# Status

Project under development.

---

# Author

Built by **Shivansh Bagga**
