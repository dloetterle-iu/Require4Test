package require4test.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "test_run")
public class TestRun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    public TestRun() {
    }

    public long getId() {
        return id;
    }
}
