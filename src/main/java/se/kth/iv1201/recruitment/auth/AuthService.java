package se.kth.iv1201.recruitment.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.kth.iv1201.recruitment.role.Role;
import se.kth.iv1201.recruitment.role.RoleRepository;
import se.kth.iv1201.recruitment.user.User;
import se.kth.iv1201.recruitment.user.UserRepository;

/**
 * This is the authentication service class, handling login and registration.
 *
 * Declarative transaction management is used. A transaction starts when a method is called from
 * AuthController class, and ends (commit or rollback) when the method returns.
 * The @Transactional annotation enables ACID properties and because of the dependency spring-boot-starter-data-jpa,
 * Spring Transaction Management is enabled by default.
 */
@Service
@Transactional
@AllArgsConstructor
public class AuthService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with username %s not found";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Searches for the person with the specified username.
     * @param username The username of the person.
     * @return User information data.
     * @throws UsernameNotFoundException if the specified user wasn't found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
    }

    /**
     * Creates a new app user, with permissions of applicant.
     * Encodes the user password before saving the data to the database.
     *
     * @param userDTO The user information.
     * @return The newly created user.
     */
    public User register(AuthUserDTO userDTO) {

        Role applicant = roleRepository.findByName("applicant");

        User user = userDTO.toUser();
        user.setRole(applicant);
        encodePassword(user);

        return userRepository.save(user);
    }

    /**
     * Checks if the username already exists in our database.
     *
     * @param userDTO The user data object.
     * @return true if username exist, or false otherwise.
     */
    public boolean usernameExists(AuthUserDTO userDTO) {
        return userRepository.findByUsername(userDTO.getUsername()).isPresent();
    }

    /**
     * Checks if the email already exists in our database.
     *
     * @param userDTO The user data object.
     * @return true if the email exist, or false otherwise.
     */
    public boolean emailExists(AuthUserDTO userDTO) {
        return userRepository.findByEmail(userDTO.getEmail()).isPresent();
    }

    private void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}
