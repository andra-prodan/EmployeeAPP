package net.codejava;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean enabled;
	
	@Column(nullable = false, length = 45)
	private String email;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	@Column(name = "name", nullable = false, length = 20)
	private String name;

	@Column(name = "hourly_rate", nullable = true, length = 20)
	private String hourly_rate;

	@Column(name="start_date",nullable = true,length = 20)
	private String start_date;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();

	public Long getId() {
		return id;}


	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getRoles() {
		return roles;
	}

	public void setRoles(String name) {
		this.roles = roles;
	}


	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getHourly_rate() {
		return hourly_rate;
	}

	public void setHourly_rate(String hourly_rate) {
		this.hourly_rate = hourly_rate;
	}
}
