package pharmacy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pharmacy.model.Medicines;
import pharmacy.model.Pharmacy;
import pharmacy.service.MedicinesService;

import java.util.List;

@RestController
@RequestMapping("/medicines")
@RequiredArgsConstructor
public class MedicinesApi {
    private final MedicinesService medicinesService;
    @PostMapping("/create")
    public Medicines save(@RequestBody Medicines medicines){
         medicinesService.save(medicines);
        return medicines;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable  long id){
         medicinesService.delete(id);
        return "deleted";
    }

    @PutMapping("/{id}")
    public Medicines update(@PathVariable long id,@RequestBody Medicines medicines){
        medicinesService.update(id,medicines);
        return medicines;
    }

    @GetMapping("/{id}")
    public Medicines getById(@PathVariable Long id){
        return medicinesService.findById(id);
    }
    @GetMapping("/priceAsc")
    public List<Medicines> getAllPriceAsc(){
        return medicinesService.getAllPriceBySortAsc();
    }
    @GetMapping("/priceDesc")
    public List<Medicines> getAllPriceDesc(){
        return medicinesService.getAllPriceBySortDesc();
    }

}
