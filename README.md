# **Student Bank Application Documentation**  

## **Overview**  
The Student Bank Application is a Java-based system that simulates basic banking operations, including account creation, modification, deletion, balance checks, and transactions (deposit/withdrawal). It uses Hibernate ORM for database management and MySQL as the database system. Users interact via a command-line interface (CLI).  

## **Technologies Used**  
- **Java**: Core programming language for application logic.  
- **Hibernate**: ORM framework for database interactions.  
- **MySQL**: Relational database for storing account data.  
- **Eclipse IDE**: IDE used for development and code management.  
- **JDBC**: Database connectivity implemented via Hibernate.  
- **Spring Boot (Optional)**: Simplifies configurations if integrated.  

---

## **Project Structure**  

### **1. AccountDTO22 (DTO - Data Transfer Object)**  
Represents bank account data with the following properties:  
- **AccNumber**: Unique account number.  
- **Balance**: Current balance.  
- **Name**: Account holder’s name.  
- **PhoneNumber**: Associated phone number.  
Includes **getters** and **setters** for interaction.  

### **2. BankDAO22 (DAO - Data Access Object)**  
Handles database operations via Hibernate:  
- **Insert Account**: Create a new account.  
- **Delete Account**: Remove an account.  
- **Modify Account**: Update details (name, phone).  
- **Read Account**: Retrieve account details.  
- **Money Transaction**: Deposit or withdraw money.  

Uses **Session** and **Transaction** objects to manage persistence.  

### **3. App (Main Application)**  
Provides a command-line interface for user actions:  
- **Create Account**  
- **Delete Account**  
- **Modify Account**  
- **Check Details**  
- **Deposit/Withdraw Money**  
- **Exit Application**  

Interacts with BankDAO22 to execute user-selected operations.  

---

## **Setup Instructions**  

### **1. Install MySQL**  
Ensure MySQL is installed. Create a database named **StudentBank**.  

### **2. Set Up Hibernate**  
Edit **hibernate.cfg.xml** with MySQL credentials (username, password) and database URL.  

### **3. Configure Project**  
- Import the project into Eclipse IDE.  
- Add required Hibernate dependencies.  

### **4. Database Schema**  
Hibernate auto-generates database tables based on configuration mappings.  
Set **hbm2ddl.auto** to **update** in **hibernate.cfg.xml**.  

---

## **Usage**  

### **Running the Application**  
Run the **App** class to launch the CLI. Options include:  
- **Create New Account**: Enter account number, name, phone number, and balance.  
- **Delete Account**: Enter account number to delete.  
- **Modify Account**: Update name or phone number.  
- **Check Details**: View account information.  
- **Money Transactions**: Deposit or withdraw funds.  
- **Exit Program**: Close the application.  

### **Database Interaction**  
CRUD operations (Create, Read, Update, Delete) are performed through Hibernate ORM.  

---

## **Hibernate Configuration**  

### **hibernate.cfg.xml**  
Configures Hibernate properties, including:  
- **Database Connection**: URL, username, password.  
- **Dialect**: MySQL dialect.  
- **Mappings**: Links to **Account.hbm.xml**.  

### **Account.hbm.xml**  
Maps **AccountDTO22** class properties to the database table fields.  

---

## **Known Issues**  

### **1. Database Connectivity**  
Ensure the MySQL server is running and reachable.  

### **2. Input Validation**  
Minimal validation is implemented. Avoid invalid entries (e.g., incorrect account numbers).  

---

## **Contributing**  
Contributions are welcome!  

### **Steps to Contribute**:  
1. **Fork the repository.**  
2. **Create a new branch.**  
3. **Submit a pull request** 
