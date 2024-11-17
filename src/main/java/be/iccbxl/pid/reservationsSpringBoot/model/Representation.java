package be.iccbxl.pid.reservationsSpringBoot.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.github.slugify.Slugify;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="representations")
public class Representation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="show_id", nullable=false)
    private Show show;

    /**
     * Date de création de la représentation
     */
    private LocalDateTime when;

    /**
     * Lieu de prestation de la représentation
     */
    @ManyToOne
    @JoinColumn(name="location_id", nullable=true)
    private Location location;

    @ManyToMany
    @JoinTable(
            name = "reservations",
            joinColumns = @JoinColumn(name = "representation_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

    public Representation() { }

    //…

    public List<User> getUsers() {
        return users;
    }

    public Representation addUser(User user) {
        if(!this.users.contains(user)) {
            this.users.add(user);
            user.addRepresentation(this);
        }

        return this;
    }

    public Representation removeUser(User user) {
        if(this.users.contains(user)) {
            this.users.remove(user);
            user.getRepresentations().remove(this);
        }

        return this;
    }

    @Override
    public String toString() {
        return "Representation [id=" + id + ", show=" + show + ", when=" + when
                + ", location=" + location + "]";
    }

}

