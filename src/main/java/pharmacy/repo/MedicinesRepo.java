package pharmacy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pharmacy.model.Medicines;

import java.util.List;

//@RepositoryRestResource(path = "medicines")
@Repository
public interface MedicinesRepo extends JpaRepository<Medicines,Long> {
@Query("Select m from Medicines m order by m.price asc ")
    List<Medicines>getAllPriceBySortAsc();
@Query("Select m from Medicines m order by m.price desc ")
    List<Medicines>getAllPriceBySortDesc() ;


}
