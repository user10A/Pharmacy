package pharmacy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pharmacy.model.Medicines;
import pharmacy.model.Pharmacy;
import pharmacy.model.Worker;
import pharmacy.service.PharmacyService;

import java.util.List;

@RestController
@RequestMapping("/pharmacies")
@RequiredArgsConstructor
public class PharmacyApi {
    private final PharmacyService pharmacyService;

    @PostMapping("/create")
    public Pharmacy save(@RequestBody Pharmacy pharmacy){
        pharmacyService.save(pharmacy);
        return pharmacy;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable  long id){
        pharmacyService.delete(id);
        return "deleted Pharmacy";
    }

    @PutMapping("/{id}")
    public Pharmacy update(@PathVariable long id,@RequestBody Pharmacy pharmacy){
        pharmacyService.update(id,pharmacy);
        return pharmacy;
    }

    @GetMapping("/{id}")
    public Pharmacy getById(@PathVariable long id){
        return pharmacyService.findById(id);
    }
    @GetMapping("/getAllMed/{pharmacyId}")
    public List<Medicines> getAllMedicines(@PathVariable long pharmacyId){
        return pharmacyService.getAllMedicinesByPharmacyId(pharmacyId);
    }
    @GetMapping("/getPWId/{workerId}")
    public Pharmacy getPWId(@PathVariable("workerId")long workerId){
        return pharmacyService.getPharmaciesByWorkersId(workerId);
    }
    @GetMapping("searchByPId/{pharmacyId}")
    public Pharmacy searchByPharmacyId(@PathVariable("pharmacyId")long pharmacyId){
        return pharmacyService.searchByPharmacyId(pharmacyId);
    }

}
