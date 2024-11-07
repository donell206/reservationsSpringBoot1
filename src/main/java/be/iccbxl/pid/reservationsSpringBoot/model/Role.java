package be.iccbxl.pid.reservationsSpringBoot.model;


import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String role;

    protected Role() {	}

    public Role(String role) {
        super();
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", role=" + role + "]";
    }

}
