# Full-Stack Registration and Login Template with Spring Security

This project provides a template for implementing user registration and login functionality with validation using Spring Security. It serves as a foundation for building secure full-stack web applications. The template showcases the integration of Spring Security for authentication and authorization, along with validation mechanisms for user registration and login inputs.

## Project Overview

The Full-Stack Registration and Login Template aims to simplify the process of setting up user authentication and authorization in a web application. It utilizes the following technologies:

- **Spring Boot**: Provides the foundation for the application, making it easy to create stand-alone, production-grade Spring-based applications.
- **Spring Security**: Manages authentication and authorization, securing the application from unauthorized access.
- **Thymeleaf**: Used for server-side HTML templating, allowing dynamic content rendering and integration with Spring Security.
- **Hibernate Validator**: Implements validation constraints on user inputs, enhancing data integrity and security.
- **H2 Database**: An embedded in-memory database used for storing user data for demonstration purposes.

## Features

- **User Registration**: Users can register by providing a valid email and password. Passwords are securely hashed before being stored in the database.
- **Login**: Registered users can log in using their credentials.
- **Validation**: Input validation is implemented for both registration and login forms to ensure data integrity and security.
- **Security Configurations**: Includes a comprehensive Spring Security configuration to handle authentication, authorization, and security headers.

## How to Use

1. **Clone the Repository**: Start by cloning this repository to your local machine using the following command:
```bash
git clone https://github.com/ramiffer/SpringSecurityTemplate.git
```
2. **Build**: Navigate to the project directory and build the application using Maven:
```bash
cd SpringSecurityTemplate
```
3. **Access the Application**: Once the application is running, open a web browser and navigate to `http://localhost:8080` to access the registration and login pages.

4. **User Registration**: Click on the "Register" link to access the registration page. Fill in the required information, and upon successful registration, you'll be redirected to the login page.

5. **Login**: Use your registered username and password to log in.


## Notes

- The provided database is an embedded H2 database, meant for demonstration purposes. In a real-world scenario, you would replace it with a more robust database system.

- This template focuses on functionality and security fundamentals. You can extend and customize it to suit your specific application requirements.

- Don't forget to update the default security configurations and credentials when deploying this template in a production environment.


## Credits

This template was developed by **Ramiro Fernandez** and is available on [GitHub](https://github.com/ramiffer/SpringSecurityTemplate.git).

Feel free to use this template as a starting point for implementing secure registration and login functionality in your full-stack web applications. If you have any questions or suggestions, please don't hesitate to reach out. Happy coding!
<hr>
<p align="center">
  <img src="https://imgur.com/RPozFS4.png" alt="Logo" width="200" height="200">
</p>
