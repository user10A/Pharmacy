package pharmacy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pharmacy.model.Medicines;
import pharmacy.model.Pharmacy;

import java.util.List;

@RepositoryRestResource(path = "pharmacies")
public interface PharmacyRepo extends JpaRepository<Pharmacy,Long> {
    @Query("select p.medicines from Pharmacy p where p.id=:pharmacyId")
    List<Medicines> getAllMedicinesByPharmacyId(@Param("pharmacyId") long pharmacyId);
    @Query("select w.pharmacy from Worker w where w.id=:workerId" )
    Pharmacy getPharmaciesByWorkersId(@Param("workerId")long workerId);
    @Query("select p from Pharmacy p where p.id=:pharmacyId" )
    Pharmacy searchByPharmacyId(@Param("pharmacyId")long pharmacyId);


}
