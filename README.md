# Two-Factor Authentication (2FA) Project

This is a simple web-based Two-Factor Authentication (2FA) system that provides an additional layer of security for user login. The system uses email-based OTPs (One-Time Passwords) for verifying the user’s identity in addition to the regular username and password authentication. The application is built using **Spring Boot**, **Spring Security**, and **JavaMail** for email functionality.

## Features

- **User Login**: Users can log in using their username and password.
- **OTP Generation**: A one-time password (OTP) is generated and sent to the user's email.
- **OTP Verification**: The user is required to input the OTP received via email to complete the login process.
- **Security**: Passwords are hashed using the BCrypt algorithm and OTPs are generated securely using **TOTP** (Time-based One-Time Passwords) or **randomized** method.

## Technologies Used

- **Java** - Programming language.
- **Spring Boot** - For backend and security configuration.
- **Spring Security** - For authentication and authorization.
- **Spring Mail** - For sending OTPs via email.
- **Thymeleaf** - For rendering HTML templates.
- **HMAC-SHA1** (TOTP) - For time-based OTP generation.
- **JavaMail API** - For sending OTP emails.

## Prerequisites

Before running this application, ensure you have the following installed:

- **Java 17+**
- **Maven** (for building and running the project)
- **SMTP Email Server** (e.g., Gmail, SendGrid, etc.)

## Setup Instructions

### 1. Clone the repository

Clone the repository to your local machine using:

```bash
https://github.com/prashanth-pkk/Two-Factor-Auth-Spring-boot.git

