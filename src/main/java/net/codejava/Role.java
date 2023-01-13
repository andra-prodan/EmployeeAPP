package net.codejava;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    public Integer getId() {
        return id;
    }

    // remaining getters and setters
    public String getName() {
        return name;}

    public void setName(String id) {
        this.name = name;
    }

}