# Journal Application

A secure, end-to-end encrypted journal application built with Spring Boot. This application provides a safe and private space for users to maintain their personal journals with robust security features.

## Features

- End-to-end encryption for journal entries
- Secure user authentication and authorization
- MongoDB database for data persistence
- Redis caching for improved performance
- JWT-based authentication
- Email service integration
- RESTful API architecture

## Tech Stack

- Java 17
- Spring Boot 3.3.6
- Spring Security
- Spring Data MongoDB
- Spring Data Redis
- JWT for authentication
- Lombok
- Maven
- MongoDB
- Redis

## Prerequisites

- Java 17 or higher
- Maven
- MongoDB
- Redis
- SMTP server (for email functionality)

## Getting Started

1. Clone the repository:
```bash
git clone https://github.com/TejasNeswi/Secure-Journal-Application.git
```

2. Configure the application:
   - Set up MongoDB connection
   - Configure Redis connection
   - Set up email service credentials
   - Configure JWT secret key


3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will start on the default port 8080.

## Security Features

- End-to-end encryption for journal entries
- Secure password hashing
- JWT-based authentication
- Role-based access control
- Rate limiting
- Input validation

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support, please open an issue in the repository or contact the development team. 