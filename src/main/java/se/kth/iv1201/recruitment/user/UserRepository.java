package se.kth.iv1201.recruitment.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Contains all database access concerning app users.
 *
 * A transaction must already exist when the methods in this class is called.
 * If a transaction does not already exist, a runtime exception will be thrown.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Returns an Optional of type User if the user with specified username is found.
     *
     * @param username the username to search for.
     * @return an Optional of type User if the user with specified username is found, or else return an empty Optional.
     */
    Optional<User> findByUsername(String username);

    /**
     *  Returns an Optional of type User if the user with specified email is found.
     *
     * @param email the email to search for.
     * @return an Optional of type User if the user with specified email is found, or else return an empty Optional.
     */
    Optional<User> findByEmail(String email);
}

