# Spndr

## Personal Expense Tracker Backend

Spndr is a backend service for managing personal expense records.
It allows users to record daily spending, organize expenses by category, and retrieve structured financial data through REST APIs.

The goal of this project is to demonstrate backend engineering practices such as REST API design, layered architecture, relational database modeling, and containerized deployment using Docker.

Spndr focuses on building a reliable backend system rather than a user interface.

---

# Live Link

Backend Service
*(Deployment link will be added here once the service is hosted)*

---

# Overview

Tracking personal finances becomes difficult when expenses are recorded inconsistently. People often rely on temporary notes, messages, or memory to remember where money was spent.

Common problems include:

• forgetting individual expenses
• lack of structured expense records
• difficulty reviewing monthly spending
• no category based analysis of spending habits

Spndr solves this by providing a centralized backend system where expenses can be recorded and queried in a structured way.

---

# Key Features

### User Authentication

Users can register and log in securely.

Each user has isolated expense records so that expense data remains private to the account owner.

Authentication prepares the system for multi user usage and secure API access.

---

### Expense Logging

Users can create expense entries containing:

• amount
• category
• date
• optional description

Example expense entry

Category: Food
Amount: ₹250
Date: 2026 03 10
Description: Lunch

---

### Expense History

Users can retrieve previously recorded expenses in chronological order.

This makes it easier to review past spending behavior and maintain financial awareness.

---

### Category Based Tracking

Expenses are grouped into categories such as:

• Food
• Transport
• Shopping
• Bills
• Entertainment

This makes it easier to understand where most of the money is being spent.

---

### Monthly Spending Summary

Spndr can generate summaries of expenses grouped by month and category.

Example summary

Month: March

Food: ₹3200
Transport: ₹900
Shopping: ₹2100

This allows users to quickly analyze spending patterns.

---

# How the System Works

Spndr operates as a backend service that receives HTTP requests and stores structured expense data.

Typical request flow

Client
↓
REST API Controller
↓
Service Layer (Business Logic)
↓
Repository Layer
↓
MySQL Database

The service layer contains application logic while the database stores expense records persistently.

---

# Technology Stack

Backend

Java
Spring Boot
Spring Web
Spring Data JPA

Database

MySQL

Containerization

Docker

ORM

JPA and Hibernate

---

# System Architecture

Spndr follows a layered architecture that separates responsibilities across the application.

Controller Layer

Handles incoming HTTP requests and returns responses.

Service Layer

Contains the business logic responsible for managing expenses and users.

Repository Layer

Handles database operations using Spring Data JPA.

Database Layer

Stores persistent user and expense records.

This separation improves maintainability and keeps the system easier to extend.

---

# Database Design

### Users Table

Stores registered users.

Fields

id — primary key
name — user name
email — unique email address
password_hash — encrypted password
created_at — timestamp

---

### Expenses Table

Stores individual expense records.

Fields

id — primary key
user_id — reference to user
amount — expense amount
category — expense category
description — optional note
expense_date — date of expense
created_at — timestamp

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

Example request

{
"amount": 250,
"category": "Food",
"description": "Lunch",
"date": "2026-03-10"
}

---

### Get Expenses

GET /api/expenses

Returns all recorded expenses for the authenticated user.

---

### Get Monthly Summary

GET /api/expenses/summary

Returns categorized monthly spending information.

---

# Running the Project Locally

### 1 Clone the Repository

git clone https://github.com/shivanshbagga/spndr.git

cd spndr

---

### 2 Configure Database

Create a MySQL database.

Example

spndr_db

Update the database credentials in `application.properties`.

---

### 3 Run the Application

Using Maven

./mvnw spring-boot:run

The server will start on

http://localhost:8080

---

# Running with Docker

Build Docker image

docker build -t spndr .

Run container

docker run -p 8080:8080 spndr

This ensures the application runs consistently across different environments.

---

# Project Structure

spndr

src/main/java/com/shivansh/spndr

controller
ExpenseController.java
AuthController.java

service
ExpenseService.java
UserService.java

repository
ExpenseRepository.java
UserRepository.java

model
Expense.java
User.java

config
SecurityConfig.java

---

# Future Improvements

Spndr can evolve into a more advanced financial tracking system.

Possible enhancements include

• budget management
• recurring expense tracking
• financial analytics dashboard
• export reports in CSV or PDF
• spending insights and notifications

---

# Author

Built by **Shivansh Bagga**

