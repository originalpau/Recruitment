package se.kth.iv1201.recruitment.application;


import lombok.*;
import se.kth.iv1201.recruitment.status.Status;
import se.kth.iv1201.recruitment.user.User;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "application")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_id")
	private Integer application_id;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
			  CascadeType.DETACH }, optional = false)
	@JoinColumn(name="status_id")
	private Status status;
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
			  CascadeType.DETACH }, optional = false)
	@JoinColumn(name="person_id")
	private User person_id;

}
