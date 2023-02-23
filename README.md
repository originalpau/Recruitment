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

## Links
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.8/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.8/maven-plugin/reference/html/#build-image)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/2.7.8/reference/htmlsingle/#io.webservices)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.7.8/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.7.8/reference/htmlsingle/#web.security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.8/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

