package se.kth.iv1201.recruitment.application;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Contains all database access regarding applications.
 */
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{

	/**
	 * Returns a list of type Applications from database.
	 *
	 * @return all applications in database
	 */
	List<Application> findAll();

}
