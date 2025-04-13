# 🧠 Code Error Checker

A simple, web-based Java code checker built with **Spring Boot**, **Thymeleaf**, and **Axios**. This app allows users to input Java code into a text area and receive real-time feedback on basic syntax issues like missing semicolons.

## ⚙️ Features

- 🌐 Web UI built with HTML, CSS, and JavaScript (Axios)
- 📥 Real-time error checking every 3 seconds using polling
- 📦 REST API with Spring Boot
- 🧪 Basic syntax validation (e.g., missing semicolons)
- 📄 Clear, user-friendly feedback interface

---

## 🏗️ Tech Stack

| Layer        | Tech                      |
|-------------|---------------------------|
| Backend      | Spring Boot               |
| Frontend     | HTML, CSS, JavaScript     |
| Templating   | Thymeleaf                 |
| HTTP Client  | Axios                     |

---

## 📁 Project Structure

```
code-error-checker/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── codechecker/
│       │               └── CodeCheckerController.java
│       └── resources/
│           ├── templates/
│           │   └── index.html
│           └── application.properties
├── pom.xml
├── README.md
└── .gitignore
```


---

## 🛠️ How It Works

### 1. Landing Page (`/`)
- Renders a simple form with a textarea for Java code input
- Users can submit their code manually or wait for polling

### 2. Code Submission (`/check-code`)
- Accepts a POST request with the code as JSON
- Returns a list of error messages (e.g., missing semicolon)

### 3. Validation Logic
- Currently checks if the code ends with a semicolon
- Easily extendable for more complex rules

---

## 🧪 Running the Project Locally

### Prerequisites

- Java 17+
- Maven

### Steps

```bash
# Clone the repository
git clone https://github.com/azzomi-dev/code-error-checker.git
cd code-error-checker

# Build and run the application
./mvnw spring-boot:run
