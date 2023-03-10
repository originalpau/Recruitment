package se.kth.iv1201.recruitment.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This is the application service class.
 */
@Service
@Transactional
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    /**
     * Get all applications from the repository.
     * @return a list of all applications.
     */
    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }
}
