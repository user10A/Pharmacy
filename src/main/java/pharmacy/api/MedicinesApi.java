package pharmacy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pharmacy.model.Medicines;
import pharmacy.service.MedicinesService;

import java.util.List;

@RestController
@RequestMapping("/medicines")
@RequiredArgsConstructor
public class MedicinesApi {
    private final MedicinesService medicinesService;
    @GetMapping("/priceAsc")
    public List<Medicines> getAllPriceAsc(){
        return medicinesService.getAllPriceBySortAsc();
    }
    @GetMapping("/priceDesc")
    public List<Medicines> getAllPriceDesc(){
        return medicinesService.getAllPriceBySortDesc();
    }

}
