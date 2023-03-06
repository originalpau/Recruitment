package se.kth.iv1201.recruitment.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Contains all database access concerning roles.
 *
 * A transaction must already exist when the methods in this class is called.
 * If a transaction does not already exist, a runtime exception will be thrown.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Returns the role with the specified name.
     *
     * @param name The name of the role.
     * @return the role with the specified name, or null if there is no such role.
     */
    Role findByName(String name);
}
