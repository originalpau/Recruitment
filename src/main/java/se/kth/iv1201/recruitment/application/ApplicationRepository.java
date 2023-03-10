package se.kth.iv1201.recruitment.application;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Contains all database access regarding applications.
 *
 * A transaction must already exist when the methods in this class is called.
 * If a transaction does not already exist, a runtime exception will be thrown.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface ApplicationRepository extends JpaRepository<Application, Long>{

	/**
	 * Returns a list of type Applications from database.
	 *
	 * @return all applications in database
	 */
	List<Application> findAll();

}
