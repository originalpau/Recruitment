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

@Service
@AllArgsConstructor
public class AuthService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with username %s not found";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
    }

    @Transactional
    public User register(AuthUserDTO userDTO) {
        if(userExists(userDTO)) {
            throw new IllegalStateException("email already taken");
        }

        Role applicant = roleRepository.findByName("applicant");

        User user = userDTO.toUser();
        user.setRole(applicant);
        encodePassword(user);

        return userRepository.save(user);
    }

    private boolean userExists(AuthUserDTO userDTO) {
        return userRepository.findByEmail(userDTO.getEmail()).isPresent();
    }

    private void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}
