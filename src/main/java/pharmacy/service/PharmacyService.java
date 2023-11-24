package pharmacy.service;

import org.springframework.data.repository.query.Param;
import pharmacy.model.Medicines;
import pharmacy.model.Pharmacy;

import java.util.List;

public interface PharmacyService {
    void save (Pharmacy pharmacy);
    void update (Long id,Pharmacy pharmacy);
    void delete(Long id);
    Pharmacy findById(Long id);
    List<Medicines> getAllMedicinesByPharmacyId(long pharmacyId);
    Pharmacy getPharmaciesByWorkersId(long workerId);
    Pharmacy searchByPharmacyId(long pharmacyId);

}
