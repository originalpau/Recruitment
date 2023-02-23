# Recruitment application
This is a recruitment application for the course IV1201 Design of Global Applications. This is a platform where a recruiter can manage applications, and applicants can apply for a position.

## Development tools and frameworks
The project is based on Java Spring framework.
Spring boot and Maven has been used to facilitate configurations. The database is running Postgres SQL and is integrated into our program with JPA and Hibernate. Other frameworks used are Thymaleaf for the frontend, Lombok to reduce boilerplate code, Spring Security handles authentication, authorization, and protection for common attacks.

## Getting started

1. Clone the project
2. Navigate to `src/main/resources/scripts` and enter the command `psql -U postgres -d recruitment < database.sql` to download the database to your local postgres.
3. Set environmental variables in `src/main/resources/application.properties` if needed.
4. Reload (or import) the Maven project in IntelliJ
5. Start the application from `RecruitmentApplication.java` in IntelliJ
