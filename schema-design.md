# Smart Clinic Management System - Database Design

## Overview
This document outlines the relational database schema for the Smart Clinic Management System using MySQL.

## Database Tables

### 1. `user` Table
Stores basic account authentication details.
- `id` (BIGINT, Primary Key, AUTO_INCREMENT)
- `email` (VARCHAR(100), UNIQUE, NOT NULL)
- `password` (VARCHAR(255), NOT NULL)
- `role` (VARCHAR(20), NOT NULL) -- ADMIN, DOCTOR, PATIENT

### 2. `doctor` Table
Stores doctor-specific information.
- `id` (BIGINT, Primary Key, AUTO_INCREMENT)
- `name` (VARCHAR(100), NOT NULL)
- `email` (VARCHAR(100), UNIQUE, NOT NULL)
- `speciality` (VARCHAR(100), NOT NULL)
- `available_times` (VARCHAR(255))

### 3. `patient` Table
Stores patient details.
- `id` (BIGINT, Primary Key, AUTO_INCREMENT)
- `name` (VARCHAR(100), NOT NULL)
- `email` (VARCHAR(100), UNIQUE, NOT NULL)
- `phone` (VARCHAR(20), NOT NULL)
- `password` (VARCHAR(255), NOT NULL)
- `created_at` (DATETIME, DEFAULT CURRENT_TIMESTAMP)

### 4. `appointment` Table
Manages booking records between patients and doctors.
- `id` (BIGINT, Primary Key, AUTO_INCREMENT)
- `doctor_id` (BIGINT, Foreign Key referencing `doctor(id)`)
- `patient_id` (BIGINT, Foreign Key referencing `patient(id)`)
- `appointment_time` (DATETIME, NOT NULL)
- `status` (VARCHAR(20), NOT NULL) -- CONFIRMED, CANCELLED, COMPLETED

## Entity-Relationship Summary
- `doctor` (1) <---> (N) `appointment`
- `patient` (1) <---> (N) `appointment`
