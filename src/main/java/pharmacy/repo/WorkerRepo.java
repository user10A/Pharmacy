package pharmacy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pharmacy.model.Medicines;
import pharmacy.model.Worker;

import java.util.List;

@RepositoryRestResource(path = "workers")
public interface WorkerRepo extends JpaRepository<Worker,Long> {
    @Query("Select m from Worker m order by m.salary asc ")
    List<Worker> getAllSalaryBySortAsc();
    @Query("Select m from Worker m order by m.salary desc ")
    List<Worker>getAllSalaryBySortDesc();

    @Query("select p.workers from Pharmacy p where p.id=:pharmacyId")
    List<Worker> getAllWorkersByPharmacyId(@Param("pharmacyId") long pharmacyId);

}
