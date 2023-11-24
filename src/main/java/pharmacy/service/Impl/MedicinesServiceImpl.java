package pharmacy.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pharmacy.model.Medicines;
import pharmacy.repo.MedicinesRepo;
import pharmacy.service.MedicinesService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class MedicinesServiceImpl implements MedicinesService {
    @Autowired
    private final MedicinesRepo medicinesRepo;
    @Override
    public void save(Medicines medicines) {
        medicinesRepo.save(medicines);
    }

    @Override
    public void update(Long id, Medicines medicines) {
        Medicines medicines1 =medicinesRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Medicines not found by id"+id));
        medicines1.setName(medicines.getName());
        medicines1.setPrice(medicines.getPrice());
        medicines1.setPharmacies(medicines.getPharmacies());
        medicinesRepo.save(medicines1);
    }

    @Override
    public void delete(Long id) {
        medicinesRepo.deleteById(id);
    }

    @Override
    public Medicines findById(Long id) {
        return medicinesRepo.findById(id).orElseThrow(()->new NoSuchElementException("Medicines not found by id"+id));
    }

    @Override
    public List<Medicines> getAllPriceBySortAsc() {
        return medicinesRepo.getAllPriceBySortAsc();
    }

    @Override
    public List<Medicines> getAllPriceBySortDesc() {
        return medicinesRepo.getAllPriceBySortDesc();
    }
}
