package se.kth.iv1201.recruitment.role;

import lombok.*;
import org.hibernate.Hibernate;
import se.kth.iv1201.recruitment.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Role model for authentication.
 *
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<User> users = new HashSet<>();

    /**
     * Compares the roles of users to the roles available to confirm authorization.
     *
     * @param o role of an object
     * @return boolean confirmed or denied authorization
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return id != null && Objects.equals(id, role.id);
    }

    /**
     * Get function for the hash code of the user set.
     *
     * @return hashcode of user
     */
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}