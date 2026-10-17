# 🏗️ Construction Site Operations Platform

A robust, enterprise-grade backend platform built to streamline construction site operations, inventory management, procurement workflows, and asynchronous PDF reporting. Developed with modern Java and Spring Boot, containerized with Docker, and backed by a PostgreSQL database with Flyway version control.

---

## 🚀 Tech Stack & Architecture

* **Core Framework:** Java 27, Spring Boot 4.1.1
* **Database & Migrations:** PostgreSQL 18.6, Flyway (V1–V5 automated schema migrations)
* **Data Access:** Spring Data JPA, Hibernate ORM
* **Security:** Spring Security (JWT-ready authentication, role-based access control)
* **Reporting:** OpenPDF (Asynchronous PDF generation for procurement invoices)
* **Containerization:** Docker (Multi-stage build, optimized runtime image)
* **Version Control:** Git & GitHub

---

## 📋 Core Modules

1. **Stock Ledger & Inventory Management (`/api/stock`)**
    * Tracks real-time stock item quantities, movements, and ledger entries.
    * Prevents discrepancies using transactional integrity and strict database constraints.
2. **Procurement Workflow Engine (`/api/procurement`)**
    * Manages site material procurement requests, statuses (Pending, Approved, Fulfilled), and purchase orders.
3. **Asynchronous PDF Report Generation (`/api/reports`)**
    * Dynamically generates professional procurement invoices and stock reports using OpenPDF.
4. **Security & Authentication (`/api/auth`)**
    * Secure endpoint protection with Spring Security and in-memory/JWT authentication workflows.

---

## 🐳 Running with Docker

You can easily run this platform inside a Docker container.

1. **Build the Docker Image:**
   ```bash
   docker build -t construction-platform:latest .