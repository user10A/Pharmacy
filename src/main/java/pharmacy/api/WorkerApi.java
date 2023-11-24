package pharmacy.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pharmacy.model.Worker;
import pharmacy.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkerApi {
    private final WorkerService workerService;
    @PostMapping("/create")
    public Worker save(@RequestBody Worker worker){
        workerService.save(worker);
        return worker;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable  long id){
        workerService.delete(id);
        return "deleted";
    }

    @PutMapping("/update/{id}")
    public Worker update(@PathVariable long id,@RequestBody Worker worker){
        workerService.update(id,worker);
        return worker;
    }

    @GetMapping("/get")
    public Worker getById(@RequestParam long id){
        return workerService.findById(id);
    }

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
