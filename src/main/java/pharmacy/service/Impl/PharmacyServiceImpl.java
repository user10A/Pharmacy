package pharmacy.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pharmacy.model.Medicines;
import pharmacy.model.Pharmacy;
import pharmacy.repo.PharmacyRepo;
import pharmacy.service.PharmacyService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService {
    @Autowired
    private final PharmacyRepo pharmacyRepo;
    @Override
    public void save(Pharmacy pharmacy) {
        pharmacyRepo.save(pharmacy);
    }

    @Override
    public void update(Long id, Pharmacy pharmacy) {
        Pharmacy pharmacy1 =pharmacyRepo.findById(id).orElseThrow(()-> new NoSuchElementException("Pharmacy not found by id"+id));
        pharmacy1.setName(pharmacy.getName());
        pharmacy1.setAddress(pharmacy.getAddress());
        pharmacy1.setWorkers(pharmacy.getWorkers());
        pharmacy1.setMedicines(pharmacy.getMedicines());
        pharmacyRepo.save(pharmacy1);
    }

    @Override
    public void delete(Long id) {
        pharmacyRepo.deleteById(id);
    }

    @Override
    public Pharmacy findById(Long id) {
        return pharmacyRepo.findById(id).orElseThrow(()-> new NoSuchElementException("Pharmacy not found by id"+id));
    }

    @Override
    public List<Medicines> getAllMedicinesByPharmacyId(long pharmacyId) {
        return pharmacyRepo.getAllMedicinesByPharmacyId(pharmacyId);
    }

    @Override
    public Pharmacy getPharmaciesByWorkersId(long workerId) {
        return pharmacyRepo.getPharmaciesByWorkersId(workerId);
    }

    @Override
    public Pharmacy searchByPharmacyId(long pharmacyId) {
        return pharmacyRepo.searchByPharmacyId(pharmacyId);
    }
}
