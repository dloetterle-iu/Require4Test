package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "requirement")
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    public Requirement() {
    }

    public long getId() {
        return id;
    }
}
