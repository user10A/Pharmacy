package pharmacy.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "medicines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicines {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "m_gen")
    @SequenceGenerator(name = "m_gen",sequenceName = "m_sqn")
    private Long id;
    private String name;
    @Min(value = 0, message = "Цена не может быть отрицательной")
    private double price;
    @ManyToMany(mappedBy = "medicines")
    private List<Pharmacy> pharmacies;

}
