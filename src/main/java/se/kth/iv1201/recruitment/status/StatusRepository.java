package se.kth.iv1201.recruitment.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.kth.iv1201.recruitment.user.User;

@Repository
public interface StatusRepository extends JpaRepository<User, Long>{


	/**
	 * Returns the role with the specified name.
	 *
	 * @param name The name of the role.
	 * @return the role with the specified name, or null if there is no such role.
	 */
	Status findByName(String name);
}
