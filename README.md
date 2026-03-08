# Hibernate Customer Management System – Assessment Project

## 📌 Overview

This project demonstrates the implementation of **Hibernate (JPA) with MySQL** to manage a simple **Customer–Order system**.

The application performs **CRUD operations**, demonstrates **One-to-One entity mapping**, and executes a **JPQL query**. It also includes a solved **LeetCode algorithm problem (Number of Islands)** as part of the assessment.

The project was developed using **Java, Hibernate ORM, and MySQL** and executed through **Eclipse IDE**.

---

# 🎯 Objectives of the Assignment

* Configure **Hibernate with JPA**
* Implement **Entity classes**
* Create **One-to-One mapping**
* Perform **CRUD operations**
* Execute a **JPQL query**
* Solve an **algorithm problem**

---

# 🧱 Project Structure

```
HibernateCustomerProject
│
├── App.java
├── Customer.java
├── Order.java
├── CustomerDAOImpl.java
├── OrderDAOImpl.java
│
└── src/main/resources
      └── META-INF
            └── persistence.xml
```

### 📂 File Descriptions

| File                     | Purpose                                        |
| ------------------------ | ---------------------------------------------- |
| **App.java**             | Main application that runs all CRUD operations |
| **Customer.java**        | Customer entity class                          |
| **Order.java**           | Order entity class                             |
| **CustomerDAOImpl.java** | DAO class handling Customer CRUD operations    |
| **OrderDAOImpl.java**    | DAO class handling Order operations            |
| **persistence.xml**      | Hibernate configuration file                   |

---

# 🗄 Database Schema

### Customer Table

| Column           | Type              |
| ---------------- | ----------------- |
| id               | INT (Primary Key) |
| customerName     | VARCHAR           |
| email            | VARCHAR           |
| gender           | VARCHAR           |
| phone            | BIGINT            |
| registrationDate | DATE              |
| order_id         | INT (Foreign Key) |

### Orders Table

| Column      | Type              |
| ----------- | ----------------- |
| id          | INT (Primary Key) |
| orderNumber | VARCHAR           |
| productName | VARCHAR           |
| quantity    | INT               |
| price       | DOUBLE            |
| orderDate   | DATE              |

---

# 🔗 Entity Relationship

```
Customer 1  ------  1 Order
```

Implemented using:

```java
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="order_id")
```

and

```java
@OneToOne(mappedBy="order")
```

---

# ⚙ Features Implemented

## 1️⃣ Insert Customer with Order

Creates a customer and associates an order.

```java
customerDao.insertCustomer(customer);
```

✔ Hibernate automatically saves both entities due to **CascadeType.ALL**.

---

## 2️⃣ Fetch Customer by ID

```java
Customer fetchedCustomer = customerDao.getCustomerById(1);
```

Displays customer information retrieved from the database.

---

## 3️⃣ Update Customer Details

Example update:

```java
fetchedCustomer.setEmail("updatedemail@gmail.com");
customerDao.updateCustomer(fetchedCustomer);
```

---

## 4️⃣ Fetch All Customers

```java
List<Customer> customers = customerDao.getAllCustomers();
```

Displays all customer records stored in the database.

---

## 5️⃣ JPQL Query – Fetch Customer by Email

JPQL used:

```java
SELECT c FROM Customer c WHERE c.email = :email
```

Purpose:
Retrieve a customer using their **email address**.

---

## 6️⃣ Fetch Order by ID

```java
Order fetchedOrder = orderDao.getOrderById(1);
```

Retrieves a specific order.

---

## 7️⃣ Update Order

Example:

```java
fetchedOrder.setPrice(80000);
orderDao.updateOrder(fetchedOrder);
```

Updates order details in the database.

---

## 8️⃣ Delete Customer

```java
customerDao.deleteCustomer(1);
```

Since **cascade = ALL**, the associated order is deleted automatically.

---

# 🧪 Sample Console Output

```
Customer inserted successfully!
Fetched Customer: Poulami
Customer updated successfully!
All Customers:
Poulami - updatedemail@gmail.com
Customer fetched by email: Poulami
Order Product: Laptop
Order updated successfully!
Customer deleted successfully!
```

---

# 🧮 Algorithm Section

## Problem Solved: Number of Islands (LeetCode)

### Problem Summary

Given a grid of **'1' (land)** and **'0' (water)**, count the number of islands.

### Approach

The problem was solved using **Depth First Search (DFS)**.

Steps:

1. Traverse the grid
2. When land (`1`) is found:
3. Perform DFS to mark the island
4. Increment island count

### Time Complexity

```
O(m × n)
```

Where:

* **m = rows**
* **n = columns**

---

# 🛠 Technologies Used

| Technology    | Purpose                   |
| ------------- | ------------------------- |
| Java          | Core programming language |
| Hibernate ORM | Object Relational Mapping |
| JPA           | Persistence framework     |
| MySQL         | Database                  |
| Maven         | Dependency management     |
| Eclipse IDE   | Development environment   |

---

# ▶ How to Run the Project

### Step 1

Ensure MySQL database exists:

```
jpa_demo
```

### Step 2

Update database credentials in:

```
persistence.xml
```

Example:

```
jdbc:mysql://localhost:3306/jpa_demo
username: root
password: system
```

### Step 3

Run the program:

```
Right Click → App.java → Run As → Java Application
```

Hibernate will automatically:

* create tables
* insert data
* execute CRUD operations

---

# 📚 Key Concepts Demonstrated

✔ Hibernate ORM
✔ JPA Persistence
✔ Entity Mapping
✔ One-to-One Relationship
✔ CRUD Operations
✔ JPQL Query
✔ DAO Design Pattern
✔ SQL Generation via Hibernate

---

# ✅ Assignment Completion Status

| Task               | Status      |
| ------------------ | ----------- |
| Hibernate Setup    | ✅ Completed |
| Entity Creation    | ✅ Completed |
| One-to-One Mapping | ✅ Completed |
| CRUD Operations    | ✅ Completed |
| JPQL Query         | ✅ Completed |
| Order Management   | ✅ Completed |
| LeetCode Algorithm | ✅ Completed |

---

