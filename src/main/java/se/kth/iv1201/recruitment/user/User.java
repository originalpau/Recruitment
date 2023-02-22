package se.kth.iv1201.recruitment.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import se.kth.iv1201.recruitment.role.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * User model class, modeling a user from the database and includes methods for asserting the validity of the account.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer id;
    private String name;
    private String surname;
    private String pnr;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
            CascadeType.DETACH }, optional = false)
    @JoinColumn(name="role_id")
    private Role role;

    public User(String name, String surname, String pnr, String email, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.pnr = pnr;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getName()));
    }

    /**
     * Get function for the password of the user.
     *
     * @return password of user
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Get function for the username of the user.
     *
     * @return username of user
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Validates that the account is still active. At this time, no account expires.
     *
     * @return true
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Validates that the account is not locked. At this time, no account is locked.
     *
     * @return true
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Validates that the account's password is not expired. At this time, no passwords expire.
     *
     * @return true
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Validates that the account is still enabled. At this time, no accounts stay enabled.
     *
     * @return true
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}