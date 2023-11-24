package pharmacy.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pharmacies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "p_gen")
    @SequenceGenerator(name = "p_gen",sequenceName = "p_sqn")
    private Long id;
    private String name;
    private String address;
    @ManyToMany
    @JoinTable(name = "pharmacy_medicines",
            joinColumns = @JoinColumn(name = "pharmacy_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<Medicines> medicines;
    @OneToMany(mappedBy = "pharmacy")
    private List<Worker>workers;
}
