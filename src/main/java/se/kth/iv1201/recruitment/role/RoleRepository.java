package se.kth.iv1201.recruitment.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Contains all database access concerning roles.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Returns the role with the specified name.
     *
     * @param name The name of the role.
     * @return the role with the specified name, or null if there is no such role.
     */
    Role findByName(String name);
}
