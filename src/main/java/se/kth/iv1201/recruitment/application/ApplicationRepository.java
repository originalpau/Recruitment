package se.kth.iv1201.recruitment.application;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{

	List<Application> findAll();

}
