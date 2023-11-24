package pharmacy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pharmacy.model.Worker;
import pharmacy.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkerApi {
    private final WorkerService workerService;
    @GetMapping("/getAllSalaryBySortAsc")
    public List<Worker> getAllSalaryBySortAsc(){
        return workerService.getAllSalaryBySortAsc();
    }
    @GetMapping("/getAllSalaryBySortDesc")
    public List<Worker> getAllSalaryBySortDesc(){
        return workerService.getAllSalaryBySortDesc();
    }
    @GetMapping("/getAllWorkersByPharmacyId/{pharmacyId}")
    public List<Worker> getAllWorkersByPharmacyId(@PathVariable("pharmacyId") long pharmacyId){
        return workerService.getAllWorkersByPharmacyId(pharmacyId);
    }
}
