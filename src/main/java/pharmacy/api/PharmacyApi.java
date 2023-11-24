package pharmacy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pharmacy.model.Medicines;
import pharmacy.model.Pharmacy;
import pharmacy.service.PharmacyService;

import java.util.List;

@RestController
@RequestMapping("/pharmacies")
@RequiredArgsConstructor
public class PharmacyApi {
    private final PharmacyService pharmacyService;
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
