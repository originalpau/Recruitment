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

## Deployment

1. Create an account with Heroku
2. Login and create a new app with your Github repo and link a Heroku PostgreSQL database for plugin
3. Copy your local PostgreSQL database to Heroku with `heroku pg:push <local-db-name> <heroku-db-name> --app <app-name>`
4. Edit the `application.properties` configuration file with your heroku database url and create `system.properties` in root context and set your runtime java version.
5. Build application on Heroku
