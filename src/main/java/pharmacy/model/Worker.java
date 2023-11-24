package pharmacy.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "workers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "work_gen")
    @SequenceGenerator(name = "work_gen",sequenceName = "work_sqn")
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private double salary;
    private String address;
    private LocalDate dateOfBirth;
    @ManyToOne
    private Pharmacy pharmacy;
}
