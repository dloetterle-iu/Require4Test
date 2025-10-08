package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_2_user_role")
public class User2UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_role_id")
    private UserRole role;

    public User2UserRole() {
    }

    public long getId() {
        return id;
    }
}
