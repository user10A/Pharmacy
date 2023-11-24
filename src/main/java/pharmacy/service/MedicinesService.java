package pharmacy.service;

import pharmacy.model.Medicines;

import java.util.List;

public interface MedicinesService {
    void save (Medicines medicines);
    void update (Long id,Medicines medicines);
    void delete(Long id);
    Medicines findById(Long id);
    List<Medicines> getAllPriceBySortAsc();
    List<Medicines>getAllPriceBySortDesc();
}
