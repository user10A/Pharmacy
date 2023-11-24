package pharmacy.service;

import org.springframework.data.repository.query.Param;
import pharmacy.model.Worker;

import java.util.List;

public interface WorkerService {
    void save (Worker worker);
    void update (Long id,Worker worker);
    void delete(Long id);
    Worker findById(Long id);
    List<Worker> getAllSalaryBySortAsc();
    List<Worker> getAllSalaryBySortDesc();
    List<Worker> getAllWorkersByPharmacyId(long pharmacyId);

}
